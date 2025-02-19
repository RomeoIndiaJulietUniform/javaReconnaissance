package org.example.DesignPatterns.FactoryPattern;

public class Main {

    public static void main(String[] args){

        Force gravityForce = ForceFactory.getForce("Gravity");
        gravityForce.applyForce();

    }
}
