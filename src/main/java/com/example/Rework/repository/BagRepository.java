package com.example.Rework.repository;

import com.example.Rework.model.Bag;

import java.util.ArrayList;
import java.util.List;



public class BagRepository {
    private final List<Bag> bags = new ArrayList<>();

    public Bag get(String name){
        return bags
                .stream()
                .filter(x -> x.getName().equals(name))
                .findFirst()
                .orElseThrow()
                ;
    }

    public List<Bag> get(){
        return bags;
    }

    public void delete(String name){
        bags.removeIf(x -> x.getName().equals(name));
    }

    public void create(Bag defaultBag){
        for (Bag actualBag : bags) {
            if (defaultBag.getName().equals(actualBag.getName())) {
                throw new RuntimeException("Error : This bag already exists");
            }
        }
        bags.add(defaultBag);
    }
}
