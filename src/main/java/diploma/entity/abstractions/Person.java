package diploma.entity.abstractions;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class Person extends AbstractEntity {

    private String ukrSurname;
    private String ukrName;
    private String ukrFatherName;
    private String engSurname;
    private String engName;
    private String engFatherName;

    protected Person() {
    }

    protected Person(String ukrSurname, String ukrName, String ukrFatherName,
                     String engSurname, String engName, String engFatherName) {
        this.ukrSurname = ukrSurname;
        this.ukrName = ukrName;
        this.ukrFatherName = ukrFatherName;
        this.engSurname = engSurname;
        this.engName = engName;
        this.engFatherName = engFatherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(ukrSurname, person.ukrSurname) &&
                Objects.equals(ukrName, person.ukrName) &&
                Objects.equals(ukrFatherName, person.ukrFatherName) &&
                Objects.equals(engSurname, person.engSurname) &&
                Objects.equals(engName, person.engName) &&
                Objects.equals(engFatherName, person.engFatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ukrSurname, ukrName, ukrFatherName, engSurname, engName, engFatherName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ukrSurname='" + ukrSurname + '\'' +
                ", ukrName='" + ukrName + '\'' +
                ", ukrFatherName='" + ukrFatherName + '\'' +
                ", engSurname='" + engSurname + '\'' +
                ", engName='" + engName + '\'' +
                ", engFatherName='" + engFatherName + '\'' +
                '}';
    }

    @Column(name = "ukr_surname", nullable = false, length = 60)
    @NotEmpty
    public String getUkrSurname() {
        return ukrSurname;
    }

    public void setUkrSurname(String ukrSurname) {
        this.ukrSurname = ukrSurname;
    }

    @Column(name = "ukr_name", nullable = false, length = 60)
    @NotEmpty
    public String getUkrName() {
        return ukrName;
    }

    public void setUkrName(String ukrName) {
        this.ukrName = ukrName;
    }

    @Column(name = "ukr_father_name", length = 60)
    public String getUkrFatherName() {
        return ukrFatherName;
    }

    public void setUkrFatherName(String ukrFatherName) {
        this.ukrFatherName = ukrFatherName;
    }

    @Column(name = "eng_surname", nullable = false, length = 60)
    @NotEmpty
    public String getEngSurname() {
        return engSurname;
    }

    public void setEngSurname(String engSurname) {
        this.engSurname = engSurname;
    }

    @Column(name = "eng_name", nullable = false, length = 60)
    @NotEmpty
    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    @Column(name = "eng_father_name", length = 60)
    public String getEngFatherName() {
        return engFatherName;
    }

    public void setEngFatherName(String engFatherName) {
        this.engFatherName = engFatherName;
    }
}
