package service;

import diploma.entity.Grade;
import diploma.entity.Student;
import diploma.entity.Subject;
import diploma.factories.StudentFactory;
import diploma.service.GradeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static diploma.factories.EntitiesFactory.*;
import static org.junit.Assert.*;

public class TestGradeService extends AbstractServiceTest {

	@Autowired
	private GradeService gradeService;

	private Grade grade;
	private Student student;
	private Subject subject;

	@Before
	public void initEntities() {
		student = StudentFactory.generateNotDeductedStudent();
		subject = generateSubject();
		subject.setSpecialty(generateSpecialty());
		studentRepository.save(student);
		subjectRepository.save(subject);

		grade = generateGrade(student, subject);
		gradeRepository.save(grade);
	}

	@Test
	public void testUpdateEntity() {
		entityManager.detach(grade);

		grade.setOnpuGrade(25);
		grade.setEuroGrade("C");
		gradeService.save(grade);

		Grade updated = gradeRepository.findOne(grade.getId());
		assertNotNull(updated);
		assertEquals(grade, updated);
	}

	@Test
	public void testDeleteEntity() {
		gradeService.delete(grade);
		assertNull(gradeRepository.findOne(grade.getId()));
		assertNotNull(studentRepository.findOne(student.getId()));
		assertNotNull(subjectRepository.findOne(subject.getId()));
	}

}