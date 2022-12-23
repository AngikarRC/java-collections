package com.java.collections.HashMapExample;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("Rahul",50);
        map.put("Suresh",40);
        map.put("Ram",98);
        map.put("Shyam",87);
        map.put("Gargee",96);
        map.put("Sritama",68);

        System.out.println(map);

        map.put(null,34);
        System.out.println(map);

        System.out.println(map.isEmpty());
        System.out.println(map.size());

        if(map.containsKey("Ram")){
            if(map.containsValue(100))
                System.out.println("Ram scored 100");
            else
                System.out.println("Ram scored :"+map.get("Ram"));
        }else{
            System.out.println("Ram is not present");
        }

        map.remove(null);
        System.out.println(map);

        Set<String> set = map.keySet(); //set since keys are unique
        System.out.println(set);
        set.stream().forEach(ele-> System.out.println(ele));

        Collection<Integer> val = map.values(); //collection since valuea can be duplicates
        System.out.println(val);
    }
}
