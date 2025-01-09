package Assignment6;

import java.io.*;
import java.net.http.*;
import java.net.URI;
import java.util.Scanner;

public class WeatherAPI {
    private static final String API_KEY = "afe962c972d859254fb1d416931ea84f";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static String getWeather(String location) throws IOException, InterruptedException {
        String urlString = BASE_URL + "?q=" + location + "&appid=" + API_KEY;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to fetch weather data: " + response.statusCode());
        }

        return response.body();
    }
}
