package hotelbooking;

/** Контракт для змінної політики туристичного збору. */
public interface TouristTaxPolicy {
    double calculate(double roomTotal, double servicesTotal);
}
