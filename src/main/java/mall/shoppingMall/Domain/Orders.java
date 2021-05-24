package mall.shoppingMall.Domain;


import lombok.*;
import mall.shoppingMall.Domain.Define.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long id;

    private Long memberId;
    private LocalDateTime orderDate;
    private Status status;
    private String coupon;

    public static Orders createOrder(LocalDateTime orderDate, Status status){
        Orders order = new Orders();
        order.orderDate = orderDate;
        order.status = status;

        return order;
    }

    public static Orders createOrder(LocalDateTime orderDate, Status status, String coupon){
        Orders order = new Orders();
        order.orderDate = orderDate;
        order.status = status;
        order.coupon = coupon;

        return order;
    }
}
