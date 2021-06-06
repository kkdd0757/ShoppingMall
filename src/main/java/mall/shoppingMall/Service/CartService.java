package mall.shoppingMall.Service;

import mall.shoppingMall.Domain.Item;
import mall.shoppingMall.Repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void insert(Item item) {
        cartRepository.insert(item);
    }

    public void delete(Item item) {
        cartRepository.delete(item);
    }

    public List<Item> findAll() {
        return cartRepository.findAll();
    }

    public void reset(){
        cartRepository.reset();
    }


}
