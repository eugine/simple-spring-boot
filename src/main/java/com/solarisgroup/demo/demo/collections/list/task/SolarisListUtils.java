package com.solarisgroup.demo.demo.collections.list.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SolarisListUtils {
    /**
     * Count the number of occurrences of a value in a list
     * @param items list of items
     * @param value value to count
     * @return number of occurrences
     */
    public static int countOccurrence(List<String> items, String value) {
       int count = 0;
        for (String item : items) {
            if (Objects.equals(item, value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Find the unique items in a list
     * @param items list of items
     * @return list of unique items
     */
    public static List<String> findUnique(List<String> items) {
        var result = new ArrayList<String>();
        for (var item : items) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Find the occurrences of each item in a list
     * @param items list of items
     * @return list of item occurrences
     */
    public static List<ItemOccurrence> findOccurrence(List<String> items) {
        var result = new ArrayList<ItemOccurrence>();
        for (String item : findUnique(items)) {
            result.add(new ItemOccurrence(item, countOccurrence(items, item)));
        }
        return result;
    }
}


