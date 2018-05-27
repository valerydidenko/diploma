package services;

import diploma.entities.Specialty;
import diploma.entities.Subject;
import diploma.services.SpecialtyService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static diploma.factories.EntitiesFactory.generateSetOfSubjects;
import static diploma.factories.EntitiesFactory.generateSpecialty;
import static org.junit.Assert.*;

public class TestSpecialtyService extends AbstractServiceTest {

	@Autowired
	private SpecialtyService service;

	private Specialty specialty;

	@Before
	public void initEntities() {
		specialty = generateSpecialty();

		log.info("GENERATE SPECIALTY - {}", specialty);

		for (Subject subject : generateSetOfSubjects(3)) {
			subject.setSpecialty(specialty);
			specialty.addSubject(subject);
		}

		log.info("GENERATE SUBJECTS FOR SPECIALTY - {}", specialty.getSubjects());

		specialtyRepository.save(specialty);

		log.info("SPECIALTY WAS SAVED - {}", specialty);
	}

	@Test
	public void testUpdateEntity() {
		log.info("CHECK PERSISTENCE AFTER SAVE");
		log.info("SPECIALTY PERSIST - {}", entityManager.contains(specialty));
		log.info("DETACH SPECIALTY");

		entityManager.detach(specialty);

		log.info("SPECIALTY PERSIST - {}", entityManager.contains(specialty));

		specialty.setUkrName("Тест комп науки UPD");
		specialty.setUkrSpecialization("Тест информ системы UPD");
		specialty.setEngName("Test comp science UPD");
		specialty.setEngSpecialization("Test inform systems UPD");
		specialty.setYear(2007);

		log.info("LOCAL SPECIALTY WAS UPDATED - {}", specialty);
		log.info("SPECIALTY FROM DB - {}", specialtyRepository.findOne(specialty.getId()));
		log.info("APPLY CHANGES");

		service.save(specialty);

		Specialty updated = specialtyRepository.findOne(specialty.getId());

		log.info("SPECIALTY FROM DB - {}\n", updated);

		assertNotNull(updated);
		assertEquals(specialty, updated);
		assertNotNull(subjectRepository.findAllBySpecialty(specialty));
		assertEquals(3, subjectRepository.findAllBySpecialty(specialty).size());
	}

	@Test
	public void testDeleteEntity() {
		log.info("SPECIALTY FOR DELETE - {}", specialty);

		service.delete(specialty);

		log.info("SPECIALTY WAS DELETED");
		log.info("FIND ONE SPECIALTY BY ID {} - {}", specialty.getId(), specialtyRepository.findOne(specialty.getId()));
		log.info("FIND ALL SUBJECTS BY SPECIALTY - {}\n", subjectRepository.findAllBySpecialty(specialty).size());

		assertNull(specialtyRepository.findOne(specialty.getId()));
		assertEquals(0, subjectRepository.findAllBySpecialty(specialty).size());
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testSaveSpecialtyViolateUniqueConstraint() {
		log.info("UNIQUE CONSTRAINTS FOR SPECIALTY: ukrName, ukrSpecialization, year");
		log.info("SAVED specialty: ukrName - {}, ukrSpecialization - {}, year - {}",
				specialty.getUkrName(), specialty.getUkrSpecialization(), specialty.getYear());

		Specialty specialty1 = new Specialty();
		specialty1.setUkrName("Тест комп науки");
		specialty1.setUkrSpecialization("Тест информ системы");
		specialty1.setEngName("XXX");
		specialty1.setEngSpecialization("XXX");
		specialty1.setYear(2007);

		log.info("NEW specialty: ukrName - {}, ukrSpecialization - {}, year - {}\n",
				specialty1.getUkrName(), specialty1.getUkrSpecialization(), specialty1.getYear());

		service.save(specialty1);
	}

	@Test
	public void testSaveSpecialtyViolate2of3UniqueField() {
		log.info("UNIQUE CONSTRAINTS FOR SPECIALTY: ukrName, ukrSpecialization, year");
		log.info("SAVED specialty: ukrName - {}, ukrSpecialization - {}, year - {}",
				specialty.getUkrName(), specialty.getUkrSpecialization(), specialty.getYear());

		Specialty specialty1 = new Specialty();
		specialty1.setUkrName("Тест комп науки");
		specialty1.setUkrSpecialization("Тест информ системы");
		specialty1.setEngName("XXX");
		specialty1.setEngSpecialization("XXX");
		specialty1.setYear(2009);

		log.info("NEW specialty: ukrName - {}, ukrSpecialization - {}, year - {}",
				specialty1.getUkrName(), specialty1.getUkrSpecialization(), specialty1.getYear());

		service.save(specialty1);

		log.info("NEW SPECIALTY WAS SAVED SUCCESSFULLY - {}", specialtyRepository.findOne(specialty1.getId()));

		assertNotNull(specialtyRepository.findOne(specialty1.getId()));
		assertEquals(specialty.getUkrName(), specialty1.getUkrName());
		assertEquals(specialty.getUkrSpecialization(), specialty1.getUkrSpecialization());
		assertNotEquals(specialty.getYear(), specialty1.getYear());
	}
}