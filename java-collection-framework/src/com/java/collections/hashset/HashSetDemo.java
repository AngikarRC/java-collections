package com.java.collections.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> first5even = new HashSet<>();
        first5even.add(2);
        first5even.add(4);
        first5even.add(6);
        first5even.add(8);
        first5even.add(10);

        Set<Integer> first10even = new HashSet<>(first5even);

        System.out.println(first10even);

        Set<Integer> next10even = new HashSet<>();
        next10even.add(12);
        next10even.add(14);
        next10even.add(16);
        next10even.add(18);
        next10even.add(20);

        System.out.println(next10even);

        first10even.addAll(next10even);
        System.out.println(first10even);

        Set<String> courses = new HashSet<>();
        courses.add("Java");
        courses.add("Python");
        courses.add("Scala");
        courses.add("R");

        courses.stream().forEach(course-> System.out.println(course));
        System.out.println("------------");

        courses.stream().filter(course->!course.equals("R"))
                .forEach(course-> System.out.println(course));

    }
}
