package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Domain.Orders;
import mall.shoppingMall.Service.CartService;
import mall.shoppingMall.Service.ItemService;
import mall.shoppingMall.Service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @ResponseBody //정보가지고옴 (데이터 보내주고 받아오는것)
    @PostMapping("/product/cart")
    public Map<String, Object> inputCart(@RequestBody Map<String, Object> param) {

        Long id = Long.parseLong((String) param.get("id"));
        //(Long)param.get("id");
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
    public String payment(@RequestBody Map<String,Object> map) {
//        Long id = Long.parseLong((String) param.get("id"));
//        map.get("params", param);
//        param
//        orderService.save();

        return "redirect:/cart";
    }
}


