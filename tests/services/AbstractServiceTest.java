package services;

import diploma.configs.AppConfig;
import diploma.repositories.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

	@Autowired
	protected ReferenceRepository referenceRepository;

	public abstract void initEntities();

	public abstract void testUpdateEntity();

	public abstract void testDeleteEntity();
}
