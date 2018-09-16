package za.co.captain.framework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.captain.framework.util.MathUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionRST {

    private String id;
    private BigDecimal lon;
    private BigDecimal lat;
    private Date tim;
    private BigDecimal amount;

    private boolean morning;
    private boolean midday;
    private boolean evening;

    private boolean weekend;

    public BigDecimal distanceTo(TransactionRST other) {

        BigDecimal inner = getLon().subtract(other.getLon()).pow(2).add(getLat().subtract(other.getLat()).pow(2));
        return MathUtil.sqrt(inner);

    }

    public int countClosest(ArrayList<TransactionRST> all, BigDecimal nearEnough) {
        int closeEnough = 0;

        for (TransactionRST item : all) {
            BigDecimal distanceTo = this.distanceTo(item);
            if (distanceTo.compareTo(nearEnough) < 0 && distanceTo.compareTo(BigDecimal.ZERO) != 0) {
                closeEnough++;
            }
        }
        return closeEnough;

    }
}
