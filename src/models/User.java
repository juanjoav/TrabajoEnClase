package models;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;
    private long id;
    private LocalDate birthDate;
    private Gender gender;
    private GPS gps;

    public User(String name, long id, LocalDate birthDate, Gender gender, GPS gps) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
        this.gps = gps;
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


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public GPS getGps() {
        return gps;
    }

    public int getAge(){
        return Period.between(getBirthDate(),LocalDate.now() ).getYears();
    }
}
