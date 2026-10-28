package lab8;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

/** Фабрика вибирає реалізацію політики; розрахунок делегується поліморфно. */
public final class SeasonPricingPolicies {
    private static final Map<String, Supplier<SeasonPricingPolicy>> POLICIES = Map.of(
            "LOW", LowSeasonPricingPolicy::new,
            "HIGH", HighSeasonPricingPolicy::new,
            "PEAK", PeakSeasonPricingPolicy::new
    );

    private SeasonPricingPolicies() { }

    public static SeasonPricingPolicy forSeason(String season) {
        if (season == null) {
            throw new IllegalArgumentException("Сезон не може бути порожнім.");
        }
        Supplier<SeasonPricingPolicy> supplier = POLICIES.get(season.trim().toUpperCase(Locale.ROOT));
        if (supplier == null) {
            throw new IllegalArgumentException("Невідомий сезон. Використайте Low, High або Peak.");
        }
        return supplier.get();
    }
}
