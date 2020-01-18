package models;

import javax.persistence.*;
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
    private LocalDate birthday;

    public User() {
    }

    public User(String firstName, String lastName, String password, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthday = birthday;
    }

    public User(int id, String firstName, String lastName, String password, LocalDate birthday) {
        this(firstName, lastName, password, birthday);
        this.id = id;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }
}


