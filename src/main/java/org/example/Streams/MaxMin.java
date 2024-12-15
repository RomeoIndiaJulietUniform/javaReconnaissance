package org.example.Streams;

import java.util.Arrays;
import java.util.List;

public class MaxMin {

    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(23, 15, 42, 8, 37, 90);

        int mx = numbers.stream().max(Integer::compare).get();
        int mn = numbers.stream().min(Integer::compare).get();


        System.out.println("The max " + mx + " The mn " + mn);

    }
}
