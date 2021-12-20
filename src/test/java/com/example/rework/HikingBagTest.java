package com.example.rework;

import com.example.rework.model.HikingBag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class HikingBagTest {
    @Test
    void shouldHaveTheRightCapacity(){
        // given
        HikingBag TestHikingBag = new HikingBag("MyHikingBag");

        // when
        int result = TestHikingBag.getCapacity();

        // then
        Assertions.assertThat(result).isEqualTo(50);
    }

    @Test
    void shouldHaveTheRightName(){
        // given
        HikingBag TestHikingBag = new HikingBag("MyHikingBag");

        // when
        String result = TestHikingBag.getName();

        // then
        Assertions.assertThat(result).isEqualTo("MyHikingBag");
    }

    @Test
    void shouldAddASlot(){
        // given
        HikingBag TestHikingBag = new HikingBag("MyHikingBag");

        // when
        TestHikingBag.addSlot(3);

        // then
        Assertions.assertThat(TestHikingBag.getCapacity()).isEqualTo(80);
    }

    @Test
    void shouldHaveTheRightSlotsAndCapacity(){
        // given
        HikingBag TestHikingBag = new HikingBag("MyHikingBag");

        // when
        TestHikingBag.addSlot(4);
        int result = TestHikingBag.getSlots();
        int result2 = TestHikingBag.getCapacity();

        // then
        Assertions.assertThat(result).isEqualTo(6);
        Assertions.assertThat(result2).isEqualTo(90);
    }
}
