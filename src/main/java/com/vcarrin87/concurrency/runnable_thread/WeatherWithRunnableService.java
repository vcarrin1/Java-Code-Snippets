package com.vcarrin87.concurrency.runnable_thread;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.BlockingQueue;

import com.google.gson.Gson;
import com.vcarrin87.concurrency.WeatherData;

public class WeatherWithRunnableService {
    // run this in terminal to set the API_KEY environment variable: export API_KEY=your_api_key_here
    private static final String API_KEY = System.getenv("API_KEY");
    private static final HttpClient client = HttpClient.newHttpClient();

    public static class WeatherTask implements Runnable {
        private final String city;
        private final BlockingQueue<WeatherData> resultsQueue;

        public WeatherTask(String city, BlockingQueue<WeatherData> queue) {
            this.city = city;
            this.resultsQueue = queue;
        }

        @Override
        public void run() {
            try {
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
                    resultsQueue.put(data);
                }
            } catch (Exception e) {
                System.err.println("Failed for " + city + ": " + e.getMessage());
            }
        }
    }
}
