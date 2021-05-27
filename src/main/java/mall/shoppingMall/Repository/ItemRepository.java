package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Items items) {em.persist(items);}

    public Items findOne(Long id){return em.find(Items.class, id);}

    public List<Items> findAll(){
        return em.createQuery("select i from Items i", Items.class)
                .getResultList();
    }

    public List<Items> findByName(String name) {
        return em.createQuery("select i from Items i where i.name LIKE :name", Items.class)
                .setParameter("name", '%' + name + '%')
                .getResultList();
    }

    public List<Items> getSearchList() {
        return em.createQuery("select i from Items i order by i.name desc", Items.class)
                .setFirstResult(0)
                .getResultList();
    }

//    public void updateStockQuantity(Long id) {
//        Items item = em.find(Items.class, id);
//        item.plusSearchCount();
//    }
}
