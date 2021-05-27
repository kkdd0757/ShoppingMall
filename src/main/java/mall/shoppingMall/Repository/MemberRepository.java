package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Members;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Members members){em.persist(members);}

    public Members findOne(Long id){return em.find(Members.class, id);}

    public List<Members> findAll(){
        return em.createQuery("select m from Members m", Members.class)
                .getResultList();
    }

    public Optional<Members> findByLoginId(String loginId){
        return em.createQuery("select m from Members m where m.loginId = :loginId", Members.class)
                .setParameter("loginId", loginId)
                .getResultStream().findFirst();
    }

}
