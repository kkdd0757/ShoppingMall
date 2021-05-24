package mall.shoppingMall.Domain;

import lombok.*;
import mall.shoppingMall.Domain.Define.Grade;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String name;
    private Grade grade;
    private String loginId;
    private String password;

    public static Members createMember(String name, Grade grade, String loginId, String password){
        Members member = new Members();
        member.grade = grade;
        member.name = name;
        member.loginId = loginId;
        member.password = password;

        return member;
    }
}
