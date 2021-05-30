package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //service의 필수
public class ItemService {

    private final ItemRepository itemRepository;

    public void save(Item item){
        itemRepository.save(item);}

    public Item findOne(Long id){ return itemRepository.findOne(id);}

    public List<Item> findAll(){return itemRepository.findAll();}

    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }

    public List<Item> getSearchList(String name) {
        return itemRepository.getSearchList();
    }
}
