package diploma.service.impl;

import diploma.entity.abstractions.AbstractEntity;
import diploma.repository.BaseRepository;
import diploma.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class CrudServiceImpl<T extends AbstractEntity> implements CrudService<T> {

    @Autowired
    private BaseRepository<T> repository;

    @Override
    public T getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }
}