package task2;

import java.math.BigDecimal;

public class EmployeeDiscountStrategy implements DiscountStrategy {
    @Override
    public BigDecimal calculate(Order order) {
        return order.totalAmount().multiply(new BigDecimal("0.30"));
    }
}
