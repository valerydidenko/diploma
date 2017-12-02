package diploma.entity;

import diploma.enums.RoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    private Long id;
    private String login;
    private String password;
    private String ukrSurname;
    private String ukrName;
    private String engSurname;
    private String engName;
    private RoleEnum role;

    public User () {
    }

    public User (String login, String password, String ukrSurname, String ukrName, String engSurname, String engName, RoleEnum role) {
        this.login = login;
        this.password = password;
        this.ukrSurname = ukrSurname;
        this.ukrName = ukrName;
        this.engSurname = engSurname;
        this.engName = engName;
        this.role = role;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;

        User user = (User) o;

        if (!login.equals(user.login))
            return false;
        if (!ukrSurname.equals(user.ukrSurname))
            return false;
        if (!ukrName.equals(user.ukrName))
            return false;
        if (!engSurname.equals(user.engSurname))
            return false;
        return engName.equals(user.engName);
    }

    @Override
    public int hashCode () {
        int result = login.hashCode();
        result = 31 * result + ukrSurname.hashCode();
        result = 31 * result + ukrName.hashCode();
        result = 31 * result + engSurname.hashCode();
        result = 31 * result + engName.hashCode();
        return result;
    }

    @Override
    public String toString () {
        return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + ", ukrSurname='" + ukrSurname + '\'' + ", ukrName='" + ukrName + '\'' + ", engSurname='" + engSurname + '\'' + ", engName='" + engName + '\'' + ", role=" + role + '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 16)
    public String getLogin () {
        return login;
    }

    public void setLogin (String login) {
        this.login = login;
    }

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 4, max = 16)
    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @Column(name = "ukr_surname", nullable = false, length = 60)
    @NotEmpty
    public String getUkrSurname () {
        return ukrSurname;
    }

    public void setUkrSurname (String ukrSurname) {
        this.ukrSurname = ukrSurname;
    }

    @Column(name = "ukr_name", nullable = false, length = 60)
    @NotEmpty
    public String getUkrName () {
        return ukrName;
    }

    public void setUkrName (String ukrName) {
        this.ukrName = ukrName;
    }

    @Column(name = "eng_surname", nullable = false, length = 60)
    @NotEmpty
    public String getEngSurname () {
        return engSurname;
    }

    public void setEngSurname (String engSurname) {
        this.engSurname = engSurname;
    }

    @Column(name = "eng_name", nullable = false, length = 60)
    @NotEmpty
    public String getEngName () {
        return engName;
    }

    public void setEngName (String engName) {
        this.engName = engName;
    }

    @Column(name = "role", nullable = false, columnDefinition = "enum('ADMIN','USER')")
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole () {
        return role;
    }

    public void setRole (RoleEnum role) {
        this.role = role;
    }
}