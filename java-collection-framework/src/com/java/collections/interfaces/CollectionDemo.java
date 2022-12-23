package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args){

        Collection<String> fruits = new ArrayList<>();

        for(int i =0; i<10; i++){
            fruits.add("fruit"+i);
        }
        System.out.println(fruits);

        if(fruits.contains("fruit5")){
            System.out.println("Fruit 5 found");
            fruits.remove("fruit5");
        }

        if(!fruits.isEmpty()){
            fruits.forEach((element)-> {
                System.out.println(element);
            });
        };
        Collection<String> fruitList = new ArrayList<>();
        fruitList.add("fruit2");
        fruitList.add("fruit3");
        if(fruits.containsAll(fruitList)){
            System.out.println("These fruits are present");}

        System.out.println("-----Showing iterator-----");
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
