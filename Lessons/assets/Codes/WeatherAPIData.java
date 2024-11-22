// Tomado y adaptado de: https://www.youtube.com/watch?v=WS_H44tvZMI
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPIData {
    public static void main(String[] args) {
        try{
            try (Scanner scanner = new Scanner(System.in)) {
              String city;
              do{
                  // Retrieve user input
                  System.out.println("===================================================");
                  System.out.print("Enter City (Say No to Quit): ");
                  city = scanner.nextLine();

                  if(city.equalsIgnoreCase("No")) break;

                  // Get location data
                  JSONObject cityLocationData = (JSONObject) getLocationData(city);
                  BigDecimal latitude = (BigDecimal) cityLocationData.get("latitude");
                  BigDecimal longitude = (BigDecimal) cityLocationData.get("longitude");

                  System.out.printf("Longitude: %.2f%nLatitude: %.2f%n", longitude, latitude);
                  displayWeatherData(latitude, longitude);
              }while(!city.equalsIgnoreCase("No"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static JSONObject getLocationData(String city){
        city = city.replaceAll(" ", "+");
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                city + "&count=1&language=en&format=json";
        System.out.println("URL Geoposition: "+urlString);

        try{
            // 1. Fetch the API response based on API Link
            HttpURLConnection apiConnection = fetchApiResponse(urlString);

            // check for response status
            // 200 - means that the connection was a success
            if(apiConnection.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return null;
            }

            // 2. Read the response and convert store String type
            URI uri = new URI(urlString);
            JSONTokener jsonResponse = new JSONTokener(uri.toURL().openStream());

            // 3. Parse the string into a JSON Object
            JSONObject resultsJsonObj = new JSONObject(jsonResponse);

            // 4. Retrieve Location Data
            JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
            return (JSONObject) locationData.get(0);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static void displayWeatherData(BigDecimal latitude, BigDecimal longitude){
        try{
            // 1. Fetch the API response based on API Link
            String url = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude+"&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m&format=json";
            System.out.println("URL Weather: "+url);

            HttpURLConnection apiConnection = fetchApiResponse(url);

            // check for response status
            // 200 - means that the connection was a success
            if(apiConnection.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return;
            }

            // 2. Read the response and convert store String type
            URI uri = new URI(url);
            JSONTokener jsonResponse = new JSONTokener(uri.toURL().openStream());
            
            // 3. Parse the string into a JSON Object
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");

            // 4. Store the data into their corresponding data type
            String time = (String) currentWeatherJson.get("time");
            System.out.println("Current Time: " + time);

            BigDecimal temperature = (BigDecimal) currentWeatherJson.get("temperature_2m");
            System.out.println("Current Temperature (C): " + temperature);

            // long relativeHumidity = (long) currentWeatherJson.get("relative_humidity_2m");
            // System.out.println("Relative Humidity: " + relativeHumidity);

            BigDecimal windSpeed = (BigDecimal) currentWeatherJson.get("wind_speed_10m");
            System.out.println("Weather Description: " + windSpeed);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            // attempt to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set request method to get
            conn.setRequestMethod("GET");

            return conn;
        }catch(IOException e){
            e.printStackTrace();
        }

        // could not make connection
        return null;
    }
}