package mall.shoppingMall.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Receipts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiptId")
    private Long id;

    private Long orderId;
    private int totalPrice;
    private int totalCount;

    public static Receipts createReceipt(int totalCount, int totalPrice){
        Receipts receipt = new Receipts();
        receipt.totalCount = totalCount;
        receipt.totalPrice = totalPrice;

        return receipt;
    }
}
