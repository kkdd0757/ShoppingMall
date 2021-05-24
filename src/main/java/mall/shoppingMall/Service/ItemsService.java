package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import mall.shoppingMall.Repository.ItemsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //service의 필수
public class ItemsService {

    private final ItemsRepository itemsRepository;

    public void save(Items items){itemsRepository.save(items);}

    public Items findOne(Long id){ return itemsRepository.findOne(id);}

    public List<Items> findAll(){return itemsRepository.findAll();}
}
