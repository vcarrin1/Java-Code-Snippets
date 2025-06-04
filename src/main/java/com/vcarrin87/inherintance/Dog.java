package com.vcarrin87.inherintance;

// Dog inherits from Animal
class Dog extends Animal {

    public Dog(String name) {
        super(name); // Call the constructor of the superclass (Animal)
    }
    // New method in subclass
    public void display() {
        System.out.println("Dog name is " + name);
    }
}