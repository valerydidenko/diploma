package diploma.services.impl;

import diploma.entities.Specialty;
import diploma.entities.Subject;
import diploma.repositories.SubjectRepository;
import diploma.services.SubjectService;
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