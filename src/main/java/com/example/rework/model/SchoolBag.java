package com.example.rework.model;

public class SchoolBag extends Bag{
    public static final int CAPACITY = 20;

    public SchoolBag(String name) {
        super(name);
    }

    public int getCapacity() {
        return CAPACITY;
    }
}
