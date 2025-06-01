package com.vcarrin87.concurrency;


public class WeatherData {
    private String city;
    private Current current;
    
    public static class Current {
        private double temp_f;
        private int humidity;

        public double getTempF() {
            return temp_f;
        }
        public void setTempF(double temp_f) {
            this.temp_f = temp_f;
        }
        public int getHumidity() {
            return humidity;
        }
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return "Current { fahrenheit temp=" + temp_f + ", humidity=" + humidity + " }";
        }
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Current getCurrent() {
        return current;
    }
    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "WeatherData { city='" + city + "', current=" + current + " }";
    }
}

