package task2;

public enum CustomerCategory {
    REGULAR(new RegularDiscountStrategy()),
    VIP(new VipDiscountStrategy()),
    WHOLESALE(new WholesaleDiscountStrategy()),
    EMPLOYEE(new EmployeeDiscountStrategy()),
    STUDENT(new StudentDiscountStrategy());

    final DiscountStrategy discountStrategy;

    CustomerCategory(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
}
