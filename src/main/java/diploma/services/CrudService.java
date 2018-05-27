package diploma.services;

import diploma.entities.abstractions.AbstractEntity;

import java.util.List;

public interface CrudService<T extends AbstractEntity> {

	T getById(long id);

	List<T> getAll();

	void save(T object);

	void delete(T object);

	void deleteById(long id);
}