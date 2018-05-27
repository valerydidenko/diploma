package diploma.service.impl;

import diploma.entity.Specialty;
import diploma.repository.SpecialtyRepository;
import diploma.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl extends CrudServiceImpl<Specialty> implements SpecialtyService {

	@Autowired
	private SpecialtyRepository repository;

}