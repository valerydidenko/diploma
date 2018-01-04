package diploma.utils;

import diploma.entity.Subject;

import java.util.HashSet;
import java.util.Set;

public class SubjectUtils {

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

}