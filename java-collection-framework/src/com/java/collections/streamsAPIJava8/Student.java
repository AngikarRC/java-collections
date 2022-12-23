package com.java.collections.streamsAPIJava8;

import java.util.List;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;
    private Map<String, Integer> marks;
    private List<String> grades;
    private List<Double> fees;

    public Student() {
    }

    public Student(String firstName, String lastName, Map<String, Integer> marks, List<String> grades, List<Double> fees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
        this.grades = grades;
        this.fees = fees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public List<Double> getFees() {
        return fees;
    }

    public void setFees(List<Double> fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", marks=" + marks +
                ", grades=" + grades +
                ", fees=" + fees +
                '}';
    }
}