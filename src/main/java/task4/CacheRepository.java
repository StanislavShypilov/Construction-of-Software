package task4;

import java.util.ArrayList;
import java.util.List;

public class CacheRepository<T>
        implements IReadableRepository<T>,
        IWritableRepository<T>,
        IPurgeableRepository {

    @Override
    public List<T> getAll() {
        return new ArrayList<>();
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public void add(T entity) {
        System.out.println("Added to cache.");
    }

    @Override
    public void update(T entity) {
        System.out.println("Updated in cache.");
    }

    @Override
    public void delete(int id) {
        System.out.println("Removed from cache.");
    }

    @Override
    public void purgeAll() {
        System.out.println("Cache purged.");
    }
}