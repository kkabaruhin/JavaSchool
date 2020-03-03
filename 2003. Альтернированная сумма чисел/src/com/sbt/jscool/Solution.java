package com.sbt.jscool;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                sum += scanner.nextInt();
            } else {
                sum -= scanner.nextInt();
            }
        }

        System.out.println(sum);
    }
}
