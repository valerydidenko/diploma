package diploma.service.impl;

import diploma.entity.Reference;
import diploma.repository.ReferenceRepository;
import diploma.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl extends CrudServiceImpl<Reference> implements ReferenceService {

	@Autowired
	private ReferenceRepository referenceRepository;

}