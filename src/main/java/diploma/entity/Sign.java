package diploma.entity;

import diploma.entity.abstractions.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "signs")
public class Sign extends Person {

    private Position position;

    public Sign() {
    }

    public Sign(String ukrSurname, String ukrName, String ukrFatherName,
                String engSurname, String engName, String engFatherName,
                Position position) {
        super(ukrSurname, ukrName, ukrFatherName, engSurname, engName, engFatherName);
        this.position = position;
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
}