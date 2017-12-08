package service;

import diploma.config.AppConfig;
import diploma.entity.Specialty;
import diploma.entity.Subject;
import diploma.repository.SpecialtyRepository;
import diploma.repository.SubjectRepository;
import diploma.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestSubjectService {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    private Subject subject;
    private Specialty specialty;

    @Before
    public void initEntitities () {
        specialty = new Specialty();
        specialty.setUkrName("Тест комп науки 1");
        specialty.setUkrSpecialization("Тест информ системы 1");
        specialty.setEngName("Test comp science 1");
        specialty.setEngSpecialization("Test inform systems 1");
        specialty.setYear(2013);
        specialtyRepository.save(specialty);

        subject = new Subject();
        subject.setSemester(1);
        subject.setUkrName("Тест матан");
        subject.setEngName("Test Maths");
        subject.setCode("MT 23.O2");
        subject.setCredit(4.5F);
        subject.setSpecialty(specialty);
        subjectRepository.save(subject);
    }

    @Test
    public void testGetById () {
        assertEquals(subject, subjectRepository.findOne(subject.getId()));
    }

    @Test
    public void testUpdateSubject () {
        Specialty specialty = new Specialty();
        specialty.setUkrName("NEW Тест комп науки 1");
        specialty.setUkrSpecialization("NEW Тест информ системы 1");
        specialty.setEngName("NEW Test comp science 1");
        specialty.setEngSpecialization("NEW Test inform systems 1");
        specialty.setYear(2013);
        specialtyRepository.save(specialty);

        subject.setSemester(3);
        subject.setUkrName("NEW Тест матан");
        subject.setEngName("NEW Test Maths");
        subject.setCode("NEW MT 23.O2");
        subject.setCredit(5.5F);
        subject.setSpecialty(specialty);
        subjectService.save(subject);

        Subject updated = subjectRepository.findOne(subject.getId());
        assertNotNull(updated);
        assertEquals(subject, updated);
    }

    @Test
    public void testDeleteSubject () {
        subjectService.delete(subject);
        assertNull(subjectRepository.findOne(subject.getId()));
        assertNotNull(specialtyRepository.findOne(specialty.getId()));
    }
}