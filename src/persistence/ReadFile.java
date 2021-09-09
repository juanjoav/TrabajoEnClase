package persistence;

import models.Gender;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReadFile {

    private MyFile myFile;
    private MyFile rejectedUser;

    public ReadFile(String file) {
        myFile = new MyFile(file);
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
}
