package org.example.SOLID.liskov.Payment;

public class CreditCard extends Payment{

    public void pay(){
        System.out.println("Paying through Credit Card");
    }
}
