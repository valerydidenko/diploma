package diploma.services.impl;

import diploma.entities.Specialty;
import diploma.repositories.SpecialtyRepository;
import diploma.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl extends CrudServiceImpl<Specialty> implements SpecialtyService {

	@Autowired
	private SpecialtyRepository repository;

}