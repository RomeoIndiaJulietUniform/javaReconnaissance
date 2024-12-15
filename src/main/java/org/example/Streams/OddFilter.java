package org.example.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class OddFilter {



    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(8, 15, 42, 23, 37, 90);

        long ans = numbers.stream()
                .filter(n -> n%2 != 0)
                .count();


        System.out.println(ans);


        for(Integer it : numbers){
            System.out.println(it +" Papa Quebec Oscar Mike");
        }

    }

}
