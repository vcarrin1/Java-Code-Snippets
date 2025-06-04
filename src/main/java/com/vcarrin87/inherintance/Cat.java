package com.vcarrin87.inherintance;

// Cat inherits from Animal
public class Cat extends Animal {

    public Cat(String name) {
        super(name); // Call the constructor of the superclass (Animal)
    }

    // New method in subclass
    public void display() {
        System.out.println("Cat name is " + name);
    }

    // Overriding a method from the superclass
    @Override
    public void eat() {
        System.out.println(name + " can eat fish");
    }

}
