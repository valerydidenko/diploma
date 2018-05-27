package diploma.entity;

import diploma.entity.abstractions.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "grades")
public class Grade extends AbstractEntity {

	private static final long serialVersionUID = 8348969852028945954L;

	private Student student;
	private Subject subject;
	private int onpuGrade;
	private String euroGrade;

	public Grade() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Grade grade = (Grade) o;
		return Objects.equals(student, grade.student) &&
				Objects.equals(subject, grade.subject);
	}

	@Override
	public int hashCode() {
		return Objects.hash(student, subject);
	}

	@Override
	public String toString() {
		return "Grade{" +
				"id=" + id +
				", student[id]=" + student.getId() +
				", subject[id]=" + subject.getId() +
				", onpuGrade=" + onpuGrade +
				", euroGrade='" + euroGrade + '\'' +
				'}';
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "subject_id")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Column(name = "onpu_grade", nullable = false)
	@Min(0)
	@Max(100)
	public int getOnpuGrade() {
		return onpuGrade;
	}

	public void setOnpuGrade(int onpuGrade) {
		this.onpuGrade = onpuGrade;
	}

	@Column(name = "euro_grade", nullable = false, length = 3)
	public String getEuroGrade() {
		return euroGrade;
	}

	public void setEuroGrade(String euroGrade) {
		this.euroGrade = euroGrade;
	}
}