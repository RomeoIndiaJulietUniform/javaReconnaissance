package org.example.SOLID.OpenClose;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Car{

        private List<String> carStorage= new ArrayList<>(List.of("Tata", "LandRover"));

        public void add(String car){
            carStorage.add(car);
        }


        @Override
        public String toString() {
            StringBuilder temp = new StringBuilder();

            int n = carStorage.size();

            for(int i = 0; i < n ; i++){
                temp.append(carStorage.get(i));
                temp.append(" ");
            }

            return temp.toString();
        }
    }


    public static void main(String[] args){

        Car car = new Car();

        car.add("Maruti");

        System.out.println(car.toString());

    }

}
