package com.example.rework.service;

import com.example.rework.model.Bag;
import com.example.rework.model.HikingBag;
import com.example.rework.model.SchoolBag;
import com.example.rework.repository.BagRepository;
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
                throw new Myexception("Error : This type of bag is not available");
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