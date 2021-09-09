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


}
