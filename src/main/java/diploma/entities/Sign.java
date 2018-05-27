package diploma.entities;

import diploma.entities.abstractions.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "signs")
public class Sign extends Person {

	private Position position;
	private Set<Reference> references;

	public Sign() {
		this.references = new HashSet<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Sign sign = (Sign) o;
		return Objects.equals(position, sign.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), position);
	}

	@Override
	public String toString() {
		return "Sign{" +
				"id=" + id +
				", " + super.toString() +
				", position=" + position +
				'}';
	}

	@OneToOne
	@JoinColumn(name = "position_id")
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@ManyToMany(mappedBy = "signs", fetch = FetchType.EAGER)
	public Set<Reference> getReferences() {
		return references;
	}

	public void setReferences(Set<Reference> references) {
		this.references = references;
	}

}