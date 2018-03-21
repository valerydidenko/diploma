package diploma.utils;

import diploma.entity.Exclusion;
import diploma.entity.Specialty;
import diploma.entity.Subject;

import java.util.HashSet;
import java.util.Set;

public class Util {

    public static Specialty generateSpecialty() {
        Specialty specialty = new Specialty();
        specialty.setUkrName("Тест комп науки");
        specialty.setUkrSpecialization("Тест информ системы");
        specialty.setEngName("Test comp science");
        specialty.setEngSpecialization("Test inform systems");
        specialty.setYear(2007);
        return specialty;
    }

    public static Subject generateSubject() {
        Subject subject = new Subject();
        subject.setSemester(1);
        subject.setUkrName("Тест матан");
        subject.setEngName("Test Maths");
        subject.setCode("MT 23.O2");
        subject.setCredit(4.5F);
        return subject;
    }

    public static Set<Subject> generateSetOfSubjects(int count) {
        Set<Subject> subjects = new HashSet<>();
        for (int i = 0; i < count; i++) {
            String testString = "testSubject:" + i;
            Subject subject = new Subject();
            subject.setSemester(count);
            subject.setUkrName(testString);
            subject.setEngName(testString);
            subject.setCode(testString);
            subject.setCredit(4.5F);
            subjects.add(subject);
        }
        return subjects;
    }

    public static Exclusion generateExclusion() {
        Exclusion exclusion = new Exclusion();
        exclusion.setUkrReason("Первая причина");
        exclusion.setEngReason("First reason");
        return exclusion;
    }
}