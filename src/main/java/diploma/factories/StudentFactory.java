package diploma.factories;

import diploma.entity.Student;
import diploma.enums.DegreeEnum;

import java.util.Date;

public final class StudentFactory {

	private static Student generateStudent() {
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

	public static Student generateDeductedStudent() {
		Student student = generateStudent();
		student.setDeducted(true);
		return student;
	}

	public static Student generateNotDeductedStudent() {
		Student student = generateStudent();
		student.setDeducted(false);
		return student;
	}

}