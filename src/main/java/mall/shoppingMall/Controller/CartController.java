package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Define.Status;
import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Domain.OrderItem;
import mall.shoppingMall.Domain.Orders;
import mall.shoppingMall.Service.CartService;
import mall.shoppingMall.Service.ItemService;
import mall.shoppingMall.Service.OrderItemService;
import mall.shoppingMall.Service.OrderService;
import org.apache.tomcat.jni.Local;
import org.hibernate.criterion.Order;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ItemService itemService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @ResponseBody //정보가지고옴 (데이터 보내주고 받아오는것)
    @PostMapping("/product/cart")
    public Map<String, Object> inputCart(@RequestBody Map<String, Object> param) {

        Long id = Long.parseLong((String) param.get("id"));
        System.out.println(id);

        Item item = itemService.findOne(id); //해당 아이템 찾기
        cartService.insert(item); //저장
        List<Item> itemList = cartService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("list", itemList);

        return map;
    }

    @GetMapping("/cart") //페이지 보여주기 - 메모리에 올려두면 싱글톤이 되버림, 세션을 활용해야함
    public String cartPage(Model model) {
        List<Item> itemList = cartService.findAll();
        model.addAttribute("itemList", itemList);

        return "cart"; //thymeleaf의 기본 디렉토리 : templates/##.html
    }

    @PostMapping("/payment")
    @ResponseBody // 메세지 바디로 응답
    public Map<String, Object> payment(@RequestBody Map<String, List<Map<String,Integer>>> map) {

       List<Map<String,Integer>> params = map.get("params");

        LocalDateTime orderDate = LocalDateTime.now();
        Status status = Status.P;
        int totalCount = 0;
        int totalPrice = 0;

        for (int i = 0; i < params.size(); i++) {
            Long id = Long.valueOf(params.get(i).get("itemId"));
            int quantity = params.get(i).get("quantity");
            int price = params.get(i).get("price");

            totalCount += quantity;
            totalPrice += quantity * price;
        }
        Orders order = Orders.createOrder(orderDate, status, totalCount, totalPrice);
        orderService.save(order);

        for (int i = 0; i < params.size(); i++) {
           Item item = itemService.findOne(Long.valueOf(params.get(i).get("itemId")));
           int itemCount = params.get(i).get("quantity");
           int itemTotalPrice = itemCount * params.get(i).get("price");

            OrderItem orderItem = new OrderItem(order, item, itemCount, itemTotalPrice);
            orderItemService.save(orderItem);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("code",200);
        res.put("message","결제에 성공했습니다.");

        return res;
    }

}


