package org.example.SOLID.liskov.Payment;

public class Main {

    public static void setPay(Payment payment){

        payment.pay();

    }


    public static void main(String[] args){

        Payment credit = new CreditCard();

        Payment google = new GooglePay();

        setPay(credit);

        setPay(google);


    }
}
