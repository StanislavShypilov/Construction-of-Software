package hotelbooking;

/** Абстракція сезонного алгоритму ціноутворення (Protected Variations). */
public interface SeasonPricingPolicy {
    String getSeasonName();
    double calculatePrice(double basePricePerNight, int nights);
}
