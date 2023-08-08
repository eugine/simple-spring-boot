package com.solarisgroup.demo.demo.lambda.classes;

import static com.solarisgroup.demo.demo.lambda.LambdaExpressionExample.log;

public class AnonymousClassExample {

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
            }
        };

        localRunnable.run();
        anonymousRunnable.run();
    }

    public static void main(String[] args) {
        new AnonymousClassExample().process();
    }
}
