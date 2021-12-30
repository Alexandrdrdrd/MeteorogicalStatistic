package com.company;

public class WindName {
    public String getWindName(double degrees){
        String[] directions   = {"north", "northeast","east", "southeast", "south", "southwest", "west", "northwest"};

        degrees = degrees * 8 / 360;
        degrees = Math.round(degrees);
        degrees = (degrees + 8) % 8;
        return directions[(int)degrees];

    }
}
