package diploma.entity.embeddableIds;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradePrimaryKey implements Serializable {

    private static final long serialVersionUID = -9039761497909500660L;

    private Long studentId;
    private Long subjectId;

    public GradePrimaryKey() {
    }

    public GradePrimaryKey(Long studentId, Long subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradePrimaryKey that = (GradePrimaryKey) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(subjectId, that.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, subjectId);
    }

    @Override
    public String toString() {
        return "GradePrimaryKey{" +
                "studentId=" + studentId +
                ", subjectId=" + subjectId +
                '}';
    }

    @Column(name = "student_id", nullable = false)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Column(name = "subject_id", nullable = false)
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
