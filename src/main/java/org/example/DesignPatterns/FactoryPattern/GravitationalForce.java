package org.example.DesignPatterns.FactoryPattern;

public class GravitationalForce implements Force{

    @Override
    public void applyForce(){
        System.out.print(" Applying Gravitational Force :-> F = G*(m1*m2)/r^2");
    };
}
