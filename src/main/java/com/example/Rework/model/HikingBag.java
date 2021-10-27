package com.example.Rework.model;


public class HikingBag extends Bag{
    private int capacity = 50;
    private int slots = 2;

    public HikingBag(String name) {
        super(name);
    }


    public int getCapacity() {
        return capacity;
    }

    public void addSlot(int x){
        capacity += (10*x);
        slots += x;
    }

    public int getSlots(){
        return slots;
    }
}