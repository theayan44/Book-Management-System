package com.example.bookmanagementsystem;

public class Author {
    private String name;
    private int age;
    private char gender;
    private float rating;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public float getRating() {
        return rating;
    }

    public Author(String name, int age, char gender, float rating) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Author: {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", rating=" + rating +
                '}';
    }
}
