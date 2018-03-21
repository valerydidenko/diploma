package service;

import diploma.config.AppConfig;
import diploma.entity.Exclusion;
import diploma.repository.ExclusionRepository;
import diploma.service.impl.ExclusionServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static diploma.utils.Util.generateExclusion;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestExclusionService {

    private static final Logger log = LoggerFactory.getLogger(TestExclusionService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ExclusionServiceImpl exclusionService;

    @Autowired
    private ExclusionRepository exclusionRepository;

    private Exclusion exclusion;

    @Before
    public void initEntities() {
        exclusion = generateExclusion();

        log.info("GENERATE EXCLUSION - {}", exclusion);

        exclusionRepository.save(exclusion);

        log.info("EXCLUSION WAS SAVED - {}", exclusion);
    }

    @Test
    public void testUpdateExclusion() {
        entityManager.detach(exclusion);

        exclusion.setUkrReason("Обновленная причина");
        exclusion.setEngReason("Updated reason");
        exclusionService.save(exclusion);

        Exclusion updated = exclusionRepository.findOne(exclusion.getId());
        Assert.assertNotNull(updated);
        Assert.assertEquals(exclusion, updated);
    }

    @Test
    public void testDeleteExclusion() {
        exclusionService.delete(exclusion);
        assertNull(exclusionRepository.findOne(exclusion.getId()));
    }
}