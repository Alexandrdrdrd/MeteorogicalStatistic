package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Analyzer {
    InfoScanner infoScanner = new InfoScanner();
    OpenElevationHTTPClient openElevationHTTPClient = new OpenElevationHTTPClient();
    Scanner sc = new Scanner(System.in);
    NasaHTTPClient metInfo = new NasaHTTPClient();
    ComparePoint compare = new ComparePoint();
    WriterFile writerFile = new WriterFile();


    public void run() {

        int mode = infoScanner.getMode(sc);

        switch (mode) {
            case 1 -> {
                System.out.println("Enter data for first point");
                PointInformation point1 = infoScanner.getCoordinates(sc);
                System.out.println("Enter data for second point");
                PointInformation point2 = infoScanner.getCoordinates(sc);
                int height1 = openElevationHTTPClient.get_Elevation(point1);
                point1.setHeight(height1);
                int height2 = openElevationHTTPClient.get_Elevation(point1);
                point2.setHeight(height2);
                LocalDate date = infoScanner.getDate(sc);
                point1.setDate(date);
                point2.setDate(date);
                point1.setInfo(metInfo.getMeteoInf(point1));
                point2.setInfo(metInfo.getMeteoInf(point2));
                compare.compareInfo(point1, point2, date);
            }
            case (2) -> {
                PointInformation point0 = infoScanner.getCoordinates(sc);
                int height0 = openElevationHTTPClient.get_Elevation(point0);
                point0.setHeight(height0);
                System.out.println("Enter date start");
                LocalDate date1 = infoScanner.getDate(sc);
                System.out.println("Enter date end");
                LocalDate date2 = infoScanner.getDate(sc,date1);
                point0.setDate(date1);
                point0.setDate1(date2);
                point0.setStatisticInfo(metInfo.getMeteoInf(point0, mode));
                writerFile.writeFile(point0.getStatisticInfo());

            }
            case (3) -> System.exit(0);
        }

        sc.close();
    }


}