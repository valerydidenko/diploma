package service;

import diploma.entity.Position;
import diploma.enums.PositionEnum;
import diploma.enums.PositionTypeEnum;
import diploma.service.impl.PositionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static diploma.utils.EntitiesFactory.generatePosition;
import static org.junit.Assert.*;

public class TestPositionService extends AbstractServiceTest {

    @Autowired
    private PositionServiceImpl positionService;

    private Position position;

    @Before
    public void initEntities() {
        position = generatePosition();
        positionRepository.save(position);
    }

    @Test
    public void testUpdateEntity() {
        entityManager.detach(position);

        position.setPositionType(PositionTypeEnum.ICS);
        position.setPosition(PositionEnum.RECTOR);

        Position updated = positionRepository.findOne(position.getId());
        assertNotEquals(position, updated);

        positionService.save(position);

        updated = positionRepository.findOne(position.getId());
        assertNotNull(updated);
        assertEquals(position, updated);
    }

    @Test
    public void testDeleteEntity() {
        positionService.delete(position);
        assertNull(positionRepository.findOne(position.getId()));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSavePositionViolateUniqueConstraint() {
        positionService.save(generatePosition());
    }
}