package org.example.SOLID.liskov.Payment;

public class GooglePay extends Payment{

    public void pay(){
        System.out.println("Paying through Google Pay");
    }
}
