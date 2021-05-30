package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/searchList")
    public String searchPage(@RequestParam(value = "item") String name, Model model) {
        List<Item> itemList = itemService.getSearchList(name);
        model.addAttribute("list", itemList);
        return "searchList";
    }

    @GetMapping("/productDetail")
    public String productDetail(@RequestParam(value = "item") Long id, Model model) {
        Item item = itemService.findOne(id);
        model.addAttribute("item", item);

        return "productDetail";
    }
}
