package com.vcarrin87.concurrency.runnable_thread;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.vcarrin87.concurrency.WeatherData;
import com.vcarrin87.concurrency.runnable_thread.WeatherWithRunnableService.WeatherTask;

// Runnable threads in Java are created by implementing the Runnable interface.
// This allows you to define the code that should run in a separate thread.
// The Runnable interface has a single method, run(), which contains the code to be executed by the thread.
public class Main {

    public static void main(String[] args) {
        try {
            // using a thread for each city to fetch weather data concurrently
            ExecutorService executor = Executors.newFixedThreadPool(5);
            // this is a thread-safe queue that can be used to store results from multiple threads
            // it allows multiple threads to add and remove elements concurrently
            BlockingQueue<WeatherData> results = new LinkedBlockingQueue<>();
            List<String> cities = List.of("London", "Paris", "Denver", "Tokyo", "Chisinau");

            // Submit all tasks
            for (String city : cities) {
                executor.execute(new WeatherTask(city, results));
            }

            // Wait for completion and process results
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);

            System.out.println("Retrieved " + results.size() + " weather reports:");
            results.forEach(System.out::println);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }
}

/*
Retrieved 5 weather reports:
WeatherData { city='London', current=Current { fahrenheit temp=64.9, humidity=52 } }
WeatherData { city='Tokyo', current=Current { fahrenheit temp=63.1, humidity=88 } }
WeatherData { city='Denver', current=Current { fahrenheit temp=85.6, humidity=23 } }
WeatherData { city='Paris', current=Current { fahrenheit temp=66.2, humidity=68 } }
WeatherData { city='Chisinau', current=Current { fahrenheit temp=70.5, humidity=60 } }
 */
