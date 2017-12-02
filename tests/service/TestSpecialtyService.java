package service;


import diploma.config.AppConfig;
import diploma.entity.Specialty;
import diploma.repository.SpecialtyRepository;
import diploma.service.impl.SpecialtyServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestSpecialtyService {

    @Autowired
    private SpecialtyServiceImpl service;

    @Autowired
    private SpecialtyRepository repository;
    private Specialty specialty;

    @Before
    public void initEntities () {
        specialty = new Specialty();
        specialty.setUkrName("Тест комп науки");
        specialty.setUkrSpecialization("Тест информ системы");
        specialty.setEngName("Test comp science");
        specialty.setEngSpecialization("Test inform systems");
        specialty.setYear(2007);
        repository.save(specialty);
    }

    @Test
    public void testGetById () {
        assertEquals(specialty, service.getById(specialty.getId()));
    }

    @Test
    public void testUpdateSpecialty () {
        specialty.setUkrName("Тест комп науки UPD");
        specialty.setUkrSpecialization("Тест информ системы UPD");
        specialty.setEngName("Test comp science UPD");
        specialty.setEngSpecialization("Test inform systems UPD");
        specialty.setYear(2007);
        service.save(specialty);

        Specialty updated = repository.getOne(specialty.getId());
        assertNotNull(updated);
        assertEquals(specialty, updated);
    }

    @Test
    public void testDeleteUser () {
        service.delete(specialty);
        assertNull(repository.findOne(specialty.getId()));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveSpecialtiesViolateUniqueConstraint () {
        Specialty specialty1 = new Specialty();
        specialty1.setUkrName("Тест комп науки");
        specialty1.setUkrSpecialization("Тест информ системы");
        specialty1.setEngName("XXX");
        specialty1.setEngSpecialization("XXX");
        specialty1.setYear(2007);
        service.save(specialty1);
    }

    @Test
    public void testSaveSpecialtiesViolate2of3UniqueField () {
        Specialty specialty1 = new Specialty();
        specialty1.setUkrName("Тест комп науки");
        specialty1.setUkrSpecialization("Тест информ системы");
        specialty1.setEngName("XXX");
        specialty1.setEngSpecialization("XXX");
        specialty1.setYear(2009);
        service.save(specialty1);

        assertNotNull(repository.getOne(specialty1.getId()));
        assertEquals(specialty.getUkrName(), specialty1.getUkrName());
        assertEquals(specialty.getUkrSpecialization(), specialty1.getUkrSpecialization());
        assertNotEquals(specialty.getYear(), specialty1.getYear());
    }
}