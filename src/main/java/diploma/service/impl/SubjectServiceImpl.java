package diploma.service.impl;

import diploma.entity.Specialty;
import diploma.entity.Subject;
import diploma.repository.SubjectRepository;
import diploma.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl extends CrudServiceImpl<Subject> implements SubjectService {

	@Autowired
	private SubjectRepository repository;

	@Override
	public List<Subject> getAllBySpecialty(Specialty specialty) {
		return repository.findAllBySpecialty(specialty);
	}

}