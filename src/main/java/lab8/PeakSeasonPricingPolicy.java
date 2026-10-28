package lab8;

public final class PeakSeasonPricingPolicy implements SeasonPricingPolicy {
    private static final double MULTIPLIER = 1.50;

    @Override public String getSeasonName() { return "Peak"; }

    @Override public double calculatePrice(double basePricePerNight, int nights) {
        return basePricePerNight * nights * MULTIPLIER;
    }
}
