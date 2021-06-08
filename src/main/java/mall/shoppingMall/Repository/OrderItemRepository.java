package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.OrderItem;
import mall.shoppingMall.Domain.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemRepository {

    private final EntityManager em;

    public void save(OrderItem orderItem){em.persist(orderItem);}

    public OrderItem findOne(Long id){ return em.find(OrderItem.class, id);}

    public List<OrderItem> findAll(){
        return em.createQuery("select o from OrderItem o", OrderItem.class)
                .getResultList();
    }

}
