package com.java.collections.streamsAPIJava8;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.DoubleStream.generate;

public class OrderImpl {

    static List<Order> orders = new ArrayList<>();

    static{
        orders.add(
                new Order(100,"Apple-Mac", 200.52f,List.of("length:10","breadth:14","width:3"))
        );
        orders.add(
                new Order(104,"Amazon-firestick", 121.22f,List.of("length:5","breadth:2","width:1"))
        );
        orders.add(
                new Order(208,"Hitachi-D4", 3732.87f,List.of("length:22","breadth:12","width:11"))
        );
        orders.add(
                new Order(410,"Ergonomics", 98.42f,List.of("length:24","breadth:17","width:16"))
        );
    }

    public static void main(String[] args) {
        System.out.println(orders);
        System.out.println("------------------------------------");

        //stream provides a layer of abstraction, all operations done on streams
        //foreach; it is a terminal operation, no operation can be done after foreach
        orders.stream().forEach(order -> {
            System.out.println(order);
        });

        //map : to map objects to another object; it takes one object and returns another; sinece
        //mapping is done on streams, we have to collect the collection object from streams
        //we use collect method to return the collection object from the stream
        //here we want to hike prices of orders by 20% and return the new Order object

        System.out.println("----------map-------------------");

        List<Order> hikedOrders = orders.stream()
                .map(order -> new Order(
                        order.getId(),
                        order.getName(),
                        order.getPrice() * 1.2f,
                        order.getDimensions()
                ))
                .collect(Collectors.toList());  //we can also use .toSet() to return a Set

        System.out.println(hikedOrders);

        //filter() --> an intermediate operation, similar to if:else;takes a predicate in arguments
        //map()-->executes based on the filter(), returns new values or objects
        //have to return as a collection from stream using collect
        //here we return orders based on price and width

        System.out.println("---------------------------------------");

        List<Order> filteredOrders = orders.stream().
                filter(order -> order.getPrice()>200f & order.getDimensions().get(1).equals("breadth:12")).
                map(order -> new Order(
                        order.getId(),
                        order.getName(),
                        order.getPrice()*1.3f,
                        order.getDimensions()
                ))
                .collect(Collectors.toList());

        System.out.println(filteredOrders);
        //orders.forEach(order-> System.out.println(order.getDimensions().get(1).equals("breadth:12")));

        //if we want only the first order we can use the findFirst()--> which returns an optional object
        System.out.println("****************************");
        Order firstOrder = orders.stream()
                .filter(order -> order.getPrice()>150f)
                .map(order -> new Order(
                        order.getId(),
                        order.getName(),
                        order.getPrice() + 1000.50f,
                        order.getDimensions()
                ))
                .findFirst().orElse(null);

        System.out.println(firstOrder);

        //flatMap is used to flat out any collections in the stream
        System.out.println("_________flatMap__________");

        String orderDims = orders.stream()
                .map(order -> order.getDimensions())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println(orderDims);

        //short-circuit operations
        System.out.println("________Short circuits_____________");
        Collection<Order> shortCircuits =  orders.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(shortCircuits);

        //finite data from infinite data using limit()
        System.out.println("----------Finite Data-----------");

        Stream.generate(Math::random)
                .limit(4)
                .forEach(element-> System.out.println(element*100));

        //sorting using streams
        System.out.println("---------sort------------");

        Collection<Order> sortedOrdersByName =   orders.stream()
                .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                .collect(Collectors.toList());

        System.out.println(sortedOrdersByName);

        Collection<Order> sortedOrdersByPrice =   orders.stream()
                .sorted(new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        if(o1.getPrice()>o2.getPrice())
                            return 1;
                        else
                            return -1;
                    }
                })
                .collect(Collectors.toList());
        System.out.println(sortedOrdersByPrice);

        //min or max
        System.out.println("-----------min/max-------------");

        orders.stream()
                .max(Comparator.comparing(Order::getId))
                .orElseThrow(NoSuchElementException::new);
        //sum
        Float sum = orders.stream()
                .map(order -> order.getPrice())
                .reduce(0.0f,Float::sum);
        System.out.println(sum);







    }

}
