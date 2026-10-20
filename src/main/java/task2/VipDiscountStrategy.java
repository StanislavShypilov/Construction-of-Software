package task2;

import java.math.BigDecimal;

public class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculate(Order order) {
        BigDecimal amount = order.totalAmount();
        BigDecimal discount = amount.multiply(new BigDecimal("0.15"));
        if (order.itemCount() > 5) {
            discount = discount.add(amount.multiply(new BigDecimal("0.05")));
        }
        return discount;
    }
}
