package diploma.entity;

import diploma.entity.abstractions.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "references")
public class Reference extends AbstractEntity {

	private long number;
	private Date signDate;
	private String order;
	private Date orderDate;
	private Student student;
	private Specialty specialty;
	private Exclusion exclusion;
	private User user;

	public Reference() {
	}

	public Reference(long number, Date signDate, String order, Date orderDate,
	                 Student student, Specialty specialty, Exclusion exclusion, User user) {
		this.number = number;
		this.signDate = signDate;
		this.order = order;
		this.orderDate = orderDate;
		this.student = student;
		this.specialty = specialty;
		this.exclusion = exclusion;
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reference reference = (Reference) o;
		return number == reference.number &&
				Objects.equals(signDate, reference.signDate) &&
				Objects.equals(order, reference.order) &&
				Objects.equals(orderDate, reference.orderDate) &&
				Objects.equals(student, reference.student) &&
				Objects.equals(specialty, reference.specialty);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, signDate, order, orderDate, student, specialty);
	}

	@Override
	public String toString() {
		return "Reference{" +
				"id=" + id +
				", number=" + number +
				", signDate=" + signDate +
				", order='" + order + '\'' +
				", orderDate=" + orderDate +
				", student=" + student +
				", specialty=" + specialty +
				", exclusion=" + exclusion +
				", user=" + user +
				'}';
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
	public Long getId() {
		return super.getId();
	}

	public void setId(Long id) {
		super.setId(id);
	}

	@Column(name = "number", nullable = false)
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

	@Column(name = "order", nullable = false, length = 60)
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
	@PrimaryKeyJoinColumn
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
}