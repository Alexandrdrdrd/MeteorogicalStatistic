package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Validator {
    boolean coordinatesValidator(String xStr, String yStr) {
        try {

            double x = Double.parseDouble(xStr);
            if ((-90 >= x) || (x >= 90)) {
                System.out.println("incorrect input");
                return false;
            }
            double y = Double.parseDouble(yStr);
            if ((-180 > y) || (y > 180)) {
                System.out.println("incorrect input");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("incorrect input");
            return false;
        }
    }



    boolean modeValidator(String modeStr) {
        try {
            int mode = Integer.parseInt(modeStr);
            if (mode > 2 || mode < 0) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("incorrect input");
            return false;
        }
    }

    boolean dataValidator(String str, DateTimeFormatter dtf) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate dateTime = LocalDate.parse(str, dtf);
            if (dateTime.isEqual(ChronoLocalDate.from(now))) {
                System.out.println("statistics for the current day are not available, please try to enter a later date");
                return false;
            } else if (dateTime.isAfter(ChronoLocalDate.from(now))) {
                System.out.println("incorrect input");
                return false;
            } else {
                return true;
            }
        } catch (DateTimeException e) {
            return false;
        }

    }
    boolean dataValidator(String str, DateTimeFormatter dtf, LocalDate date1) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate dateTime = LocalDate.parse(str, dtf);
            if (dateTime.isEqual(ChronoLocalDate.from(now))) {
                System.out.println("statistics for the current day are not available, please try to enter a later date");
                return false;
            } else if (dateTime.isAfter(ChronoLocalDate.from(now))) {
                System.out.println("incorrect input");
                return false;
            } else if (dateTime.isBefore(date1)){
                System.out.println("incorrect input, the end date must be later than the start date");
                return false;
            } else return true;
        } catch (DateTimeException e) {
            return false;
        }

    }
}
