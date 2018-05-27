package diploma.service.impl;

import diploma.entity.Exclusion;
import diploma.repository.ExclusionRepository;
import diploma.service.ExclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExclusionServiceImpl extends CrudServiceImpl<Exclusion> implements ExclusionService {

	@Autowired
	private ExclusionRepository repository;

}