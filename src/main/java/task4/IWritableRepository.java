package task4;

public interface IWritableRepository<T> {
    void add(T entity);

    void update(T entity);

    void delete(int id);
}