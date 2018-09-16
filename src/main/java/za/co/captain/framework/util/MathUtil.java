package za.co.captain.framework.util;

import java.math.BigDecimal;

public class MathUtil {

    public static BigDecimal sqrt(BigDecimal value) {
        //This is bad
        return new BigDecimal(Math.sqrt(value.doubleValue()));
    }

}
