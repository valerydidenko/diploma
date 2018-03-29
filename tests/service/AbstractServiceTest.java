package service;

import diploma.config.AppConfig;
import diploma.repository.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public abstract class AbstractServiceTest {

    static final Logger log = LoggerFactory.getLogger(AbstractServiceTest.class);

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected ExclusionRepository exclusionRepository;

    @Autowired
    protected SpecialtyRepository specialtyRepository;

    @Autowired
    protected StudentRepository studentRepository;

    @Autowired
    protected SubjectRepository subjectRepository;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected GradeRepository gradeRepository;

    @Autowired
    protected PositionRepository positionRepository;

    @Autowired
    protected SignRepository signRepository;

    public abstract void initEntities();

    public abstract void testUpdateEntity();

    public abstract void testDeleteEntity();
}
