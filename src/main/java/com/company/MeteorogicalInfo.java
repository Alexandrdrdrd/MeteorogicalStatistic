package com.company;

public class MeteorogicalInfo {
    private double temp;
    private double pressure;
    private double windDirection;
    private double windSpeed;
    private double Humidity;
    private double windSpeedMax;


    public double getHumidity() {
        return Humidity;
    }


    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public MeteorogicalInfo(double temp, double pressure, double windDirection, double windSpeed, double Humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.Humidity = Humidity;


    }
}