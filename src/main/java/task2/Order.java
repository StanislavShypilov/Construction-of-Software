package task2;

import java.math.BigDecimal;

public record Order(String orderId, BigDecimal totalAmount, int itemCount, boolean isFirstOrder) {}
