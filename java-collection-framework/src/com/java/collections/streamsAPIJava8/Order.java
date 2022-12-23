package com.java.collections.streamsAPIJava8;

import java.util.List;

public class Order {
    private Integer id;
    private String name;
    private float price;
    private List<String> dimensions;

    public Order() {
    }

    public Order(Integer id, String name, float price, List<String> dimensions) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dimensions = dimensions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<String> dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dimensions=" + dimensions +
                '}';
    }
}
