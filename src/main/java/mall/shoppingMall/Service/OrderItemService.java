package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.OrderItem;
import mall.shoppingMall.Domain.Orders;
import mall.shoppingMall.Repository.OrderItemRepository;
import mall.shoppingMall.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public void save(OrderItem orderItem){
        orderItemRepository.save(orderItem);
    }

    public OrderItem findOne(Long id){
        return orderItemRepository.findOne(id);
    }

    public List<OrderItem> findAll(){
        return orderItemRepository.findAll();
    }
}
