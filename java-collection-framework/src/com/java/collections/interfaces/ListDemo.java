package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add(null);
        list.add(null);
        list.add("element1");
        list.add("element3");
        list.add("element2");

        System.out.println(list);

        System.out.println(list.get(3));


    }

}
