package service;

import diploma.entity.Student;
import diploma.enums.DegreeEnum;
import diploma.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static diploma.utils.EntitiesFactory.generateStudent;
import static org.junit.Assert.*;

public class TestStudentService extends AbstractServiceTest {

    @Autowired
    private StudentService service;

    private Student student;

    @Before
    public void initEntities() {
        student = generateStudent(false);
        studentRepository.save(student);
    }

    @Test
    public void testUpdateEntity() {
        entityManager.detach(student);

        student.setUsedeId(2321245L);
        student.setUkrSurname("Васькоі");
        student.setUkrName("Анастасіяі");
        student.setUkrFatherName("Василівнаі");
        student.setUkrCountry("Українаі");
        student.setEngSurname("Vaskos");
        student.setEngName("Anastasiias");
        student.setEngFatherName("Vasilevnas");
        student.setEngCountry("Ukraines");
        student.setDegree(DegreeEnum.SPECIALIST);
        student.setDateOfBirth(new Date(838314800000L));
        student.setGetIntoYear(2015);
        student.setGraduateYear(2019);
        service.save(student);

        Student updated = studentRepository.getOne(student.getId());
        assertNotNull(updated);
        assertEquals(student, updated);
    }

    @Test
    public void testDeleteEntity() {
        service.delete(student);
        assertNull(studentRepository.findOne(student.getId()));
    }

}