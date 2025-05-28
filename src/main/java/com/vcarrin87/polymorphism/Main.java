package com.vcarrin87.polymorphism;

/**
 * Polymorphism is a core concept in object-oriented programming that allows methods to do different things 
 * based on the object that it is acting upon, taking multiple forms.
 * We have a base class Car and several subclasses: GasPoweredCar, ElectricCar, and HybridCar.
 * The method runRace(Car car) accepts any object that is a subclass of Car.
 * At runtime, when car.startEngine() and car.drive() are called, the actual method that gets executed depends on the 
 * object's real type (e.g., GasPoweredCar, ElectricCar, etc.), not just the reference type (Car).
 * This allows for:
 * Code Flexibility: You can write code that works with the superclass (Car), but it will automatically use the correct subclass behavior.
 * Extensibility: You can add new types of cars without changing the runRace method.
 */
public class Main {

    public static void main(String[] args) {

        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS", 15.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("2022 Red Tesla Model 3", 568, 75);
        runRace(tesla);

        Car ferrariHybrid = new HybridCar("2022 Black Ferrari SF90 Stradale", 16, 8, 8);
        runRace(ferrariHybrid);
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
