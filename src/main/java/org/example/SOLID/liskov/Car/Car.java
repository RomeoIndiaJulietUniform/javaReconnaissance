package org.example.SOLID.liskov.Car;

public class Car extends Vehicle{

    @Override
    public void start(){
        System.out.println("Car is starting");
    }
}
