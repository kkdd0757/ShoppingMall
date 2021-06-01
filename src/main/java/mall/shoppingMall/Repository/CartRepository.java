package mall.shoppingMall.Repository;

import mall.shoppingMall.Domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    private List<Item> items = new ArrayList<>();

    public void insert(Item item) {
        items.add(item);
    }

    public void delete(Item item) {
        items.remove(item);
    }

    public List<Item> findAll() {
        return items;
    }

    public void reset(){
        items.clear();
    }
}
