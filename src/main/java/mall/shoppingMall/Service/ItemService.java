package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import mall.shoppingMall.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //service의 필수
public class ItemService {

    private final ItemRepository itemRepository;

    public void save(Items items){
        itemRepository.save(items);}

    public Items findOne(Long id){ return itemRepository.findOne(id);}

    public List<Items> findAll(){return itemRepository.findAll();}
}
