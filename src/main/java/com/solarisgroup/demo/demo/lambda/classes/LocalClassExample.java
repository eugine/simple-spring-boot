package com.solarisgroup.demo.demo.lambda.classes;

public class LocalClassExample {
    public Object process(String event) {
        class LocalClass {
            private void process(String event) {
                System.out.println("LocalClass processing event: " + event);
            }
        }

        var local = new LocalClass();
        local.process("event");
        return local;
    }

    public static void main(String[] args) {
        var example = new LocalClassExample();

        var result = example.process("event");
        System.out.println(result);
        System.out.println("type: " + result.getClass());
    }
}
