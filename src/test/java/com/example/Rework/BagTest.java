package com.example.Rework;

import com.example.Rework.model.Bag;
import com.example.Rework.service.BagService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;


class BagTest {

    @Test
    void shouldAddBags(){
        // given
        BagService bagService = new BagService();

        // when
        bagService.create("SchoolBag1", "SchoolBag");
        Bag newSchoolBag = bagService.get("SchoolBag1");

        // then
        Assertions.assertThat(newSchoolBag.getName()).isEqualTo("SchoolBag1");
    }

    @Test
    void shouldDeleteBag(){
        // given
        BagService bagService = new BagService();
        bagService.create("SchoolBag1", "SchoolBag");

        // when
        bagService.delete("SchoolBag1");

        // then
        Assertions.assertThatThrownBy(() -> {
            bagService.get("SchoolBag1");
        }).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void shouldReturnAllBagsName(){     //problem
        // given
        BagService bagService = new BagService();
        bagService.create("SchoolBag1", "SchoolBag");
        bagService.create("HikingBag1", "HikingBag");

        // when
        List<Bag> test = bagService.get();                              //call the entire list of bags
        Bag firstBag = bagService.get("SchoolBag1");                    //put in a variable my first bag
        Bag secondBag = bagService.get("HikingBag1");                   //put in a variable my second bag

        // then
        Assertions.assertThat(test).contains(firstBag, secondBag);      //verify if the entire list contains my two bags
    }

    @Test
    void tryToAddTheSameBagNameTwice(){
        // given
        BagService bagService = new BagService();
        bagService.create("SchoolBag1", "SchoolBag");
        bagService.create("HikingBag1", "HikingBag");

        // when

        // then
        //Try to add the same bag's name twice
        Assertions.assertThatThrownBy(() ->
                 bagService.create("HikingBag1", "HikingBag"))
                .hasMessage("Error : This bag already exists");

        //Try to create an unknown type bag
        Assertions.assertThatThrownBy(() ->
                 bagService.create("SchoolBag2", "FakeBag"))
                .hasMessage("Error : This type of bag is not available");

        //Try To Add The Same Bag's Name Twice With A Wrong Type
        Assertions.assertThatThrownBy(() ->
                 bagService.create("SchoolBag1", "FakeBag"))
                .hasMessage("Error : This type of bag is not available");
    }
}