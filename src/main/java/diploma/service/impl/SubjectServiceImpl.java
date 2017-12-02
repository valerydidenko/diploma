package diploma.service.impl;

import diploma.entity.Specialty;
import diploma.entity.Subject;
import diploma.repository.SubjectRepository;
import diploma.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Override
    public Subject getById (long id) {
        return repository.findOne(id);
    }

    @Override
    public void save (Subject subject) {
        repository.save(subject);
    }

    @Override
    public void delete (Subject subject) {
        repository.delete(subject);
    }

    @Override
    public void deleteById (long id) {
        repository.delete(id);
    }

    @Override
    public List<Subject> getSubjectsBySpecialty (Specialty specialty) {
        return repository.findAllBySpecialty(specialty);
    }

}