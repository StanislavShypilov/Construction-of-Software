package lab8;

public class PeakSeason implements Season {
    @Override
    public String getName() {
        return "Peak";
    }

    @Override
    public double getMultiplier() {
        return 1.5;
    }
}
