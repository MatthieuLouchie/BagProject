package com.example.rework;

import com.example.rework.client.BagLoader;
import com.example.rework.model.Bag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;


class BagLoaderTest {
    @Test
    void shouldAddBagsFromTextFile() throws IOException {

        // given
        BagLoader bagLoader = new BagLoader();

        // when
        bagLoader.loadfromfile("src/main/resources/bags.txt");

        // then
        Assertions.assertThat(bagLoader.get())
                .extracting(Bag::getName)
                .contains("MyBag1", "MyBag2", "MyBag3", "MyBag4");     //verify if the entire list contains my bags
    }

    @Test
    void shouldAddBagsFromJsonFile() throws IOException {

        // given
        BagLoader bagLoader = new BagLoader();

        // when
        bagLoader.loadFromJSonFile("src/main/resources/bag.json");

        // then
        Assertions.assertThat(bagLoader.get())
                .extracting(Bag::getName)
                .contains("MyBag1");     //verify if the entire list contains my bags
    }

    @Test
    void shouldAddSomeBagsFromJsonFile() throws IOException {

        // given
        BagLoader bagLoader = new BagLoader();

        // when
        bagLoader.loadSomeBagsFromJSonFile("src/main/resources/bags.json");     //json file with multiple bags

        // then
        Assertions.assertThat(bagLoader.get())
                .extracting(Bag::getName)
                .contains("MyBag1", "MyBag2", "MyBag3", "MyBag4");              //verify if the entire list contains my bags
    }
}