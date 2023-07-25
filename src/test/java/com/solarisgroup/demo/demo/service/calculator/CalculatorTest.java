package com.solarisgroup.demo.demo.service.calculator;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    void shouldAdd() {
        var target = new Calculator();

        assertEquals(3, target.add(2, 1));

        assertThat(target.add(2, 1), equalTo(3));
    }

}
