package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFromAnother {
    public static void main(String[] args) {

        List<Integer> firstFivePrimeNos = new ArrayList<>();
        firstFivePrimeNos.add(1);
        firstFivePrimeNos.add(3);
        firstFivePrimeNos.add(5);
        firstFivePrimeNos.add(7);
        firstFivePrimeNos.add(11);

        List<Integer> firstTenPrimeNos = new ArrayList<>(firstFivePrimeNos);

        List<Integer> next5primeNos = new ArrayList<>();
        next5primeNos.add(13);
        next5primeNos.add(17);
        next5primeNos.add(19);
        next5primeNos.add(21);
        next5primeNos.add(23);

        firstTenPrimeNos.addAll(next5primeNos);

        System.out.println(firstTenPrimeNos);
        System.out.println(firstTenPrimeNos.get(5));
        firstTenPrimeNos.set(5,101);
        System.out.println(firstTenPrimeNos.get(5));
    }
}
