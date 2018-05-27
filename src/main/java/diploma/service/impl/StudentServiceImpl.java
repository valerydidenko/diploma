package diploma.service.impl;

import diploma.entity.Student;
import diploma.repository.StudentRepository;
import diploma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student> implements StudentService {

	@Autowired
	private StudentRepository repository;

}