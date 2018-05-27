package diploma.services.impl;

import diploma.entities.Position;
import diploma.repositories.PositionRepository;
import diploma.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends CrudServiceImpl<Position> implements PositionService {

	@Autowired
	private PositionRepository repository;

}