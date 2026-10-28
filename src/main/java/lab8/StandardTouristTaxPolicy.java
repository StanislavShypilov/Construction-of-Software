package lab8;

/** Поточне правило: туристичний збір становить 1% від проживання та послуг. */
public final class StandardTouristTaxPolicy implements TouristTaxPolicy {
    private static final double RATE = 0.01;

    @Override public double calculate(double roomTotal, double servicesTotal) {
        return (roomTotal + servicesTotal) * RATE;
    }
}
