package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Items;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemsRepository {

    private final EntityManager em;

    public void save(Items items) {em.persist(items);}

    public Items findOne(Long id){return em.find(Items.class, id);}

    public List<Items> findAll(){
        return em.createQuery("select i from Items i", Items.class)
                .getResultList();
    }//queryDsl
}
