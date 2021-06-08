package mall.shoppingMall.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//many to many 사용대신 새로운 클래스 만들어주기
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int itemCount;
    private int itemTotalPrice;

    protected OrderItem(){

    }

    public OrderItem(Orders orders, Item item, int itemCount, int itemTotalPrice) {
        this.orders = orders;
        this.item = item;
        this.itemCount = itemCount;
        this.itemTotalPrice = itemTotalPrice;
    }
}
