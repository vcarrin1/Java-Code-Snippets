package com.vcarrin87.concurrency.callable_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.vcarrin87.concurrency.WeatherData;
import com.vcarrin87.concurrency.callable_thread.WeatherWithCallableService.WeatherTask;

/*
Callable threads in Java are created by implementing the Callable interface.
This allows you to define the code that should run in a separate thread and return a result.

A Future in Java represents the result of an asynchronous computation, similar to await in nodejs.
When you submit a Callable task to an ExecutorService, it returns a Future object.
You can use Future to:
- Check if the task is complete (future.isDone())
- Wait for the task to finish and get its result (future.get())
- Cancel the task (future.cancel())
In this code, each Future<WeatherData> represents the pending result of fetching weather data for each city.
*/
public class Main {

    public static void main(String[] args) {
        // using a thread for each city to fetch weather data concurrently
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<String> cities = List.of("London", "Paris", "Denver", "Tokyo", "Chisinau");
        List<Future<WeatherData>> futures = new ArrayList<>();

        // Submit all tasks
        for (String city : cities) {
            futures.add(executor.submit(new WeatherTask(city)));
        }

        List<WeatherData> weatherDataList = new ArrayList<>();

        // Process results
        for (Future<WeatherData> future : futures) {
            try {
                weatherDataList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Task failed: " + e.getCause().getMessage());
            }
        }

        // Process the collected weather data
        processData(weatherDataList);

        executor.shutdown();
    }

    private static void processData(List<WeatherData> weatherData) {
        for (WeatherData data : weatherData) {
            System.out.println("City: " + data.getCity() + ", Temp: " + data.getCurrent().getTempF() 
                + "°F, Humidity: " + data.getCurrent().getHumidity() + "%");
            checkAlerts(data);
        }
        System.out.println("Retrieved " + weatherData.size() + " weather reports.");
    }

    private static void checkAlerts(WeatherData data) {
        if (data.getCurrent().getTempF() > 80) {
            sendAlert("Heatwave", data.getCity(), data.getCurrent().getTempF());
        }
    }

    private static void sendAlert(String type, String city, double value) {
        String message = String.format("[ALERT] %s in %s: %.1f", type, city, value);
        System.out.println(message);
    }
}

/*
* Output:
    City: London, Temp: 64.6°F, Humidity: 52%
    City: Paris, Temp: 66.6°F, Humidity: 68%
    City: Denver, Temp: 85.6°F, Humidity: 23%
    [ALERT] Heatwave in Denver: 85.6
    City: Tokyo, Temp: 62.6°F, Humidity: 88%
    City: Chisinau, Temp: 69.8°F, Humidity: 60%
 */
