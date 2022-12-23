package com.java.collections.interfaces.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortExample {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"Ram",23,600000));
        employees.add(new Employee(4,"Shyam",24,900000));
        employees.add(new Employee(3,"Madhu",26,700000));
        employees.add(new Employee(2,"Subodh",24,800000));

        System.out.println(employees);

        System.out.println("After sorting by salary");

        Collections.sort(employees,new MySort()); //will sort in ascending order
        System.out.println(employees);
        Collections.sort(employees,new MySortByAge());
        System.out.println("By Age Desc"+ employees);

        //we can use anonymous implementation of comparator interface
        System.out.println("without using object of class");
        Collections.sort(employees,new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary()-o2.getSalary();
            }
        });
        System.out.println(employees);

        //we can use lambda expression also
        //(o1,o2)->(o2.getId-o1.getId)
        System.out.println("Sort ids in descending order");
        Collections.sort(employees,(o1,o2)->(o2.getId()-o1.getId()));
        System.out.println(employees);

        //sort name in ascending order, we have to use the compareTo() method
        Collections.sort(employees,(o1,o2)->(o1.getName().compareTo(o2.getName())));
        System.out.println(employees);

    }
}

class MySort implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary()-o2.getSalary(); //desc--> o2.getSalary()-o1.getSalary()

    }
}

class MySortByAge implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getAge() - o1.getAge();
    }
}


