package com.java.collections.HashMapExample;

import com.java.collections.interfaces.sorting.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapIterate {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("Rahul",50);
        map.put("Suresh",40);
        map.put("Ram",98);
        map.put("Shyam",87);
        map.put("Gargee",96);
        map.put("Sritama",68);

        //using advanced for loop
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key is-->"+entry.getKey()+", Value is-->"+entry.getValue());
        }

        //using iterator-->to use entrySet we need object of Set
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            System.out.println("Key is :"+entry.getKey()+", Value is :"+entry.getValue());
        }
        //use forEach

        map.forEach((k,v)->{
            System.out.println("Key :-"+k);
            System.out.println("Value :-"+v);
        });

        Map<Integer, Employee> empMap = new HashMap<>();
        empMap.put(1,new Employee(204,"Shyam",24,900000));
        empMap.put(2,new Employee(302,"Shyam",22,700000));

        System.out.println(empMap);
        empMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

    }
}
