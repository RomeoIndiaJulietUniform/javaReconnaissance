package org.example.Basics;

public class SinglentonEX {

    private SinglentonEX(){

    };

    private static SinglentonEX singlentonEX;


    public static SinglentonEX createSinglenton(){
        if(singlentonEX == null){
            singlentonEX = new SinglentonEX();
        }


        return singlentonEX;
    }
}

/*

Calling method


  SinglentonEx singletonEx = SinglentonEx.createSingleton();

 */
