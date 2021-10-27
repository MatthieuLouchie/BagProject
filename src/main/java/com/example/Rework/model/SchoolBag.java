package com.example.Rework.model;

public class SchoolBag extends Bag{
    public static final int CAPACITY = 20;

    public SchoolBag(String name) {
        super(name);
    }

    public int getCapacity() {
        return CAPACITY;
    }
}
