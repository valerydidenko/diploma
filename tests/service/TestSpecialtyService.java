package service;

import diploma.config.AppConfig;
import diploma.entity.Specialty;
import diploma.entity.Subject;
import diploma.repository.SpecialtyRepository;
import diploma.repository.SubjectRepository;
import diploma.service.impl.SpecialtyServiceImpl;
import diploma.utils.SpecialtyUtils;
import diploma.utils.SubjectUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestSpecialtyService {

    private static final Logger log = LoggerFactory.getLogger(TestSpecialtyService.class);

    @Autowired
    private SpecialtyServiceImpl service;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    private Specialty specialty;

    @Before
    public void initEntities() {
        specialty = SpecialtyUtils.generateSpecialty();
        specialtyRepository.save(specialty);

        Set<Subject> subjects = SubjectUtils.generateSetOfSubjects(3);
        subjects.forEach(subject -> subject.setSpecialty(specialty));
        subjectRepository.save(subjects);
        specialty.setSubjects(subjects);
    }

    @Test
    public void testGetById() {
        assertEquals(specialty, service.getById(specialty.getId()));
    }

    @Test
    public void testUpdateSpecialty() {
        specialty.setUkrName("Тест комп науки UPD");
        specialty.setUkrSpecialization("Тест информ системы UPD");
        specialty.setEngName("Test comp science UPD");
        specialty.setEngSpecialization("Test inform systems UPD");
        specialty.setYear(2007);
        //TODO: Why can I comment this method and object will be updated? Perhaps state of this object is PERSISTENT.
        //service.save(specialty);
        Specialty updated = specialtyRepository.findOne(specialty.getId());
        assertNotNull(updated);
        assertEquals(specialty, updated);
        assertNotNull(subjectRepository.findAllBySpecialty(specialty));
        assertEquals(3, subjectRepository.findAllBySpecialty(specialty).size());
    }

    @Test
    public void testDeleteSpecialty() {
        service.delete(specialty);
        assertNull(specialtyRepository.findOne(specialty.getId()));
        assertNull(subjectRepository.findAllBySpecialty(specialty));
        assertEquals(0, subjectRepository.findAllBySpecialty(specialty).size());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveSpecialtiesViolateUniqueConstraint() {
        Specialty specialty1 = new Specialty();
        specialty1.setUkrName("Тест комп науки");
        specialty1.setUkrSpecialization("Тест информ системы");
        specialty1.setEngName("XXX");
        specialty1.setEngSpecialization("XXX");
        specialty1.setYear(2007);
        service.save(specialty1);
    }

    @Test
    public void testSaveSpecialtiesViolate2of3UniqueField() {
        Specialty specialty1 = new Specialty();
        specialty1.setUkrName("Тест комп науки");
        specialty1.setUkrSpecialization("Тест информ системы");
        specialty1.setEngName("XXX");
        specialty1.setEngSpecialization("XXX");
        specialty1.setYear(2009);
        service.save(specialty1);

        assertNotNull(specialtyRepository.findOne(specialty1.getId()));
        assertEquals(specialty.getUkrName(), specialty1.getUkrName());
        assertEquals(specialty.getUkrSpecialization(), specialty1.getUkrSpecialization());
        assertNotEquals(specialty.getYear(), specialty1.getYear());
    }
}