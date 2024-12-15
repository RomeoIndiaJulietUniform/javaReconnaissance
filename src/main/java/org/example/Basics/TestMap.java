package org.example.Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestMap {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++){
            int it = sc.nextInt();
            map.put(it, map.getOrDefault(it,0)+ 1);
        }


//        for(Map.Entry<Integer,Integer> it : map.entrySet()){
//
//            System.out.println("Papa Quebec " + it.getKey());
//            System.out.println("Romeo Novemeber " + it.getValue());
//        }

        for(Integer it : map.keySet()){

            System.out.println("Papa Quebec Key" + it);
            System.out.println("Romeo Novemeber " + map.get(it));
        }
    }
}
