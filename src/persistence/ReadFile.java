package persistence;

import models.GPS;
import models.Gender;
import models.MyArray;
import models.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReadFile {

    private MyFile myFile;
    private MyFile rejectedUser;
    private MyArray<User> usersList;

    public ReadFile(String file) {
        myFile = new MyFile(file);
        usersList = new MyArray();
        getMyFile(myFile);
    }

    public void getMyFile(MyFile file) {
        String cyclistFile;
        String [] cyclistAttributes;
        file.open(MyFile.DOCUMENT_READ);

        while(((cyclistFile = file.reader()) != null)) {
            cyclistAttributes = cyclistFile.split(";");
            long id = Long.parseLong(cyclistAttributes[1]);
            String name = cyclistAttributes[2] + cyclistAttributes[3];
            Gender gender = obtainGender(Integer.parseInt(cyclistAttributes[4]));
            LocalDate date = Components.toStringReadLocalDate(cyclistAttributes[5]);
            String latitude = cyclistAttributes[6];
            String longitude = cyclistAttributes[7];

            GPS gps = new GPS(latitude,longitude);
            User user = new User(name,id,date,gender,gps);
            usersList.addElement(user);
        }
        myFile.close();

    }

    public Gender obtainGender(int gender) {
        switch(gender) {
            case 0:
                return Gender.MALE;
                case 1:
                    return Gender.FEMALE;
        }
        return Gender.OTHER;
    }

    public MyArray<User> getUsersList() {
        return usersList;
    }

}
