package com.example.rework;

import com.example.rework.client.BagLoader;
import java.io.IOException;



//------------------------------role?------------------------------//
public class Main {
    public static void main(String[] args) throws IOException {
        BagLoader loader = new BagLoader();
        loader.loadfromfile("bag.json");
    }
}