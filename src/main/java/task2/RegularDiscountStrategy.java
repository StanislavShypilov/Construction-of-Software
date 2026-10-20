package task2;

import java.math.BigDecimal;

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal amount = order.totalAmount();
        if (order.isFirstOrder()) {
            return amount.multiply(new BigDecimal("0.10"));
        } else if (amount.compareTo(new BigDecimal("100.00")) >= 0) {
            return amount.multiply(new BigDecimal("0.05"));
        }
        return BigDecimal.ZERO;
    }
}
