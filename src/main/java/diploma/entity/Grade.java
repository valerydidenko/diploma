package diploma.entity;

import diploma.entity.embeddableIds.GradePrimaryKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "grades")
public class Grade implements Serializable {

    private static final long serialVersionUID = 8348969852028945954L;

    private GradePrimaryKey id;
    private int onpuGrade;
    private String euroGrade;

    public Grade() {
    }

    public Grade(GradePrimaryKey id, int onpuGrade, String euroGrade) {
        this.id = id;
        this.onpuGrade = onpuGrade;
        this.euroGrade = euroGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return onpuGrade == grade.onpuGrade &&
                Objects.equals(id, grade.id) &&
                Objects.equals(euroGrade, grade.euroGrade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, onpuGrade, euroGrade);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", onpuGrade=" + onpuGrade +
                ", euroGrade='" + euroGrade + '\'' +
                '}';
    }

    @EmbeddedId
    public GradePrimaryKey getId() {
        return id;
    }

    public void setId(GradePrimaryKey id) {
        this.id = id;
    }

    @Column(name = "onpu_grade", nullable = false)
    @Min(0)
    @Max(100)
    public int getOnpuGrade() {
        return onpuGrade;
    }

    public void setOnpuGrade(int onpuGrade) {
        this.onpuGrade = onpuGrade;
    }

    @Column(name = "euro_grade", nullable = false, length = 3)
    public String getEuroGrade() {
        return euroGrade;
    }

    public void setEuroGrade(String euroGrade) {
        this.euroGrade = euroGrade;
    }
}