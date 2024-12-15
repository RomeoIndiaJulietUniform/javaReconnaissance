package org.example.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class OddFilter {



    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(
                8, 15, 42, 23, 37, 90,
                12, 48, 56, 78, 102, 67,
                33, 21, 84, 91, 100, 47,
                63, 5, 88, 75, 44, 30,
                19, 66, 10, 99, 120, 53
        );

        numbers.stream()
                .filter(n-> n%2 == 0)
                .forEach(System.out::println);


        long ans = numbers.stream()
                .filter(n -> n%2 != 0)
                .count();


        System.out.println(ans);


        for(Integer it : numbers){
            System.out.println(it +" Papa Quebec Oscar Mike");
        }

    }

}
