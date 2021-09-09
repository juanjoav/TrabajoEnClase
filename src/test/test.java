package test;

import models.Gender;
import models.ICriteria;
import models.MyArray;
import models.User;
import persistence.ReadFile;

import java.time.LocalDate;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        MyArray<User> users = new ReadFile("plane/Users.csv").getUsersList();
        System.out.println("Tardo en leer los datos->"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return ;
            }
        });



    }

}
