package diploma.entity;

import diploma.enums.RoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User extends Person {

    private static final long serialVersionUID = -4783644335006899959L;

    private Long id;
    private String login;
    private String password;
    private RoleEnum role;

    public User() {
    }

    public User(String login, String password, String ukrSurname,
                String ukrName, String ukrFatherName, String engSurname,
                String engName, String engFatherName, RoleEnum role) {
        super(ukrSurname, ukrName, ukrFatherName, engSurname, engName, engFatherName);
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", " + super.toString() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 16)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}