package diploma.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "subjects")
public class Subject {

    private Long id;
    private int semester;
    private String ukrName;
    private String engName;
    private String code;
    private float credit;
    private Specialty specialty;

    public Subject () {
    }

    public Subject (int semester, String ukrName, String engName, String code, float credit, Specialty specialty) {
        this.semester = semester;
        this.ukrName = ukrName;
        this.engName = engName;
        this.code = code;
        this.credit = credit;
        this.specialty = specialty;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Subject))
            return false;

        Subject subject = (Subject) o;

        if (semester != subject.semester)
            return false;
        if (Float.compare(subject.credit, credit) != 0)
            return false;
        if (!ukrName.equals(subject.ukrName))
            return false;
        if (!engName.equals(subject.engName))
            return false;
        if (!code.equals(subject.code))
            return false;
        return specialty.equals(subject.specialty);
    }

    @Override
    public int hashCode () {
        int result = semester;
        result = 31 * result + ukrName.hashCode();
        result = 31 * result + engName.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + (credit != +0.0f ? Float.floatToIntBits(credit) : 0);
        result = 31 * result + specialty.hashCode();
        return result;
    }

    @Override
    public String toString () {
        return "Subject{" + "id=" + id + ", semester=" + semester + ", ukrName='" + ukrName + '\'' + ", engName='" + engName + '\'' + ", code='" + code + '\'' + ", credit=" + credit + ", specialtyId=" + specialty.getId() + '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Min(1)
    @Max(6)
    public int getSemester () {
        return semester;
    }

    public void setSemester (int semester) {
        this.semester = semester;
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

    @Column(nullable = false, length = 60)
    @NotEmpty
    public String getCode () {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    @Column(nullable = false)
    @Min(0)
    @Max(10)
    public float getCredit () {
        return credit;
    }

    public void setCredit (float credit) {
        this.credit = credit;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "specialty_id")
    @Cascade({CascadeType.PERSIST, CascadeType.REFRESH})
    public Specialty getSpecialty () {
        return specialty;
    }

    public void setSpecialty (Specialty specialty) {
        this.specialty = specialty;
    }
}