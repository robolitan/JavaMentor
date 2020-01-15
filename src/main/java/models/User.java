package models;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String password;
    private Gender gender;
    private LocalDate birthday;

    public User() {
    }

    public User(String name, String password, Gender gender, LocalDate birthday) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User(int id, String name, String password,Gender gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }
}


