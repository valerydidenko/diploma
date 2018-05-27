package diploma.service.impl;

import diploma.entity.Grade;
import diploma.repository.GradeRepository;
import diploma.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl extends CrudServiceImpl<Grade> implements GradeService {

	@Autowired
	private GradeRepository repository;

}