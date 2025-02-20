package org.example.DesignPatterns.BuilderPattern;

public class Aeroplane {
    private final String model;
    private final Integer seatingCapacity;
    private final String airlineName;

    public Aeroplane(AeroplaneBuilder builder) {
        this.model = builder.getModel();
        this.seatingCapacity = builder.getSeatingCapacity();
        this.airlineName = builder.getAirlineName();
    }

    @Override
    public String toString() {
        return "Aeroplane{" +
                "model='" + model + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", airlineName='" + airlineName + '\'' +
                '}';
    }
}
