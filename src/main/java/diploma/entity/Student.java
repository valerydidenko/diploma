package diploma.entity;

import diploma.entity.abstractions.Person;
import diploma.enums.DegreeEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student extends Person {

	private static final long serialVersionUID = -1444535150512840093L;

	private Long usedeId;
	private String ukrCountry;
	private String engCountry;
	private DegreeEnum degree;
	private Date dateOfBirth;
	private int getIntoYear;
	private int graduateYear;
	private boolean deducted;

	public Student() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Student student = (Student) o;
		return getIntoYear == student.getIntoYear &&
				graduateYear == student.graduateYear &&
				Objects.equals(usedeId, student.usedeId) &&
				Objects.equals(ukrCountry, student.ukrCountry) &&
				Objects.equals(engCountry, student.engCountry) &&
				degree == student.degree &&
				Objects.equals(dateOfBirth, student.dateOfBirth);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), usedeId, ukrCountry, engCountry, degree, dateOfBirth, getIntoYear, graduateYear);
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", " + super.toString() +
				", usedeId=" + usedeId +
				", ukrCountry='" + ukrCountry + '\'' +
				", engCountry='" + engCountry + '\'' +
				", degree=" + degree +
				", dateOfBirth=" + dateOfBirth +
				", getIntoYear=" + getIntoYear +
				", graduateYear=" + graduateYear +
				", deducted=" + deducted +
				'}';
	}

	@Column(name = "usede_id", nullable = false, unique = true)
	public Long getUsedeId() {
		return usedeId;
	}

	public void setUsedeId(Long usedeId) {
		this.usedeId = usedeId;
	}

	@Column(name = "ukr_country", nullable = false, length = 60)
	@NotEmpty
	public String getUkrCountry() {
		return ukrCountry;
	}

	public void setUkrCountry(String ukrCountry) {
		this.ukrCountry = ukrCountry;
	}

	@Column(name = "eng_country", nullable = false, length = 60)
	@NotEmpty
	public String getEngCountry() {
		return engCountry;
	}

	public void setEngCountry(String engCountry) {
		this.engCountry = engCountry;
	}

	@Column(name = "degree", nullable = false)
	@Enumerated(EnumType.STRING)
	public DegreeEnum getDegree() {
		return degree;
	}

	public void setDegree(DegreeEnum degree) {
		this.degree = degree;
	}

	@Column(name = "date_of_birth", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "get_into_year", nullable = false)
	@Min(1995)
	public int getGetIntoYear() {
		return getIntoYear;
	}

	public void setGetIntoYear(int getIntoYear) {
		this.getIntoYear = getIntoYear;
	}

	@Column(name = "graduate_year", nullable = false)
	@Min(1996)
	public int getGraduateYear() {
		return graduateYear;
	}

	public void setGraduateYear(int graduateYear) {
		this.graduateYear = graduateYear;
	}

	@Column(name = "deducted", nullable = false)
	public boolean isDeducted() {
		return deducted;
	}

	public void setDeducted(boolean deducted) {
		this.deducted = deducted;
	}

}