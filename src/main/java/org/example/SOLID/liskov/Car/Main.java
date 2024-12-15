package org.example.SOLID.liskov.Car;

public class Main {

    public static void startVehicle(Vehicle vehicle){

        vehicle.start();

    }

    public static void main(String[] args){

        Vehicle car = new Car() ;

        Vehicle bike = new Bike();


        startVehicle(car);
        startVehicle(bike);

    }
}
