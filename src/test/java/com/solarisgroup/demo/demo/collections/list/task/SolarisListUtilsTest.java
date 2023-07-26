package com.solarisgroup.demo.demo.collections.list.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarisListUtilsTest {

    @Test
    void shouldCountOccurrence() {
        var list = List.of("a", "b", "c", "a", "b", "c", "a", "b", "c", "d");

        assertEquals(3, SolarisListUtils.countOccurrence(list, "a"));
    }

    @Test
    void shouldFindUnique() {
        //TBD
    }

    @Test
    void shouldFindOccurrence() {
        //TBD
    }
}
