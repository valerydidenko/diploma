package diploma.services.impl;

import diploma.entities.Grade;
import diploma.repositories.GradeRepository;
import diploma.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl extends CrudServiceImpl<Grade> implements GradeService {

	@Autowired
	private GradeRepository repository;

}