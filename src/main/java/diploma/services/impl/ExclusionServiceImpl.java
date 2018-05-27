package diploma.services.impl;

import diploma.entities.Exclusion;
import diploma.repositories.ExclusionRepository;
import diploma.services.ExclusionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExclusionServiceImpl extends CrudServiceImpl<Exclusion> implements ExclusionService {

	@Autowired
	private ExclusionRepository repository;

}