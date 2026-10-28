package lab8;

public final class HighSeasonPricingPolicy implements SeasonPricingPolicy {
    private static final double MULTIPLIER = 1.25;

    @Override public String getSeasonName() { return "High"; }

    @Override public double calculatePrice(double basePricePerNight, int nights) {
        return basePricePerNight * nights * MULTIPLIER;
    }
}
