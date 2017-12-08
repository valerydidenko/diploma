package diploma.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty {

    private Long id;
    private String ukrName;
    private String engName;
    private String ukrSpecialization;
    private String engSpecialization;
    private int year;
    private Set<Subject> subjects;

    public Specialty () {
    }

    public Specialty (String ukrName, String engName, String ukrSpecialization, String engSpecialization, int year) {
        this.ukrName = ukrName;
        this.engName = engName;
        this.ukrSpecialization = ukrSpecialization;
        this.engSpecialization = engSpecialization;
        this.year = year;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Specialty))
            return false;

        Specialty specialty = (Specialty) o;

        if (year != specialty.year)
            return false;
        if (!ukrName.equals(specialty.ukrName))
            return false;
        if (!engName.equals(specialty.engName))
            return false;
        if (!ukrSpecialization.equals(specialty.ukrSpecialization))
            return false;
        return engSpecialization.equals(specialty.engSpecialization);
    }

    @Override
    public int hashCode () {
        int result = ukrName.hashCode();
        result = 31 * result + engName.hashCode();
        result = 31 * result + ukrSpecialization.hashCode();
        result = 31 * result + engSpecialization.hashCode();
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString () {
        return "Specialty{" + "id=" + id + ", ukrName='" + ukrName + '\'' + ", engName='" + engName + '\'' + ", ukrSpecialization='" + ukrSpecialization + '\'' + ", engSpecialization='" + engSpecialization + '\'' + ", year=" + year + '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "specialty_id")
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Column(name = "ukr_name", nullable = false, length = 150)
    @NotEmpty
    public String getUkrName () {
        return ukrName;
    }

    public void setUkrName (String ukrName) {
        this.ukrName = ukrName;
    }

    @Column(name = "eng_name", nullable = false, length = 150)
    @NotEmpty
    public String getEngName () {
        return engName;
    }

    public void setEngName (String engName) {
        this.engName = engName;
    }

    @Column(name = "ukr_specialization", nullable = false, length = 150)
    @NotEmpty
    public String getUkrSpecialization () {
        return ukrSpecialization;
    }

    public void setUkrSpecialization (String ukrSpecialization) {
        this.ukrSpecialization = ukrSpecialization;
    }

    @Column(name = "eng_specialization", nullable = false, length = 150)
    @NotEmpty
    public String getEngSpecialization () {
        return engSpecialization;
    }

    public void setEngSpecialization (String engSpecialization) {
        this.engSpecialization = engSpecialization;
    }

    @Column(nullable = false)
    @Min(1995)
    public int getYear () {
        return year;
    }

    public void setYear (int year) {
        this.year = year;
    }

    @OneToMany(mappedBy = "specialty")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public Set<Subject> getSubjects () {
        return subjects;
    }

    public void setSubjects (Set<Subject> subjects) {
        this.subjects = subjects;
    }
}