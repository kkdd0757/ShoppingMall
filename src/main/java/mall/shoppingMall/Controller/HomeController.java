package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import mall.shoppingMall.Service.ItemsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemsService itemsService;

    @GetMapping("/")
    public String mainPage(){ return "home";}

    @GetMapping("/itemList")
    public String itemListPage(Model model){
        List<Items> itemList = itemsService.findAll();
        model.addAttribute("itemList", itemList);
        return "itemList";
    }
}
