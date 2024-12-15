package org.example.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {

    public static void main(String[] args){

      List<String> map = Arrays.asList("apple", "banana", "kiwi", "pear", "grape");

      Map<Integer,List<String>> groupedMap = map.stream()
              .collect(Collectors.groupingBy(String::length));

      groupedMap.forEach((length, group) -> System.out.println("Num is " + length + " Group is " + group));


    }
}
