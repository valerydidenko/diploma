package service;

import diploma.config.AppConfig;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public abstract class AbstractServiceTest {

    @PersistenceContext
    EntityManager entityManager;

    static final Logger log = LoggerFactory.getLogger(AbstractServiceTest.class);

    public abstract void initEntities();

    public abstract void testUpdateEntity();

    public abstract void testDeleteEntity();
}
