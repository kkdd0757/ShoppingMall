package mall.shoppingMall.Domain;

import lombok.*;
import mall.shoppingMall.Domain.Define.ItemType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@ToString//데이터를 알고싶을때 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED) //파라미터 없
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> order = new ArrayList<>();

    private String imageUrl;
    private String descUrl;
    private String name;
    private int price;
    private int stockQuantity;

    public static Item createItem(String name, int price, int stockQuantity, String imageUrl, String descUrl) {
        Item item = new Item();
        item.imageUrl = imageUrl;
        item.descUrl = descUrl;
        item.name = name;
        item.price = price;
        item.stockQuantity = stockQuantity;

        return item;
    }

    public void minusStockQuantity(int stockQuantity) {
        this.stockQuantity -= stockQuantity;
    }


}
