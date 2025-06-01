package com.vcarrin87.concurrency.callable_thread;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

import com.google.gson.Gson;
import com.vcarrin87.concurrency.WeatherData;

public class WeatherWithCallableService {
    // run this in terminal to set the API_KEY environment variable: export API_KEY=your_api_key_here
    private static final String API_KEY = System.getenv("API_KEY");
    private static final HttpClient client = HttpClient.newHttpClient();

    public static class WeatherTask implements Callable<WeatherData> {
        private final String city;

        public WeatherTask(String city) {
            this.city = city;
        }

        @Override
        public WeatherData call() throws Exception {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(
                    "https://api.weatherapi.com/v1/current.json?key=" 
                    + API_KEY + "&q=" + city))
                .GET()
                .build();

            HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString()
            );

            if (response.statusCode() == 200) {
                WeatherData data = new Gson().fromJson(
                    response.body(), WeatherData.class
                );
                data.setCity(city);
                return data;
            } else {
                throw new RuntimeException("API call failed for " + city);
            }
        }
    }
}
