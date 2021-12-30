package com.company;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class OpenElevationHTTPClient {
    private static final String Elevation_URL = "https://api.open-elevation.com/api/v1/lookup?locations=%s,%s";

    public int get_Elevation(PointInformation point) {
        try {

            String url = String.format(Elevation_URL, point.getX(), point.getY());

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


            JsonNode respons =  new ObjectMapper().readTree(response.toString());
            return respons.get("results").get(0).get("elevation").asInt();


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
