package za.co.captain.framework.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRSTWithDistance {

    private BigDecimal distance;
    private TransactionRST item;

    public TransactionRSTWithDistance(TransactionRST primary, TransactionRST item) {
        this.item = item;
        this.distance = primary.distanceTo(item);
    }

}
