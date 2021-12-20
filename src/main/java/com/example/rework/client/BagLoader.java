package com.example.rework.client;

import com.example.rework.model.Bag;
import com.example.rework.service.BagService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BagLoader {
    private final BagService bagService = new BagService();             //Nouvel objet
    public void loadfromfile(String file) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(file));   //lire le fichier .txt

        String line = in.readLine();                                    //stock dans la variable line la première ligne du document
        while (line != null){                                           //tant que cette variable est non nulle
            String[] parts = line.split(" ");                     //sépare le nom et le type du sac en fonction de l'espace et les place dans un tableau
            bagService.create(parts[0], parts[1]);                      //passer les deux variables dans la fonction create du BagService.java

            line = in.readLine();                                       //prendre la ligne suivante
        }
    }
    public List<Bag> get(){
        return bagService.get();
    }
}