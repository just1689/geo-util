package za.co.captain.framework.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRSTScore {

    private TransactionRST transaction;
    private int score;

}
