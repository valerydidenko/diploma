package service;

import diploma.entity.Exclusion;
import diploma.service.ExclusionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static diploma.factories.EntitiesFactory.generateExclusion;
import static org.junit.Assert.assertNull;

public class TestExclusionService extends AbstractServiceTest {

	@Autowired
	private ExclusionService exclusionService;

	private Exclusion exclusion;

	@Before
	public void initEntities() {
		exclusion = generateExclusion();

		log.info("GENERATE EXCLUSION - {}", exclusion);

		exclusionRepository.save(exclusion);

		log.info("EXCLUSION WAS SAVED - {}", exclusion);
	}

	@Test
	public void testUpdateEntity() {
		entityManager.detach(exclusion);

		exclusion.setUkrReason("Обновленная причина");
		exclusion.setEngReason("Updated reason");
		exclusionService.save(exclusion);

		Exclusion updated = exclusionRepository.findOne(exclusion.getId());
		Assert.assertNotNull(updated);
		Assert.assertEquals(exclusion, updated);
	}

	@Test
	public void testDeleteEntity() {
		exclusionService.delete(exclusion);
		assertNull(exclusionRepository.findOne(exclusion.getId()));
	}

}