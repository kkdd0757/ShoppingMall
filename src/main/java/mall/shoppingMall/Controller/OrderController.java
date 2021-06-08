package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Domain.Orders;
import mall.shoppingMall.Service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/history")
    public String historyPage(@RequestParam(name = "id") Long id, Model model) {
        List<Orders> orderList = orderService.findHistory();
        model.addAttribute("orderList", orderList);

        return "history";
    }
}
