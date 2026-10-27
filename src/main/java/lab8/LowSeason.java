package lab8;

public class LowSeason implements Season {
    @Override
    public String getName() {
        return "Low";
    }

    @Override
    public double getMultiplier() {
        return 0.9;
    }
}
