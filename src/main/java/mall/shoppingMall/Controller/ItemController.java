package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import mall.shoppingMall.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/itemList")
    public String searchPage(Model model) {
        List<Items> itemsList = itemService.getSearchList();
        model.addAttribute("list", itemsList);
        return "searchList";
    }
}
