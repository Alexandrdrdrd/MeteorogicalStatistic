package com.company;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StatisticCalculator {
    WindName windName = new WindName();

    public double getAVG(JsonNode params, LocalDate date0, String field) {
        String str = date0.toString() + "-0";
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-H");
        LocalDateTime dateTime = LocalDateTime.parse(str, dtf);
        double[] allInfo = new double[params.get(field).size()];
        for (int i = 0; params.get(field).size() > i; i++) {
            allInfo[i] = params.get(field).get(dateTime.plusHours(i).toString().replaceAll("-", "")
                    .replaceAll("T", "").substring(0, 10)).asDouble();
        }

        return Arrays.stream(allInfo).sum() / allInfo.length;
    }

    public HashMap getMin(JsonNode params, LocalDate date0, String field) {
        int i;
        int dateIndex = -1;
        String str = date0.toString() + "-0";
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-H");
        LocalDateTime dateTime = LocalDateTime.parse(str, dtf);
        HashMap<LocalDateTime, Double> minValueMap = new HashMap<>();

        double minValue = params.get(field).get(dateTime.plusHours(0).toString().replaceAll("-", "")
                .replaceAll("T", "").substring(0, 10)).asDouble();

        for (i = 0; params.get(field).size() > i; i++) {
            if (minValue > params.get(field).get(dateTime.plusHours(i).toString().replaceAll("-", "")
                    .replaceAll("T", "").substring(0, 10)).asDouble()) {
                minValue = params.get(field).get(dateTime.plusHours(i).toString().replaceAll("-", "")
                        .replaceAll("T", "").substring(0, 10)).asDouble();
                dateIndex = i;
            }
        }
        if (dateIndex==-1){
            System.out.println("Fatal error: JSON is empty");
            System.exit(0);
        }
        minValueMap.put((dateTime.plusHours(dateIndex)), minValue);

        return minValueMap;


    }


    public HashMap getMax(JsonNode params, LocalDate date0, String field) {
        int i;
        int dateIndex = -1;
        String str = date0.toString() + "-0";
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-H");
        LocalDateTime dateTime = LocalDateTime.parse(str, dtf);
        HashMap<LocalDateTime, Double> maxValueMap = new HashMap<>();

        double maxValue = params.get(field).get(dateTime.plusHours(0).toString().replaceAll("-", "")
                .replaceAll("T", "").substring(0, 10)).asDouble();
        for (i = 0; params.get(field).size() > i; i++) {
            if (maxValue < params.get(field).get(dateTime.plusHours(i).toString().replaceAll("-", "")
                    .replaceAll("T", "").substring(0, 10)).asDouble()) {
                maxValue = params.get(field).get(dateTime.plusHours(i).toString().replaceAll("-", "")
                        .replaceAll("T", "").substring(0, 10)).asDouble();
            }
            dateIndex = i;
        }
        if (dateIndex==-1){
            System.out.println("Fatal error: JSON is empty");
            System.exit(0);
        }
        maxValueMap.put(dateTime.plusHours(dateIndex), maxValue);

        return maxValueMap;
    }

    public HashMap getMaxSpeedWind(JsonNode params, LocalDate date0) {
        int i;
        int dateIndex = -1;
        String str = date0.toString() + "-0";
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-H");
        LocalDateTime dateTime = LocalDateTime.parse(str, dtf);
        HashMap<String, Double> maxValueMap = new HashMap<>();
        double maxValue = params.get("WS2M").get(dateTime.plusHours(0).toString().replaceAll("-", "")
                .replaceAll("T", "").substring(0, 10)).asDouble();
        for (i = 0; params.get("WS2M").size() > i; i++) {
            if (maxValue < params.get("WS2M").get(dateTime.plusHours(i).toString().replaceAll("-", "")
                    .replaceAll("T", "").substring(0, 10)).asDouble()) {
                maxValue = params.get("WS2M").get(dateTime.plusHours(i).toString().replaceAll("-", "")
                        .replaceAll("T", "").substring(0, 10)).asDouble();
            }
            dateIndex = i;
        }
        maxValueMap.put(windName.getWindName(params.get("WS2M").get(dateTime.plusHours(dateIndex).toString()
                .replaceAll("-", "")
                .replaceAll("T", "").substring(0, 10)).asDouble()), maxValue);

        return maxValueMap;
    }

    public HashMap averageVector(JsonNode params, LocalDate date0) {
        int i;
        int dateIndex = -1;
        String str = date0.toString() + "-0";
        DateTimeFormatter dtf;
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-H");
        LocalDateTime dateTime = LocalDateTime.parse(str, dtf);

        String[] directions = {"north", "northeast", "east", "southeast", "south", "southwest", "west", "northwest"};

        HashMap<String, List<Double>> windInfo = new HashMap<>();
        for (i = 0; i < directions.length; i++) {
            List<Double> list = new LinkedList<>();
            windInfo.put(directions[i], list);
        }
        for (i = 0; params.get("WD2M").size() > i; i++) {
            windInfo.get(windName.getWindName((params.get("WD2M").get(dateTime.plusHours(i)
                            .toString().replaceAll("-", "")
                            .replaceAll("T", "").substring(0, 10)).asDouble())))
                    .add(params.get("WS2M").get(dateTime.plusHours(i)
                            .toString().replaceAll("-", "")
                            .replaceAll("T", "").substring(0, 10)).asDouble());
        }
        int indexOfPrevailDirection = 0;
        for (i = 0; i < 8; i++) {
            if (windInfo.get(directions[i]).size() > indexOfPrevailDirection) {
                indexOfPrevailDirection = i;
            }
        }
        double AVGSpeed = -1.0;
        for (i = 0; windInfo.get(directions[indexOfPrevailDirection]).size() > i; i++) {
            double SumSpeed = 0;
            SumSpeed += windInfo.get(directions[indexOfPrevailDirection]).get(i);
            AVGSpeed = SumSpeed / windInfo.get(directions[indexOfPrevailDirection]).size();
        }

        HashMap<String, Double> averageVector = new HashMap<>();
        averageVector.put(directions[indexOfPrevailDirection], AVGSpeed);

        return averageVector;
    }

}
// поменять принтлайны
// роза ветров
// понедельник 16 30 - 17