package com.java.collections.interfaces;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterateOverList {
    public static void main(String[] args) {

        List<String> courses = Arrays.asList("Java","Python","ML","Deep learning","DSA","CyberSecurity");
        System.out.println(courses);

        Iterator<String> iterator = courses.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------");
        for(int i=0; i<courses.size();i++){
            System.out.println(courses.get(i));
        }
        System.out.println("####################");
        for (String course:courses) {
            System.out.println(course);
        }

        //using java 8 stream + lambda
        System.out.println("***********************");
        courses.stream().forEach(course-> System.out.println(course));
        //using foreach + lambda
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        courses.forEach(course-> System.out.println(course));
    }
}
