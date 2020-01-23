package models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User{

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "user_role")
    private String role;

    public User() {
    }

    public User(String firstName, String lastName, String password, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthday = birthday;
    }

    public User(int id, String firstName, String lastName, String password, Date birthday) {
        this(firstName, lastName, password, birthday);
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }
}


