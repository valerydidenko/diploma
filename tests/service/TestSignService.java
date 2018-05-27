package service;

import diploma.entity.Position;
import diploma.entity.Sign;
import diploma.service.SignService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static diploma.factories.EntitiesFactory.generatePosition;
import static diploma.factories.EntitiesFactory.generateSign;
import static org.junit.Assert.*;

public class TestSignService extends AbstractServiceTest {

	@Autowired
	private SignService signService;

	private Sign sign;
	private Position position;

	@Before
	public void initEntities() {
		position = generatePosition();
		positionRepository.save(position);

		sign = generateSign();
		sign.setPosition(position);
		signRepository.save(sign);
	}

	@Test
	public void testUpdateEntity() {
		entityManager.detach(sign);

		sign.setEngName("New name");
		signService.save(sign);

		Sign updated = signRepository.findOne(sign.getId());
		assertNotNull(updated);
		assertEquals(updated, sign);
	}

	@Test
	public void testDeleteEntity() {
		signService.delete(sign);
		assertNull(signRepository.findOne(sign.getId()));
		assertNotNull(positionRepository.findOne(position.getId()));
	}

}