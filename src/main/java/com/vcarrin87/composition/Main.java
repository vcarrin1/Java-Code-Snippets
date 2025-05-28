package com.vcarrin87.composition;

public class Main {

    // Composition is a way to make the combination of classes act like a single coherent object.
    // It is a "has-a" relationship, where one class contains instances of other classes.
    // In this example, PersonalComputer has a ComputerCase, Monitor, and Motherboard.
    public static void main(String[] args) {

        ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherboard);

        thePC.powerUp();
    }
}
