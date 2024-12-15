package org.example.Optionals;

import java.util.Optional;

public class BasicOptionals {

    private static int getLength( String str){

        return Optional.ofNullable(str)
                .map(String::length)
                .orElse(-1);

    }

    public static void main(String[] args){

        Optional<String> str = Optional.ofNullable("Papa Quebec");
        System.out.println(str.get());


        Optional<String> maybenull = Optional.ofNullable(null);
        String ans = maybenull.orElse("Serra Novemeber touching down");
        System.out.println(ans);

        if(!maybenull.isPresent()){
            System.out.println("Oscar Mike");
        }
        else{
            System.out.println("Up and Up");
        }




    }
}
