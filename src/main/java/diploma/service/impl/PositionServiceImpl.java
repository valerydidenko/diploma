package diploma.service.impl;

import diploma.entity.Position;
import diploma.repository.PositionRepository;
import diploma.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionServiceImpl implements BaseService<Position> {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position getById(long id) {
        return positionRepository.findOne(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public void deleteById(long id) {
        positionRepository.delete(id);
    }
}
