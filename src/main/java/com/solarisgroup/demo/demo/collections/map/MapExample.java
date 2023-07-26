package com.solarisgroup.demo.demo.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        // map creation
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<String, String>();

        var mapImmutable = Map.of("key3", "value3", "key4", "value4");

        // map operations
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.putAll(mapImmutable);

//        mapImmutable.put("key5", "value5"); //will fail since the map is immutable

        map.get("key1");
        map.remove("key2");

        // map iteration
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            System.out.println("While loop item: " + entry.getKey() + " " + entry.getValue());
        }

        for (var entry : map.entrySet()) {
            System.out.println("For loop item: " + entry.getKey() + " " + entry.getValue());
        }

    }
}
