package org.example.Exception;

public class CheckedException {

    static private void checkString() throws Exception{


             String str = null;

             if(str == null){
                 throw new Exception("Hello Babe");
             }



    }

    public static void main(String[] args) throws Exception{
        System.out.println("Hello Brother, How do you do ??");

           checkString();


    }
}
