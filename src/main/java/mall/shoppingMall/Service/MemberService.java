package mall.shoppingMall.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Members;
import mall.shoppingMall.Repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;


    public void join(Members member) {
        validateDuplicateMember(member);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.changePassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
    }

    public Members findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Members> findAll() {
        return memberRepository.findAll();
    }

    //아이디로 찾기
    public Members findByLoginId(String loginId) {
        Optional<Members> member = memberRepository.findByLoginId(loginId);
        if (member.isEmpty()) {
            return null;
        }
        return memberRepository.findOne(member.get().getId());
    }

    //가입
    private void validateDuplicateMember(Members member) {
        Optional<Members> loginId = memberRepository.findByLoginId(member.getLoginId());
        if (loginId.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Members> userEntityWrapper = memberRepository.findByLoginId(username);
        if (userEntityWrapper.isEmpty()) {
            throw new UsernameNotFoundException("존재하는 회원이 없습니다.");
        }
        Members userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
        }

        return new User(userEntity.getLoginId(), userEntity.getPassword(), authorities);
    }
}
