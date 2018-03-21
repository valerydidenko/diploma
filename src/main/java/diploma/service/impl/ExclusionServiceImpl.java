package diploma.service.impl;

import diploma.entity.Exclusion;
import diploma.repository.ExclusionRepository;
import diploma.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExclusionServiceImpl implements BaseService<Exclusion> {

    @Autowired
    private ExclusionRepository repository;

    @Override
    public Exclusion getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Exclusion exclusion) {
        repository.save(exclusion);
    }

    @Override
    public void delete(Exclusion exclusion) {
        repository.delete(exclusion);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }
}