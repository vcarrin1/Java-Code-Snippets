package com.vcarrin87.inherintance;

// Superclass (Parent class)
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " can eat");
    }
}
