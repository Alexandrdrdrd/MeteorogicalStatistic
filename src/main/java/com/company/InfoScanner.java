package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InfoScanner {
    Validator validator = new Validator();


    public PointInformation getCoordinates(Scanner sc) {
        String x;
        String y;
        do {
            System.out.print("input latitude  (double)\n");
            x = sc.nextLine();
            System.out.println("input longitude  (double)");
            y = sc.nextLine();
        } while (!validator.coordinatesValidator(x, y));
        return new PointInformation(Double.parseDouble(x), Double.parseDouble(y));

    }


    public int getMode(Scanner sc) {
        String mode;
        do {
            System.out.println(" Select the mode number\n 1.comparisons\n 2.statistics \n 0 for exit");
            mode = sc.nextLine();
        } while (!validator.modeValidator(mode));
        return Integer.parseInt(mode);
    }


    public LocalDate getDate(Scanner sc) {
        String str;
        DateTimeFormatter dtf;
        do {
            System.out.println("Enter a date (yyyy-MM-dd)");

            str = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } while (!validator.dataValidator(str, dtf));

        LocalDate dateTime = LocalDate.parse(str, dtf);

        return dateTime;}

        public LocalDate getDate(Scanner sc,LocalDate date1) {
        String str;
        DateTimeFormatter dtf;
        do {
            System.out.println("Enter a date (yyyy-MM-dd)");

            str = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } while (!validator.dataValidator(str, dtf,date1));

        LocalDate dateTime = LocalDate.parse(str, dtf);

        return dateTime;
    }

}