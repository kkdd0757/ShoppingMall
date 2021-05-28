package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Orders orders){em.persist(orders);}

    public Orders findOne(Long id){ return em.find(Orders.class, id);}

    public List<Orders> findAll(Long id){
        return em.createQuery("select o from Orders o", Orders.class)
                .getResultList();
    }

}
