package com.solarisgroup.demo.demo.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        // list creation
        List<String> items = new ArrayList<>();
        List<String> items2 = new LinkedList<>();
        List<String> itemsImmutable = List.of("one", "two", "three");

        // list operations
        items.add("one");
        items2.add("two");
//        itemsImmutable.add("three"); //will fail since the list is immutable

        items.addAll(itemsImmutable);

        //accessing elements
        items.get(0);
        //delete elements
        items.remove(0); // by index
        items.remove("two"); // by value


        // list iteration
        var iterator = items.iterator();

        //iteration with while loop
        while (iterator.hasNext()) {
            var item = iterator.next();
            System.out.println("While loop item: " + item);
        }

        //iteration with for loop
        for (var item : items) {
            System.out.println("For loop item: " + item);
        }

    }

}
