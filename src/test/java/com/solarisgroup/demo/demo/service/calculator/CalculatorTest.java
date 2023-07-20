package com.solarisgroup.demo.demo.service.calculator;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator target = new Calculator();

    @Test
    void shouldAdd() {
        assertEquals(3, target.add(1, 2));

//         Hamcrest
//        assertThat(target.add(1, 2), equalTo(3));
    }

}
