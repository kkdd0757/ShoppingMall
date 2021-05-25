package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Members;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Members members){em.persist(members);}

    public Members findOne(Long id){return em.find(Members.class, id);}

    /*public List<Members> findAll(){
        return em.createQuery("select m from Members m", Members.class)
                .getResultList();
    }*/

}
