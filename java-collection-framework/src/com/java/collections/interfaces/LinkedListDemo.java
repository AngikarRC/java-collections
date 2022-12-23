package com.java.collections.interfaces;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("java");
        list.add("C");
        list.add("C++");
        list.add("python");

        int index = list.indexOf("python");
        System.out.println(index);

        boolean result = list.contains("C");
        System.out.println(result);

        int lastIndex = list.lastIndexOf("python");
        System.out.println(lastIndex);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("....foreach...");
        list.forEach((element)->{
            System.out.println(element);
        })
        ;

        for(String e:list){
            System.out.println(e);
        }
        
    }
}
