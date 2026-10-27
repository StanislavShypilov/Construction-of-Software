package lab8;

import java.util.Map;

public class SeasonService {
    private Map<String, Season> seasons;

    public SeasonService() {
        seasons = Map.of(
                "low", new LowSeason(),
                "high", new HighSeason(),
                "peak", new PeakSeason()
        );
    }

    public Season getSeason(String name) {
        if(!seasons.containsKey(name.toLowerCase())) {
            throw new IllegalArgumentException("Unknown season " + name);
        }
        return seasons.get(name.toLowerCase());
    }
}
