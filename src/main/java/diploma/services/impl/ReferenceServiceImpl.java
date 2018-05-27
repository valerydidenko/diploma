package diploma.services.impl;

import diploma.entities.Reference;
import diploma.repositories.ReferenceRepository;
import diploma.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl extends CrudServiceImpl<Reference> implements ReferenceService {

	@Autowired
	private ReferenceRepository repository;

}