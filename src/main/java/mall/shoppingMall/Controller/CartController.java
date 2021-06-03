package mall.shoppingMall.Controller;

import mall.shoppingMall.Domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @ResponseBody
    @PostMapping("/product/cart")
    public Map<String,Object> inputCart(@RequestBody Map<String, Object> param){
        System.out.println(param.get("id"));
        Map<String,Object> map = new HashMap<>();
        List<Item> item = new ArrayList<>();
        map.put("list", item);

        return map;
    }

}
