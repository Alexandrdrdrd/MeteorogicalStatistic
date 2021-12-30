package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class WriterFile {
    public void writeFile(StatisticInfo statisticInfo) {
        try (FileWriter writer = new FileWriter("Statistic.txt", false)) {

            String text = "average value for the period" + "\n"
                    + "Corrected Atmospheric Pressure " + statisticInfo.getAveragePressure() + "\n" +
                    "Relative Humidity at 2 Meters " + statisticInfo.getAverageHumidity() + "\n" +
                    "Temperature at 2 Meters " + statisticInfo.getAverageTemperature() + "\n" +
                    "Prevailing wind vector " + statisticInfo.getAverageVector() + "\n" +
                    "minimum and maximum according to indications, indicating the day /" +
                    " hour when this indicator was recorded " + "\n" +
                    "Corrected Atmospheric Pressure (Adjusted For Site Elevation) " +
                    statisticInfo.getMaxPressure().keySet() + " " + statisticInfo.getMaxPressure().values() + " maximum  "
                    + "\n" + statisticInfo.getMinPressure().keySet() + " " + statisticInfo.getMinPressure().values() + " minimum" + "\n" +
                    "Relative Humidity at 2 Meters " +
                    statisticInfo.getMaxHumidity().keySet() + " " + statisticInfo.getMaxHumidity().values() + " maximum  "
                    + "\n" + statisticInfo.getMinHumidity().keySet() + " " + statisticInfo.getMinHumidity().values() + " minimum" + "\n" +
                    "Temperature at 2 Meters " +
                    statisticInfo.getMaxTemperature().keySet() + " " + statisticInfo.getMaxTemperature().values() + " maximum  "
                    + "\n" + statisticInfo.getMinTemperature().keySet() + " " + statisticInfo.getMinTemperature().values() + " minimum" + "\n" +
                    "Maximum wind speed " + statisticInfo.getMaxWindSpeed();

            writer.write(text);


            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
