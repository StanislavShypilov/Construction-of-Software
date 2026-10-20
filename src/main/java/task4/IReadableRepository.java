package task4;

import java.util.List;

public interface IReadableRepository<T> {
    List<T> getAll();

    T getById(int id);
}