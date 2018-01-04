package diploma.service.impl;

import diploma.entity.Student;
import diploma.repository.StudentRepository;
import diploma.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements BaseService<Student> {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void delete(Student student) {
        repository.delete(student);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }
}