package diploma.entity;

import diploma.enums.PositionEnum;
import diploma.enums.PositionTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "positions")
public class Position implements Serializable {

    private static final long serialVersionUID = -257647851008130698L;

    private Long id;
    private PositionTypeEnum positionType;
    private PositionEnum position;

    public Position() {
    }

    public Position(PositionTypeEnum positionType, PositionEnum position) {
        this.positionType = positionType;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return positionType == position1.positionType &&
                position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionType, position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionType=" + positionType +
                ", position=" + position +
                '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "position_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "position_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public PositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    @Column(name = "position_name", nullable = false)
    @Enumerated(EnumType.STRING)
    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }
}