package org.example.DesignPatterns.FactoryPattern;

public class ForceFactory {

    public void ForceFactory(){

    }


    public static Force getForce(String forceType){
        if(forceType == "Gravity"){
            return new GravitationalForce();
        }
        else if(forceType == "Magnetic"){
            return new MagneticForce();
        }
        else{
            return null;
        }
    }

}
