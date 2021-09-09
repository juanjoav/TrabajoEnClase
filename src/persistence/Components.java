/*
 * Copyright (c) 25/2/2021.
 * Created by Juan Jose Ariza Velasco
 * All rights reserved
 */

package persistence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Components {


    /**
     * Este metodo convierte los Dates del toeguer a Local Date
     * @param date recibe un Date de un toeguer
     * @return la fecha de nacimiento del corredor
     */
    public static LocalDate convertTime(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    /**
     * Este metodo convierte los Dates a Local Time
     * @param dateTime recibe un String
     * @return el tiempo empleado
     */
    public static LocalTime convertTimeUsed(String dateTime){
        return LocalTime.parse(dateTime);
    }

    public static LocalDate toStringReadLocalDate(String timeReaded){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate timeInFormat = LocalDate.parse(timeReaded,formatter);
        return timeInFormat;
    }

    public static String toSaveLocalDate(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
        return localDate.format(formatter);
    }

}
