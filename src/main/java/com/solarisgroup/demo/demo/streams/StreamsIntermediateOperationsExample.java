package com.solarisgroup.demo.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsIntermediateOperationsExample {

    public static final List<String> NAMES = List.of("John", "Jane", "Adam", "Eve");
    private static final Random random = new Random();

    public static void main(String[] args) {
//        streamCreation();
//        numericStreams();
//        streamLaziness();
//        streamFiltering();
//        streamSorting();
//        infiniteStream();
//        streamMapping();
        streamFlatMap();
    }

    private static void infiniteStream() {
        IntStream.generate(() -> random.nextInt())
                .skip(10)
                .limit(5)
                .forEach(value -> System.out.println(value));
    }

    private static void streamCreation() {
        Stream<String> stringStream = Stream.of("hello", "worlds");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Stream<?> emptyStream = Stream.empty();
        List<String> names = List.of("John", "Jane", "Adam", "Eve");
        Stream<String> namesStream = names.stream();
    }

    private static void streamLaziness() {
        var counter = new SimpleCounter();
        var result = NAMES.stream()
                .filter(element -> {
                    counter.increment();
                    return false;
                })
                .count();
        System.out.println("Counter: " + counter.getValue());
        System.out.println("Result: " + result);
    }

    private static void numericStreams() {
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream intStream2 = IntStream.range(0, 10);
        IntStream intStream3 = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return random.nextInt();
            }
        });

        LongStream longStream = LongStream.of(1, 2, 3, 4);
        DoubleStream doubleStream1 = DoubleStream.of(1.0, 2.0, 3.0);
    }

    private static void streamFiltering() {
        System.out.println(NAMES);
        List<String> filteredNames = NAMES.stream()
                .filter(name -> name.startsWith("J") || name.startsWith("E"))
//                .filter(name -> name.length() == 3)
                .toList();
        System.out.println(filteredNames);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> oddNumbers = numbers.stream()
                .filter(value -> value % 2 == 1)
                .toList();
        System.out.println("odd numbers:" + oddNumbers);

        List<Integer> nameLengths = NAMES.stream()
                .filter(name -> name.startsWith("J"))
                .map(name -> name.length())
                .filter(length -> length > 2)
                .toList();
        System.out.println("name lengths: " + nameLengths);
    }

    private static void streamSorting() {
        System.out.println(NAMES);
        List<String> sortedNames = NAMES.stream()
                .sorted()
                .filter(name -> name.length() == 4)
                .toList();

        System.out.println(sortedNames);
    }

    private static void streamMapping() {
        var lengths = NAMES.stream()
                .map(String::length)
                .toList();
        System.out.println(lengths);
    }

    private static void streamFlatMap() {
        List<List<String>> namesOfNames = List.of(
                List.of("John", "Jane", "Adam", "Eve"),
                List.of("Test1", "Test2")
        );

        System.out.println(namesOfNames);

        Map<String, String> result = namesOfNames.stream()
                .flatMap(list -> list.stream())
//                .collect(Collectors.joining(", "));
//                .toList();
//                .collect(Collectors.toSet());
                .collect(Collectors.toMap(item -> item, item -> item.toLowerCase()));
        System.out.println("Result: " + result);
    }
}
