package com.example.Rework.service;

import com.example.Rework.model.Bag;
import com.example.Rework.model.HikingBag;
import com.example.Rework.model.SchoolBag;
import com.example.Rework.repository.BagRepository;
import java.util.List;


public class BagService {
    private final BagRepository repository = new BagRepository();

    public void create(String name, String type){
        switch (type){
            case "SchoolBag":
                repository.create(new SchoolBag(name));
                return;
            case "HikingBag":
                repository.create(new HikingBag(name));
                return;
            default:
                throw new RuntimeException("Error : This type of bag is not available");
        }
    }

    public Bag get(String name){
        return repository.get(name);
    }

    public List<Bag> get(){
        return repository.get();
    }

    public void delete(String name){
        repository.delete(name);
    }
}