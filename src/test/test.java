package test;

import models.*;
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
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Ordeno los datos por nombre alfabeticamente en->"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        users.find(new ICriteria<User>() {
            @Override
            public boolean find(User user) {
                return user.getName().contains("Pepe");
            }

            @Override
            public boolean isExist(User user) {
                return false;
            }

            @Override
            public boolean remove(User user) {
                return false;
            }
        });
        System.out.println("Busqueda secuencial en->"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        users.binarySearch(new ICriteria<User>() {
            @Override
            public boolean find(User user) {
                return user.getId()>100000;
            }

            @Override
            public boolean isExist(User user) {
                return false;
            }

            @Override
            public boolean remove(User user) {
                return false;
            }
        });
        System.out.println("Busqueda binaria en->"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        users.addElement(new User("Harrison",13456,LocalDate.of(2001,7,1),Gender.MALE,new GPS("5 N","6 E")));
        System.out.println("Añadi  en->"+(System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        users.remove(new ICriteria<User>() {
            @Override
            public boolean find(User user) {
                return false;
            }

            @Override
            public boolean isExist(User user) {
                return false;
            }

            @Override
            public boolean remove(User user) {
                return user.getAge()==20;
            }
        });
        System.out.println("Removi  en->"+(System.currentTimeMillis()-time));


    }

}
