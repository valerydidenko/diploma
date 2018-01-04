package diploma.service.impl;

import diploma.entity.Specialty;
import diploma.repository.SpecialtyRepository;
import diploma.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpecialtyServiceImpl implements BaseService<Specialty> {

    @Autowired
    private SpecialtyRepository repository;

    @Override
    public Specialty getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Specialty specialty) {
        repository.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        repository.delete(specialty);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }
}