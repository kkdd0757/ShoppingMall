package mall.shoppingMall.Domain;

import lombok.*;
import mall.shoppingMall.Domain.Define.Grade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders = new ArrayList<>();

    private String name;
    private Grade grade;
    private String loginId;
    private String password;

    public static Member createMember(String name, Grade grade, String loginId, String password){
        Member member = new Member();
        member.grade = grade;
        member.name = name;
        member.loginId = loginId;
        member.password = password;

        return member;
    }

    public static Member createMember(String name, String loginId, String password){
        Member member = new Member();
        member.name = name;
        member.loginId = loginId;
        member.password = password;

        return member;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public Member toEntity(){ return Member.createMember(name, loginId, password);}
}
