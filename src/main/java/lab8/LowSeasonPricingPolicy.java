package lab8;

public final class LowSeasonPricingPolicy implements SeasonPricingPolicy {
    private static final double MULTIPLIER = 0.90;

    @Override public String getSeasonName() { return "Low"; }

    @Override public double calculatePrice(double basePricePerNight, int nights) {
        return basePricePerNight * nights * MULTIPLIER;
    }
}
