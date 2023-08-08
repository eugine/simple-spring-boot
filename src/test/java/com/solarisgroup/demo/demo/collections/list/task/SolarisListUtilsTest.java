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
        var list = List.of("a", "b", "c", "a", "b", "c", "a", "b", "c", "d");

        var result = SolarisListUtils.findUnique(list);
        assertEquals(4, result.size());
    }

    @Test
    void shouldFindOccurrence() {
        var list = List.of("a", "b", "c", "a", "b", "c", "a", "b", "c", "d");

        var result = SolarisListUtils.findOccurrence(list);
        assertEquals(4, result.size());

        assertEquals(3, findOccurrence(result, "a").occurrence());
        assertEquals(3, findOccurrence(result, "b").occurrence());
        assertEquals(3, findOccurrence(result, "c").occurrence());
        assertEquals(1, findOccurrence(result, "d").occurrence());
    }

    private ItemOccurrence findOccurrence(List<ItemOccurrence> items, String name) {
        ItemOccurrence result = null;
        for (ItemOccurrence item : items) {
            if (item.item().equals(name)) {
                result = item;
                break;
            }
        }
        return result;
    }

}
