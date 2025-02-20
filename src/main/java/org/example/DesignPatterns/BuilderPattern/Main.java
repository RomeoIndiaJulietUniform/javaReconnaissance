package org.example.DesignPatterns.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        Aeroplane airbus = new AeroplaneBuilder()
                .setModel("Airbus A380")
                .setSeatingCapacity(615)
                .setAirlineName("Emirates")
                .build();

        System.out.println(airbus);
    }
}