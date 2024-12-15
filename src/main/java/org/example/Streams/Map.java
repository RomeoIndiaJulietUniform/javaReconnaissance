package org.example.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

    public static void main(String[] args){

        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<String> ans = new ArrayList<>();


        ans = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toUnmodifiableList());


        for(String it : ans){
            System.out.println(it);
        }
    }
}
