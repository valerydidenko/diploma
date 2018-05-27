package diploma.services.impl;

import diploma.entities.Student;
import diploma.repositories.StudentRepository;
import diploma.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student> implements StudentService {

	@Autowired
	private StudentRepository repository;

}