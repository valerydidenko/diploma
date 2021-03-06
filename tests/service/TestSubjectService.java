package service;

import diploma.entity.Specialty;
import diploma.entity.Subject;
import diploma.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static diploma.utils.EntitiesFactory.generateSpecialty;
import static diploma.utils.EntitiesFactory.generateSubject;
import static org.junit.Assert.*;

public class TestSubjectService extends AbstractServiceTest {

    @Autowired
    private SubjectService subjectService;

    private Subject subject;
    private Specialty specialty;

    @Before
    public void initEntities() {
        specialty = generateSpecialty();

        log.info("GENERATE SPECIALTY - {}", specialty);

        subject = generateSubject();
        subject.setSpecialty(specialty);
        specialty.addSubject(subject);

        log.info("GENERATE SUBJECT - {}", subject);

        subjectRepository.save(subject);

        log.info("SUBJECT WAS SAVED - {}", subject);
        log.info("SPECIALTY HAD BEEN SAVED ALSO - {}", specialty);
    }

    @Test
    public void testUpdateEntity() {
        log.info("CHECK PERSISTENCE AFTER SAVE");
        log.info("SUBJECT PERSIST - {}", entityManager.contains(subject));
        log.info("DETACH SUBJECT");

        entityManager.detach(subject);

        log.info("SUBJECT PERSIST - {}", entityManager.contains(subject));

        subject.setSemester(3);
        subject.setUkrName("NEW Тест матан");
        subject.setEngName("NEW Test Maths");
        subject.setCode("NEW MT 23.O2");
        subject.setCredit(5.5F);
        subject.setSpecialty(specialty);

        log.info("LOCAL SUBJECT WAS UPDATED - {}", subject);
        log.info("SUBJECT FROM DB - {}", subjectRepository.findOne(subject.getId()));
        log.info("APPLY CHANGES");

        subjectService.save(subject);

        Subject updated = subjectRepository.findOne(subject.getId());

        log.info("SUBJECT FROM DB - {}\n", updated);
        assertNotNull(updated);
        assertEquals(subject, updated);
    }

    @Test
    public void testDeleteEntity() {
        log.info("SUBJECT FOR DELETE - {}", subject);

        subjectService.delete(subject);

        log.info("SUBJECT WAS DELETED");
        log.info("FIND ONE SUBJECT BY ID {} - {}", subject.getId(), subjectRepository.findOne(subject.getId()));
        log.info("CHECK IF SPECIALTY HAD NOT BEEN DELETED ALSO");
        log.info("FIND ONE SPECIALTY BY ID {} - {}", specialty.getId(), specialtyRepository.findOne(specialty.getId()));

        assertNull(subjectRepository.findOne(subject.getId()));
        assertNotNull(specialtyRepository.findOne(specialty.getId()));
    }


    @Test(expected = DataIntegrityViolationException.class)
    public void testSaveSubjectViolateUniqueConstraint() {
        log.info("UNIQUE CONSTRAINTS FOR SUBJECT: semester, ukrName, specialtyId");
        log.info("SAVED SUBJECT: semester - {}, ukrName - {}, specialtyId - {}",
                subject.getSemester(), subject.getUkrName(), specialty.getId());

        Subject subject1 = new Subject();
        subject1.setSemester(1);
        subject1.setUkrName("Тест матан");
        subject1.setEngName("XXX");
        subject1.setCode("MT 23.O8");
        subject1.setCredit(6F);
        subject1.setSpecialty(specialty);

        log.info("NEW SUBJECT: semester - {}, ukrName - {}, specialtyId - {}",
                subject1.getSemester(), subject1.getUkrName(), subject1.getSpecialty().getId());

        subjectService.save(subject1);
    }

    @Test
    public void testSaveSpecialtyViolate2of3UniqueField() {
        log.info("UNIQUE CONSTRAINTS FOR SUBJECT: semester, ukrName, specialtyId");
        log.info("SAVED SUBJECT: semester - {}, ukrName - {}, specialtyId - {}",
                subject.getSemester(), subject.getUkrName(), subject.getSpecialty().getId());

        Subject subject1 = new Subject();
        subject1.setSemester(1);
        subject1.setUkrName("Тест матан UPD");
        subject1.setEngName("XXX");
        subject1.setCode("MT 23.O8");
        subject1.setCredit(6F);
        subject1.setSpecialty(specialty);

        log.info("NEW SUBJECT: semester - {}, ukrName - {}, specialtyId - {}",
                subject1.getSemester(), subject1.getUkrName(), subject1.getSpecialty().getId());

        subjectService.save(subject1);

        log.info("NEW SUBJECT WAS SAVED SUCCESSFULLY - {}", subjectRepository.findOne(subject1.getId()));

        assertNotNull(subjectRepository.findOne(subject.getId()));
        assertNotEquals(subject.getUkrName(), subject1.getUkrName());
        assertEquals(subject.getSemester(), subject1.getSemester());
        assertEquals(subject.getSpecialty().getId(), subject1.getSpecialty().getId());
    }
}