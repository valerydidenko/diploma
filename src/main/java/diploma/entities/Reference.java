package diploma.entities;

import diploma.entities.abstractions.AbstractEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "reference")
public class Reference extends AbstractEntity {

	private long number;
	private Date signDate;
	private String order;
	private Date orderDate;
	private Student student;
	private Specialty specialty;
	private Exclusion exclusion;
	private User user;
	private Set<Sign> signs;

	public Reference() {
		this.signs = new HashSet<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reference reference = (Reference) o;
		return Objects.equals(student, reference.student);
	}

	@Override
	public int hashCode() {
		return Objects.hash(student);
	}

	@Override
	public String toString() {
		return "Reference{" +
				"id=" + id +
				", number=" + number +
				", signDate=" + signDate +
				", order='" + order + '\'' +
				", orderDate=" + orderDate +
				", student=" + student.getId() +
				", specialty=" + specialty.getId() +
				", exclusion=" + exclusion.getId() +
				", user=" + user.getId() +
				", signs[size]=" + signs.size() +
				'}';
	}

	@Column(name = "number", nullable = false, unique = true)
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Column(name = "sign_date", nullable = false)
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	@Column(name = "order_from", nullable = false, length = 60)
	@NotEmpty
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Column(name = "order_date", nullable = false)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@OneToOne(optional = false)
	@JoinColumn(name = "student_id", unique = true)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "specialty_id")
	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "exclusion_id")
	public Exclusion getExclusion() {
		return exclusion;
	}

	public void setExclusion(Exclusion exclusion) {
		this.exclusion = exclusion;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToMany
	@Cascade({CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "signs_references",
			joinColumns = @JoinColumn(name = "reference_id"),
			inverseJoinColumns = @JoinColumn(name = "sign_id"))
	public Set<Sign> getSigns() {
		return signs;
	}

	public void setSigns(Set<Sign> signs) {
		this.signs = signs;
	}

}