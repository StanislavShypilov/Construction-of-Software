package task4;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyAnalyticsRepository<T>
        implements IReadableRepository<T>, ICsvExportRepository {

    @Override
    public List<T> getAll() {
        return new ArrayList<>();
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public void exportToCsv(String path) {
        System.out.println("Exported analytics to " + path);
    }
}