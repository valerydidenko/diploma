package diploma.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "exclusions")
public class Exclusion implements Serializable{

    private static final long serialVersionUID = -1444535150512840093L;

    private Long id;
    private String ukrReason;
    private String engReason;

    public Exclusion() {
    }

    public Exclusion(String ukrReason, String engReason) {
        this.ukrReason = ukrReason;
        this.engReason = engReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exclusion exclusion = (Exclusion) o;
        return Objects.equals(ukrReason, exclusion.ukrReason) &&
                Objects.equals(engReason, exclusion.engReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ukrReason, engReason);
    }

    @Override
    public String toString() {
        return "Exclusion{" +
                "id=" + id +
                ", ukrReason='" + ukrReason + '\'' +
                ", engReason='" + engReason + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "exclusion_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ukr_reason", nullable = false, length = 1000)
    @NotEmpty
    public String getUkrReason() {
        return ukrReason;
    }

    public void setUkrReason(String ukrReason) {
        this.ukrReason = ukrReason;
    }

    @Column(name = "eng_reason", nullable = false, length = 1000)
    @NotEmpty
    public String getEngReason() {
        return engReason;
    }

    public void setEngReason(String engReason) {
        this.engReason = engReason;
    }
}