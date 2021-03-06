package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ItemService itemService;

    @GetMapping("/")
    public String mainPage(){ return "home";}

//    @GetMapping("/itemList")
//    public String itemListPage(Model model){
//        List<Items> itemList = itemService.findAll();
//        model.addAttribute("itemList", itemList);
//        return "itemList";
//    }

//    @PostMapping("/saveItem")
//    public String saveItemPage(@RequestParam String itemName,
//                               @RequestParam ItemType itemType,
//                               @RequestParam int itemPrice,
//                               @RequestParam int stockQuantity){
//        itemService.save(Items.createItem(itemName,itemType,itemPrice, stockQuantity));
//        return "redirect:/";
//    }
}
