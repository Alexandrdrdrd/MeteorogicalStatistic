package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class NasaHTTPClient {
    private static final String NASA_URL_DAILY = "https://power.larc.nasa.gov/api/temporal/daily/point?start=%s&end=%s&latitude=%s&longitude=%s&community=ag&format=json&header=true&time-standard=lst&site-elevation=%s&parameters=";
    private static final String NASA_URL_HOURLY = "https://power.larc.nasa.gov/api/temporal/hourly/point?start=%s&end=%s&latitude=%s&longitude=%s&community=ag&format=json&header=true&time-standard=lst&site-elevation=%s&parameters=";



    public MeteorogicalInfo getMeteoInf(PointInformation point) {
        try {

            String parameters = "PSC,RH2M,T2M,WD2M,WS2M";
            String date = point.getDate().toString().replaceAll("-", "");
            String url = String.format(NASA_URL_DAILY, date, date, point.getX(), point.getY(), point.getHeight()) + parameters;

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JsonNode respons = new ObjectMapper().readTree(response.toString());
            JsonNode params = respons.get("properties").get("parameter");
            double T2M = params.get("T2M").get(date).asDouble();
            double PSC = params.get("PSC").get(date).asDouble();
            double WD2M = params.get("WD2M").get(date).asDouble();
            double WS2M = params.get("WS2M").get(date).asDouble();
            double RH2M = params.get("RH2M").get(date).asDouble();

            MeteorogicalInfo meteorogicalInfo = new MeteorogicalInfo(T2M, PSC, WD2M, WS2M, RH2M);
            point.setInfo(meteorogicalInfo);
            return meteorogicalInfo;
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public StatisticInfo getMeteoInf(PointInformation point, int mode) {
        try {
            StatisticCalculator statisticCalculator = new StatisticCalculator();
            String parameters = "WD2M,PSC,RH2M,T2M,WS2M";
            String date0 = point.getDate().toString().replaceAll("-", "");
            String date1 = point.getDate1().toString().replaceAll("-", "");

            String url = String.format(NASA_URL_HOURLY, date0, date1, point.getX(), point.getY(), point.getHeight()) + parameters;

            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JsonNode respons = new ObjectMapper().readTree(response.toString());
            JsonNode params = respons.get("properties").get("parameter");

            double averagePressure = statisticCalculator.getAVG(params, point.getDate(),"PSC" );
            double averageHumidity = statisticCalculator.getAVG(params,point.getDate(),"RH2M");
            double averageTemperature = statisticCalculator.getAVG(params,point.getDate(),"T2M");
            HashMap minPressure = statisticCalculator.getMin(params,point.getDate(),"PSC");
            HashMap maxPressure = statisticCalculator.getMax(params,point.getDate(),"PSC");
            HashMap minHumidity = statisticCalculator.getMin(params,point.getDate(),"RH2M");
            HashMap maxHumidity = statisticCalculator.getMax(params,point.getDate(),"RH2M");
            HashMap maxTemperature = statisticCalculator.getMax(params,point.getDate(),"T2M");
            HashMap minTemperature = statisticCalculator.getMin(params,point.getDate(),"T2M");
            HashMap maxWindSpeed = statisticCalculator.getMaxSpeedWind(params,point.getDate());
            HashMap getAverageVector = statisticCalculator.averageVector(params,point.getDate());


            StatisticInfo statisticInfo = new StatisticInfo(averagePressure,averageHumidity,averageTemperature
                    , minPressure, maxPressure, minHumidity, maxHumidity,maxTemperature
                    ,minTemperature,maxWindSpeed,getAverageVector);
            point.setStatisticInfo(statisticInfo);
            return statisticInfo;
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
