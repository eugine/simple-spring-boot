package com.solarisgroup.demo.demo.lambda;

public class LambdaExpressionExample {

    public void process() {
        class LocalRunnable implements Runnable {

            @Override
            public void run() {
                log("Local runnable");
            }
        }
        var localRunnable = new LocalRunnable();

        var anonymousRunnable = new Runnable() {

            @Override
            public void run() {
                log("Anonymous runnable");
                //second line of code
            }
        };

        Runnable lambdaRunnable = () -> log("Lambda runnable");

        localRunnable.run();
        anonymousRunnable.run();
        lambdaRunnable.run();
    }

    public static void main(String[] args) {
        new LambdaExpressionExample().process();
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
