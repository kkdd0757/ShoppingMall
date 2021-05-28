package mall.shoppingMall.Controller;

import lombok.RequiredArgsConstructor;
import mall.shoppingMall.Domain.Member;
import mall.shoppingMall.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @PostMapping("/join")
    public String join(Member member) {
        memberService.join(member.toEntity());

        return "redirect:/login";
    }
}
//    //회원가입
//    @GetMapping("/user/signup")
//    public String dispSignup(){
//        return "join";
//    }
//
//    //회원가입 처리
//    @PostMapping("/user/signup")
//    public String execSignup(MemberRepository memberRepository){
//        /*memberService.joinMember(memberRepository);*/
//
//        return "redirect:/user/login";
//    }
//
//    //로그인페이지
//    @GetMapping("/user/login")
//    public String dispLogin(){
//        return "login";
//    }
//
//    //로그인 결과 페이지
//    @GetMapping("/user/login/result")
//    public String dispLoginResult(){
//        return "home";
//    }
//
//    //로그아웃 결과 페이지
//    @GetMapping("/user/logout/result")
//    public String dispLogout(){
//        return "home";
//    }
//
//    //접근 거부 페이지
//    @GetMapping("/user/denied")
//    public String dispDenied(){
//        return "denied";
//    }
//
//    //my page
//    @GetMapping("/user/info")
//    public String dispMyInfo(){
//        return "myInfo";
//    }

