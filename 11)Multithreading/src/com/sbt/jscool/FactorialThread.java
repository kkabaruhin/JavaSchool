package com.sbt.jscool;

public class FactorialThread implements Runnable {
    private int number;

    public FactorialThread(int inNumber) {
        this.number = inNumber;
    }

    @Override
    public void run() {
        int result = 1;
        for (int i = 1; i <= this.number; ++i) {
            result *= i;
        }

        System.out.format("factorial of %s = %s \n", number, result);
    }
}
