package mall.shoppingMall.Domain;

import lombok.*;
import mall.shoppingMall.Domain.Define.ItemType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString//모든 객체를 렌더링 할 수 있어야 하는 상황에 유용
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터 없
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private Long id;

    private String name;
    private Long receiptId;
    private ItemType itemType;
    private int price;
    private int stockQuantity;

    public static Items createItem(String name, ItemType itemType, int price, int stockQuantity) {
        Items item = new Items();
        item.name = name;
        item.itemType = itemType;
        item.price = price;
        item.stockQuantity = stockQuantity;

        return item;
    }
}
