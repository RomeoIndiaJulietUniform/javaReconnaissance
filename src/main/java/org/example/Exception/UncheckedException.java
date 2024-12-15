package org.example.Exception;

public class UncheckedException{

    public static void checkOdd(){

        int num = 10;

        if(10%2 == 0){

            throw new RuntimeException("Work 10 times a day");

        }
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        checkOdd();
    }
}
