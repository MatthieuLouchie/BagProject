package com.example.rework.model;

public abstract class Bag {

    private final String name;

    protected Bag(String name) {
        this.name = name;
    }

    public abstract int getCapacity();

    public String getName(){
        return name;
    }
}