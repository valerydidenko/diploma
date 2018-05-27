package services;

import diploma.entities.*;
import diploma.factories.EntitiesFactory;
import diploma.factories.StudentFactory;
import diploma.factories.UserFactory;
import diploma.services.ReferenceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Date;

import static org.junit.Assert.*;

public class TestReferenceService extends AbstractServiceTest {

	@Autowired
	private ReferenceService service;

	private Student student;
	private Specialty specialty;
	private Exclusion exclusion;
	private Reference reference;
	private User user;

	@Before
	public void initEntities() {
		student = StudentFactory.generateNotDeductedStudent();
		specialty = EntitiesFactory.generateSpecialty();
		exclusion = EntitiesFactory.generateExclusion();
		user = UserFactory.generateUser();

		studentRepository.save(student);
		specialtyRepository.save(specialty);
		exclusionRepository.save(exclusion);
		userRepository.save(user);

		reference = EntitiesFactory.generateReference();
		reference.setStudent(student);
		reference.setSpecialty(specialty);
		reference.setExclusion(exclusion);
		reference.setUser(user);

		log.info("GENERATED reference - {}", reference);

		referenceRepository.save(reference);

		log.info("REFERENCE WAS SAVED - {}", reference);
	}

	@Test
	public void testUpdateEntity() {
		entityManager.detach(reference);

		reference.setNumber(11111);
		reference.setSignDate(new Date());
		reference.setOrder("№999-b");
		reference.setOrderDate(new Date());
		service.save(reference);

		Reference updated = referenceRepository.findOne(reference.getId());
		assertNotNull(updated);
		assertEquals(reference, updated);
	}

	@Test
	public void testDeleteEntity() {
		service.delete(reference);

		assertNull(referenceRepository.findOne(reference.getId()));
		assertNotNull(studentRepository.findOne(student.getId()));
		assertNotNull(specialtyRepository.findOne(specialty.getId()));
		assertNotNull(exclusionRepository.findOne(exclusion.getId()));
		assertNotNull(userRepository.findOne(user.getId()));
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testSaveSpecialtyViolateUniqueConstraintField_Number() {
		log.info("UNIQUE CONSTRAINT FOR REFERENCE: number");
		log.info("SAVED REFERENCE: number - {}", reference.getNumber());

		Student student1 = StudentFactory.generateNotDeductedStudent();
		studentRepository.save(student1);

		Reference reference1 = EntitiesFactory.generateReference();
		reference1.setStudent(student1);
		reference1.setSpecialty(specialty);
		reference1.setExclusion(exclusion);
		reference1.setUser(user);

		log.info("NEW REFERENCE: number - {}\n", reference1.getNumber());

		service.save(reference1);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testSaveSpecialtyViolateUniqueConstraintField_Student() {
		log.info("UNIQUE CONSTRAINT FOR REFERENCE: student");
		log.info("SAVED REFERENCE: student - {}", reference.getStudent().getId());

		Reference reference1 = EntitiesFactory.generateReference();
		reference1.setNumber(21342);
		reference1.setStudent(student);
		reference1.setSpecialty(specialty);
		reference1.setExclusion(exclusion);
		reference1.setUser(user);

		log.info("NEW REFERENCE: student - {}\n", reference1.getStudent().getId());

		service.save(reference1);
	}

}