package diploma.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {

    private static final long serialVersionUID = -1479667432527336018L;

    private Long id;
    private int semester;
    private String ukrName;
    private String engName;
    private String code;
    private float credit;
    private Specialty specialty;

    public Subject() {
    }

    public Subject(int semester, String ukrName, String engName,
                   String code, float credit, Specialty specialty) {
        this.semester = semester;
        this.ukrName = ukrName;
        this.engName = engName;
        this.code = code;
        this.credit = credit;
        this.specialty = specialty;
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

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
    	this.specialty = specialty;
    }
}