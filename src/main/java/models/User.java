package models;

import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
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


