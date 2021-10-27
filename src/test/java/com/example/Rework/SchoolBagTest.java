package com.example.Rework;

import com.example.Rework.model.Bag;
import com.example.Rework.model.SchoolBag;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class SchoolBagTest {
    @Test
    void shouldHaveTheRightContenance(){
        // given
        Bag TestSchoolBag = new SchoolBag("SchoolBagTest");

        // when
        int result = TestSchoolBag.getCapacity();

        // then
        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
     void shouldHaveTheRightName(){

        // given
        Bag TestSchoolBag = new SchoolBag("SchoolBagTest");

        // when
        String result = TestSchoolBag.getName();

        // then
        Assertions.assertThat(result).isEqualTo("SchoolBagTest");
    }
}
