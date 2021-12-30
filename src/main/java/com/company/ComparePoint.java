package com.company;

import java.time.LocalDate;

public class ComparePoint {
    WindName windName = new WindName();
    public void compareInfo(PointInformation point1, PointInformation point2, LocalDate date) {
        double aX=point1.getX();
        double aY=point1.getY();
        double bX = point2.getX();
        double bY = point2.getY();
        MeteorogicalInfo info1 = point1.getInfo();
        MeteorogicalInfo info2 = point2.getInfo();
        String temp = "В точке %s %s %s за %s \n %s %s %s";


        System.out.println(String.format(temp,"A",aX,aY,date,"средняя температура воздуха составляла",info1.getTemp(),"°С"));
        System.out.println(String.format(temp,"B",bX,bY,date,"средняя температура воздуха составляла",info2.getTemp(),"°С"));
        System.out.println("Разница составляет " + Math.abs(info1.getTemp() - info2.getTemp())+" °С"
                + "\n");


        System.out.println(String.format(temp,"A",aX,aY,date,"среднесуточное давление составляело",info1.getPressure(),"мм рт ст."));
        System.out.println(String.format(temp,"B",bX,bY,date,"среднесуточное давление составляело",info2.getPressure(),"мм рт ст."));
        System.out.println("Разница составляет " + Math.abs(info1.getPressure() - info2.getPressure())
                + "\n");

        System.out.println("В точке А " + aX + "," + aY +" за " + date + " преобладал ветер "+
                windName.getWindName(info1.getWindDirection())+ " c силой " + info1.getWindSpeed());
        System.out.println("В точке B " + bX + "," + bY +" за " + date + " преобладал ветер "+
                windName.getWindName(info2.getWindDirection())+ " c силой " + info2.getWindSpeed()+"\n");

        System.out.println(String.format(temp,"A",aX,aY,date,"относительная влажность равна",info1.getHumidity(),"φ"));
        System.out.println(String.format(temp,"B",bX,bY,date,"относительная влажность равна",info1.getHumidity(),"φ"));
        System.out.println("Разница составляет " + Math.abs(info1.getHumidity() - info2.getHumidity())
                + "\n");
    }
}
