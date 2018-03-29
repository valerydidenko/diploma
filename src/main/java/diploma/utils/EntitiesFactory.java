package diploma.utils;

import diploma.entity.*;
import diploma.enums.DegreeEnum;
import diploma.enums.PositionEnum;
import diploma.enums.PositionTypeEnum;
import diploma.enums.RoleEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EntitiesFactory {

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

    public static User generateUser() {
        User user = new User();
        user.setLogin("test_login");
        user.setPassword("test_pass");
        user.setUkrName("test_ukr_name");
        user.setUkrSurname("test_ukr_surname");
        user.setEngName("test_eng_name");
        user.setEngSurname("test_eng_surname");
        user.setRole(RoleEnum.USER);
        return user;
    }

    public static Student generateStudent() {
        Student student = new Student();
        student.setUsedeId(2341245L);
        student.setUkrSurname("Васько");
        student.setUkrName("Анастасія");
        student.setUkrFatherName("Василівна");
        student.setUkrCountry("Україна");
        student.setEngSurname("Vasko");
        student.setEngName("Anastasiia");
        student.setEngFatherName("Vasilevna");
        student.setEngCountry("Ukraine");
        student.setDegree(DegreeEnum.BACHELOR);
        student.setDateOfBirth(new Date(838414800000L));
        student.setGetIntoYear(2014);
        student.setGraduateYear(2018);
        return student;
    }

    public static Grade generateGrade(Student student, Subject subject) {
        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setOnpuGrade(90);
        grade.setEuroGrade("A");
        return grade;
    }

    public static Position generatePosition() {
        Position position = new Position();
        position.setPosition(PositionEnum.DEAN);
        position.setPositionType(PositionTypeEnum.ONPU);
        return position;
    }

    public static Sign generateSign() {
        Sign sign = new Sign();
        sign.setUkrSurname("Васько");
        sign.setUkrName("Анастасія");
        sign.setUkrFatherName("Василівна");
        sign.setEngSurname("Vasko");
        sign.setEngName("Anastasiia");
        sign.setEngFatherName("Vasilevna");
        return sign;
    }
}