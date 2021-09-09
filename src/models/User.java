package models;

import java.time.LocalDate;

public class User {

    private String name;
    private long id;
    LocalDate birthDate;
    Gender gender;

    public User(String name, long id, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }
}
