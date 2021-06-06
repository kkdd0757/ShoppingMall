package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Orders;
import mall.shoppingMall.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(Orders order){
        orderRepository.save(order);
    }

    public Orders findOne(Long id){
        return orderRepository.findOne(id);
    }

    public List<Orders> findAll(){
        return orderRepository.findAll();
    }

}
