package com.example.rework.client;

import com.example.rework.model.Bag;
import com.example.rework.service.BagService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class BagLoader {
    private final BagService bagService = new BagService();             //Nouvel objet
    private final ObjectMapper objectMapper = new ObjectMapper();
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

    public void loadFromJSonFile(String json) throws IOException {
        BufferedReader bagParameters = new BufferedReader(new FileReader(json));

        JsonNode jsonNode = objectMapper.readTree(bagParameters);
        String name = jsonNode.get("name").asText();
        String type = jsonNode.get("type").asText();

        bagService.create(name, type);                      //passer les deux variables dans la fonction create du BagService.java
    }

    public void loadSomeBagsFromJSonFile(String json) throws IOException {
        BufferedReader bagParameters = new BufferedReader(new FileReader(json));        //lecture du fichier json
        JsonNode jsonNode = objectMapper.readTree(bagParameters);                       //

        String jsonValue = jsonNode.toString();                                         //conversion JsonNode -> String
        String[] parts = jsonValue.split("}");                                   //découpe des 


        for(int i = 0; i<=(parts.length)-2; i++){
            parts[i] = parts[i].substring(1) + '}';
            JsonNode jsn = objectMapper.readTree(parts[i]);

            String name = jsn.get("name").asText();
            String type = jsn.get("type").asText();

            bagService.create(name, type);                      //passer les deux variables dans la fonction create du BagService.java
        }
    }
}