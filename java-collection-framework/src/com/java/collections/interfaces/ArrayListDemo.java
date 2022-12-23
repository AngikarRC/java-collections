package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        List<Integer> firstFivePrimeNos = new ArrayList<Integer>();

        for(int i=1;i<20;i++){
            if(i==1||i==2){
                firstFivePrimeNos.add(i);
            }
            try {
                while(firstFivePrimeNos.size()<5){
                    int j=2;
                    if (i>2 && j<=i/2) {
                        if(i%j !=0)
                          firstFivePrimeNos.add(j);
                    }
                    j++;
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(firstFivePrimeNos);
    }
}
