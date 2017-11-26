package service;

import diploma.config.AppConfig;
import diploma.entity.Student;
import diploma.enums.Degree;
import diploma.repository.StudentRepository;
import diploma.service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestStudentService {

    @Autowired
    private StudentServiceImpl service;

    @Autowired
    private StudentRepository repository;
    private Student student;

    @Before
    public void initEntities () {
        student = new Student();
        student.setUsedeId(2341245L);
        student.setUkrSurname("Васько");
        student.setUkrName("Анастасія");
        student.setUkrFatherName("Василівна");
        student.setUkrCountry("Україна");
        student.setEngSurname("Vasko");
        student.setEngName("Anastasiia");
        student.setEngFatherName("Vasilevna");
        student.setEngCountry("Ukraine");
        student.setDegree(Degree.Bachelor);
        student.setDateOfBirth(new Date(838414800000L));
        student.setGetIntoYear(2014);
        student.setGraduateYear(2018);
        repository.save(student);
    }

    @Test
    public void testGetById () {
        assertEquals(student, service.getById(student.getId()));
    }

    @Test
    public void testSaveUser () {
        Student student = new Student();
        student.setUsedeId(9129122L);
        student.setUkrSurname("Васькова");
        student.setUkrName("Ганна");
        student.setUkrCountry("Польша");
        student.setEngSurname("Vaskova");
        student.setEngName("Anna");
        student.setEngCountry("Poland");
        student.setDegree(Degree.Master);
        student.setDateOfBirth(new Date(838414800400L));
        student.setGetIntoYear(2012);
        student.setGraduateYear(2016);
        service.save(student);

        assertNotNull(repository.getOne(student.getId()));
    }

    @Test
    public void testUpdateUser () {
        student.setUsedeId(2321245L);
        student.setUkrSurname("Васькоі");
        student.setUkrName("Анастасіяі");
        student.setUkrFatherName("Василівнаі");
        student.setUkrCountry("Українаі");
        student.setEngSurname("Vaskos");
        student.setEngName("Anastasiias");
        student.setEngFatherName("Vasilevnas");
        student.setEngCountry("Ukraines");
        student.setDegree(Degree.Specialist);
        student.setDateOfBirth(new Date(838314800000L));
        student.setGetIntoYear(2015);
        student.setGraduateYear(2019);
        repository.save(student);

        Student updated = repository.getOne(student.getId());
        assertNotNull(updated);
        assertEquals(student, updated);
    }

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testDeleteUser () {
        service.delete(student);
        repository.getOne(student.getId());
    }
}