package mall.shoppingMall.Domain;


import lombok.*;
import mall.shoppingMall.Domain.Define.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //무조건 lazy 사용 (필요할때 가지고오라는 뜻) eager = 한번에 다 가지고 오는 것
    @JoinColumn(name= "member_id")
    private Member member;

    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItem = new ArrayList<>();

    private LocalDateTime orderDate;
    private Status status;
    private String coupon;
    private int totalCount;
    private int totalPrice;

    public static Orders createOrder(LocalDateTime orderDate, Status status, int totalCount, int totalPrice){
        Orders orders = new Orders();
        orders.orderDate = orderDate;
        orders.status = status;
        orders.totalCount = totalCount;
        orders.totalPrice = totalPrice;

        return orders;
    }

    public static Orders createOrder(LocalDateTime orderDate, Status status, String coupon, int totalCount, int totalPrice){
        Orders orders = new Orders();
        orders.orderDate = orderDate;
        orders.status = status;
        orders.coupon = coupon;
        orders.totalCount = totalCount;
        orders.totalPrice = totalPrice;

        return orders;
    }

    //편의 메서드 : 데이터베이스 불러 왔을 때 연결된 애들이랑 같이 불러와지는 애들 (1차 캐시 플러쉬 되기 전에) => 값이 궁금하기 때문에
    protected void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
}
