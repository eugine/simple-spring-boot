package com.solarisgroup.demo.demo.lambda;

@FunctionalInterface
public interface FunctionalInterfaceExample {

    void process(String message);

    default void processTwice(String message) {
        process(message);
        process(message);
    }

    static void main(String[] args) {

        FunctionalInterfaceExample example2 = (message) -> System.out.println(message);
        example2.processTwice("hello");


        FunctionalInterfaceExample example3 = System.out::println;

        FunctionalInterfaceExample example4 = FunctionalInterfaceExample::printMessageTwice;


//        example2.process("hello");
//        example2.process("worlds");
//        System.out.println("------");
        example4.process("hello");
        example4.process("worlds");
    }

    private static void printMessageTwice(String message) {
        System.out.println("1: " + message);
        System.out.println("2: " + message);
    }

}
