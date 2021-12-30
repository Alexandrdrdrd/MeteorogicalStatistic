package com.company;

import java.time.LocalDate;

public class PointInformation {
    private double x;
    private double y;
    private int height;
    private LocalDate date;
    private LocalDate date1;
    private MeteorogicalInfo info;
    private StatisticInfo statisticInfo;

    public StatisticInfo getStatisticInfo() {
        return statisticInfo;
    }

    public void setStatisticInfo(StatisticInfo statisticInfo) {
        this.statisticInfo = statisticInfo;
    }

    public MeteorogicalInfo getInfo() {
        return info;
    }

    public void setInfo(MeteorogicalInfo info) {
        this.info = info;
    }



    public LocalDate getDate1() {
        return date1;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public PointInformation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
