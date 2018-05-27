package diploma.entities;

import diploma.entities.abstractions.AbstractEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "subjects")
public class Subject extends AbstractEntity {

	private static final long serialVersionUID = -1479667432527336018L;

	private int semester;
	private String ukrName;
	private String engName;
	private String code;
	private float credit;
	private Specialty specialty;

	public Subject() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Subject subject = (Subject) o;
		return semester == subject.semester &&
				Float.compare(subject.credit, credit) == 0 &&
				Objects.equals(ukrName, subject.ukrName) &&
				Objects.equals(engName, subject.engName) &&
				Objects.equals(code, subject.code) &&
				Objects.equals(specialty, subject.specialty);
	}

	@Override
	public int hashCode() {
		return Objects.hash(semester, ukrName, engName, code, credit, specialty);
	}

	@Override
	public String toString() {
		return "Subject{" +
				"id=" + id +
				", semester=" + semester +
				", ukrName='" + ukrName + '\'' +
				", engName='" + engName + '\'' +
				", code='" + code + '\'' +
				", credit=" + credit +
				", specialtyId=" + specialty.getId() +
				'}';
	}

	@Column(nullable = false)
	@Min(1)
	@Max(6)
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Column(name = "ukr_name", nullable = false, length = 150)
	@NotEmpty
	public String getUkrName() {
		return ukrName;
	}

	public void setUkrName(String ukrName) {
		this.ukrName = ukrName;
	}

	@Column(name = "eng_name", nullable = false, length = 150)
	@NotEmpty
	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	@Column(nullable = false, length = 60)
	@NotEmpty
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(nullable = false)
	@Min(0)
	@Max(10)
	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "specialty_id")
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
}