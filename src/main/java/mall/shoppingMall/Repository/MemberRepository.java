package mall.shoppingMall.Repository;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){em.persist(member);}

    public Member findOne(Long id){return em.find(Member.class, id);}

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findByLoginId(String loginId){
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultStream().findFirst();
    }

}
