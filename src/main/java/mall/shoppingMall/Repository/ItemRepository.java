package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {em.persist(item);}

    public Item findOne(Long id){return em.find(Item.class, id);}

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.name LIKE :name", Item.class)
                .setParameter("name", '%' + name + '%')
                .getResultList();
    }

    public List<Item> getSearchList() {
        return em.createQuery("select i from Item i order by i.name desc", Item.class)
                .setFirstResult(0)
                .getResultList();
    }

//    public void updateStockQuantity(Long id) {
//        Items item = em.find(Items.class, id);
//        item.plusSearchCount();
//    }
}
