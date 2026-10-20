package task2;

import java.math.BigDecimal;

public class WholesaleDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal amount = order.totalAmount();
        if (amount.compareTo(new BigDecimal("1000.00")) >= 0) {
            return amount.multiply(new BigDecimal("0.20"));
        } else {
            return amount.multiply(new BigDecimal("0.10"));
        }
    }
}
