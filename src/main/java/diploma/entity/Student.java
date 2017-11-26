package diploma.entity;

import diploma.enums.Degree;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    private Long id;
    private Long usedeId;
    private String ukrSurname;
    private String ukrName;
    private String ukrFatherName;
    private String ukrCountry;
    private String engSurname;
    private String engName;
    private String engFatherName;
    private String engCountry;
    private Degree degree;
    private Date dateOfBirth;
    private int getIntoYear;
    private int graduateYear;

    public Student () {
    }

    public Student (Long id, Long usedeId, String ukrSurname, String ukrName,
                    String ukrCountry, String engSurname, String engName, String engCountry,
                    Degree degree, Date dateOfBirth, int getIntoYear, int graduateYear) {
        this.id = id;
        this.usedeId = usedeId;
        this.ukrSurname = ukrSurname;
        this.ukrName = ukrName;
        this.ukrCountry = ukrCountry;
        this.engSurname = engSurname;
        this.engName = engName;
        this.engCountry = engCountry;
        this.degree = degree;
        this.dateOfBirth = dateOfBirth;
        this.getIntoYear = getIntoYear;
        this.graduateYear = graduateYear;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;

        Student student = (Student) o;

        if (getIntoYear != student.getIntoYear)
            return false;
        if (graduateYear != student.graduateYear)
            return false;
        if (!usedeId.equals(student.usedeId))
            return false;
        if (!ukrSurname.equals(student.ukrSurname))
            return false;
        if (!ukrName.equals(student.ukrName))
            return false;
        if (ukrFatherName != null ? !ukrFatherName.equals(student.ukrFatherName) : student.ukrFatherName != null)
            return false;
        if (!ukrCountry.equals(student.ukrCountry))
            return false;
        if (!engSurname.equals(student.engSurname))
            return false;
        if (!engName.equals(student.engName))
            return false;
        if (engFatherName != null ? !engFatherName.equals(student.engFatherName) : student.engFatherName != null)
            return false;
        if (!engCountry.equals(student.engCountry))
            return false;
        if (degree != student.degree)
            return false;
        return dateOfBirth.equals(student.dateOfBirth);
    }

    @Override
    public int hashCode () {
        int result = usedeId.hashCode();
        result = 31 * result + ukrSurname.hashCode();
        result = 31 * result + ukrName.hashCode();
        result = 31 * result + (ukrFatherName != null ? ukrFatherName.hashCode() : 0);
        result = 31 * result + ukrCountry.hashCode();
        result = 31 * result + engSurname.hashCode();
        result = 31 * result + engName.hashCode();
        result = 31 * result + (engFatherName != null ? engFatherName.hashCode() : 0);
        result = 31 * result + engCountry.hashCode();
        result = 31 * result + degree.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + getIntoYear;
        result = 31 * result + graduateYear;
        return result;
    }

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Column(name = "usede_id")
    @NotNull
    public Long getUsedeId () {
        return usedeId;
    }

    public void setUsedeId (Long usedeId) {
        this.usedeId = usedeId;
    }

    @Column(name = "ukr_surname")
    @NotNull
    @Size(max = 60)
    public String getUkrSurname () {
        return ukrSurname;
    }

    public void setUkrSurname (String ukrSurname) {
        this.ukrSurname = ukrSurname;
    }

    @Column(name = "ukr_name")
    @NotNull
    @Size(max = 60)
    public String getUkrName () {
        return ukrName;
    }

    public void setUkrName (String ukrName) {
        this.ukrName = ukrName;
    }

    @Column(name = "ukr_father_name")
    @Size(max = 60)
    public String getUkrFatherName () {
        return ukrFatherName;
    }

    public void setUkrFatherName (String ukrFatherName) {
        this.ukrFatherName = ukrFatherName;
    }

    @Column(name = "ukr_country")
    @NotNull
    @Size(max = 60)
    public String getUkrCountry () {
        return ukrCountry;
    }

    public void setUkrCountry (String ukrCountry) {
        this.ukrCountry = ukrCountry;
    }

    @Column(name = "eng_surname")
    @NotNull
    @Size(max = 60)
    public String getEngSurname () {
        return engSurname;
    }

    public void setEngSurname (String engSurname) {
        this.engSurname = engSurname;
    }

    @Column(name = "eng_name")
    @NotNull
    @Size(max = 60)
    public String getEngName () {
        return engName;
    }

    public void setEngName (String engName) {
        this.engName = engName;
    }

    @Column(name = "eng_father_name")
    @Size(max = 60)
    public String getEngFatherName () {
        return engFatherName;
    }

    public void setEngFatherName (String engFatherName) {
        this.engFatherName = engFatherName;
    }

    @Column(name = "eng_country")
    @NotNull
    @Size(max = 60)
    public String getEngCountry () {
        return engCountry;
    }

    public void setEngCountry (String engCountry) {
        this.engCountry = engCountry;
    }

    @Column(name = "degree", columnDefinition = "enum('Bachelor','Specialist','Master')")
    @NotNull
    @Enumerated(EnumType.STRING)
    public Degree getDegree () {
        return degree;
    }

    public void setDegree (Degree degree) {
        this.degree = degree;
    }

    @Column(name = "date_of_birth")
    @NotNull
    @Temporal(TemporalType.DATE)
    public Date getDateOfBirth () {
        return dateOfBirth;
    }

    public void setDateOfBirth (Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "get_into_year")
    @NotNull
    @Min(2000)
    public int getGetIntoYear () {
        return getIntoYear;
    }

    public void setGetIntoYear (int getIntoYear) {
        this.getIntoYear = getIntoYear;
    }

    @Column(name = "graduate_year")
    @NotNull
    @Min(2001)
    public int getGraduateYear () {
        return graduateYear;
    }

    public void setGraduateYear (int graduateYear) {
        this.graduateYear = graduateYear;
    }
}