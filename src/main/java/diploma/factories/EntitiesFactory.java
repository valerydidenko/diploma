package diploma.factories;

import diploma.entities.*;
import diploma.enums.PositionEnum;
import diploma.enums.PositionTypeEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class EntitiesFactory {

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

	public static Reference generateReference() {
		Reference reference = new Reference();
		reference.setNumber(12342);
		reference.setSignDate(new Date());
		reference.setOrder("№666-a");
		reference.setOrderDate(new Date());
		return reference;
	}
}