package diploma.service;

public interface BaseService<T> {

    T getById(long id);

    void save(T object);

    void delete(T object);

    void deleteById(long id);
}