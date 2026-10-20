package task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountCalculator {
    public BigDecimal calculateDiscount(Order order, CustomerCategory category) {
        DiscountStrategy strategy = category.getDiscountStrategy();
        BigDecimal discount = strategy.calculate(order).setScale(2, RoundingMode.HALF_UP);
        System.out.println("[DISCOUNT] Замовлення " + order.orderId() + ": Категорія=" + category + ", Розрахована знижка=$" + discount);
        return discount;
    }
}
