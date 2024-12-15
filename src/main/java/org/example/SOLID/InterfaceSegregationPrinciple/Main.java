package org.example.SOLID.InterfaceSegregationPrinciple;

public class Main {
    public interface Animal{
         public void Bark();
    }

    public interface Domestic extends Animal{
        public void playwithHumans();

        public void Bark();
    }

    public static class Dog implements Domestic{

        @Override
        public void playwithHumans(){
            System.out.println("Playing with Humans Bro !!!");
        }


        @Override
        public void Bark(){
            System.out.println("Shouts in Dog Language   !!");
        }

    }


    public static class Tiger implements Animal{

        @Override
        public void Bark(){
            System.out.println("Shouts in Tiger Language !!");
        }
    }


    public static void main(String[] args){

          Dog dog = new Dog();

          Tiger tiger = new Tiger();

          dog.Bark();
          dog.playwithHumans();

          tiger.Bark();

    }
}
