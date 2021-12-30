package com.company;

import java.time.LocalDateTime;
import java.util.HashMap;

public class StatisticInfo {

    private double averagePressure;
    private double averageHumidity;
    private double averageTemperature;
    private HashMap<LocalDateTime, Double> minPressure;
    private HashMap<LocalDateTime, Double> maxPressure;
    private HashMap<LocalDateTime, Double> minHumidity;
    private HashMap<LocalDateTime, Double> maxHumidity;
    private HashMap<LocalDateTime, Double> maxTemperature;
    private HashMap<LocalDateTime, Double> minTemperature;
    private HashMap<String, Double> maxWindSpeed;
    private HashMap<String, Double> averageVector;

    // не забудь добавить  HashMap<String, Double>  и HashMap<String, Double> maxWindSpeed averageVector в конструктор
    public StatisticInfo(double averagePressure, double averageHumidity, double averageTemperature, HashMap<LocalDateTime,
            Double> minPressure, HashMap<LocalDateTime, Double> maxPressure, HashMap<LocalDateTime, Double> minHumidity,
                         HashMap<LocalDateTime, Double> maxHumidity, HashMap<LocalDateTime, Double> maxTemperature,
                         HashMap<LocalDateTime,
            Double> minTemperature,HashMap<String, Double> maxWindSpeed, HashMap<String, Double> averageVector) {
        this.averagePressure = averagePressure;
        this.averageHumidity = averageHumidity;
        this.averageTemperature = averageTemperature;
        this.averageVector = averageVector;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.minHumidity = minHumidity;
        this.maxHumidity = maxHumidity;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.maxWindSpeed = maxWindSpeed;
    }

    public double getAveragePressure() {
        return averagePressure;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public HashMap<String, Double> getAverageVector() {
        return averageVector;
    }

    public HashMap<LocalDateTime, Double> getMinPressure() {
        return minPressure;
    }

    public HashMap<LocalDateTime, Double> getMaxPressure() {
        return maxPressure;
    }

    public HashMap<LocalDateTime, Double> getMinHumidity() {
        return minHumidity;
    }

    public HashMap<LocalDateTime, Double> getMaxHumidity() {
        return maxHumidity;
    }

    public HashMap<LocalDateTime, Double> getMaxTemperature() {
        return maxTemperature;
    }

    public HashMap<LocalDateTime, Double> getMinTemperature() {
        return minTemperature;
    }

    public HashMap<String, Double> getMaxWindSpeed() {
        return maxWindSpeed;
    }

}










