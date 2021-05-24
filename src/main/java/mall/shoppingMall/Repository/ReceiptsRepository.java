package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Receipts;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReceiptsRepository {

    private final EntityManager em;

    public void save(Receipts receipts){ em.persist(receipts);}

    public Receipts findOne(Long id){return em.find(Receipts.class,id);}

    public List<Receipts> findAll(){
        return em.createQuery("select r from Receipts r", Receipts.class)
                .getResultList();
    }
}
