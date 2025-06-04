package com.vcarrin87.inherintance;

// Inheritance allows a class (subclass) to inherit properties and behaviors (methods) from another class (superclass).
// In this example, we have a superclass Animal and two subclasses Dog and Cat.
// The subclasses inherit the properties and methods of the superclass, allowing for code reuse and a hierarchical relationship between classes.
public class Main {
    public static void main(String[] args) {
        // Create Dog object of the subclass
        Dog labrador = new Dog("Reggi");

        // Call method of subclass
        labrador.display();

        // Call method of superclass using object of subclass
        labrador.eat();

        System.out.println("---------------------");

        // Create Cat object of the subclass
        Cat cat = new Cat("Mittens");

        cat.display();
        // Overridden method from superclass
        cat.eat();
    }
}

/*
 Output:
 Dog name is Reggi
 Reggi can eat
 ---------------------
 Cat name is Mittens
 Mittens can eat fish    
 */
