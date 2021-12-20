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
}