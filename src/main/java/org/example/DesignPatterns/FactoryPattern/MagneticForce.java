package org.example.DesignPatterns.FactoryPattern;

public class MagneticForce implements Force {

    @Override
    public void applyForce(){
        System.out.println("Applying Magnetic Force :-> F = q * v * B * sin(θ)");
    }
}
