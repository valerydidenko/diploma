package diploma.service.impl;

import diploma.entity.Position;
import diploma.repository.PositionRepository;
import diploma.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends CrudServiceImpl<Position> implements PositionService {

    @Autowired
    private PositionRepository repository;

}