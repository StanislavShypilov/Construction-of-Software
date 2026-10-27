package lab8;

public class HighSeason implements Season {
    @Override
    public String getName() {
        return "High";
    }

    @Override
    public double getMultiplier() {
        return 1.25;
    }
}
