package mall.shoppingMall.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
public class MemberService /*implements UserDetailsService*/ {

    private final MemberRepository memberRepository;


//
//    public Long joinMember(MemberRepository memberRepository) {
//        //비밀번호 암호화
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        memberRepository.setPassword(passwordEncoder.encode(memberRepository.getPassword()));
//
//        return memberRepository.save(memberRepository.toEntity()).getId();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//        Optional<MemberEntity> userENtityWrapper = memberRepository.findById(loginId);
//        MemberEntity memberEntity = userENtityWrapper.get();
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if(("admin@example.com").equals(loginId)){
//            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        }else{
//            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//        }
//        return new User(memberEntity.getLoginId(), memberEntity.getPassword(), authorities);
//    }
}
