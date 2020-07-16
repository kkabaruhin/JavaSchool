package com.sbt.jscool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 10; i >= 1; --i) {
            array.add(i);
        }


        for (Integer x: array
             ) {
            FactorialThread factorialThread = new FactorialThread(x);
            factorialThread.run();
        }
    }
}
