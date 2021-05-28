package mall.shoppingMall.Service;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Member;
import mall.shoppingMall.Repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;


    public void join(Member member) {
        validateDuplicateMember(member);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.changePassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //아이디로 찾기
    public Member findByLoginId(String loginId) {
        Optional<Member> member = memberRepository.findByLoginId(loginId);
        if (member.isEmpty()) {
            return null;
        }
        return memberRepository.findOne(member.get().getId());
    }

    //가입
    private void validateDuplicateMember(Member member) {
        Optional<Member> loginId = memberRepository.findByLoginId(member.getLoginId());
        if (loginId.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> userEntityWrapper = memberRepository.findByLoginId(username);
        if (userEntityWrapper.isEmpty()) {
            throw new UsernameNotFoundException("존재하는 회원이 없습니다.");
        }
        Member userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
        }

        return new User(userEntity.getLoginId(), userEntity.getPassword(), authorities);
    }
}
