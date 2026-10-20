package task4;

import java.util.List;

public interface IBulkImportRepository<T> {
    void bulkImport(List<T> entities);
}