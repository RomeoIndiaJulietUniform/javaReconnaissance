package org.example.DesignPatterns.BuilderPattern;

public class AeroplaneBuilder {
    private String model;
    private Integer seatingCapacity;
    private String airlineName;

    public AeroplaneBuilder() {
    }

    public AeroplaneBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public AeroplaneBuilder setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
        return this;
    }

    public AeroplaneBuilder setAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public Aeroplane build() {
        return new Aeroplane(this);
    }

    public String getModel() {
        return model;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public String getAirlineName() {
        return airlineName;
    }
}