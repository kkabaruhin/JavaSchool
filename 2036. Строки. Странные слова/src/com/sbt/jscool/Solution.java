package com.sbt.jscool;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            String string = scanner.next();
            int cnt = 0;
            for (int j = 0; j < string.length(); ++j) {
                if (string.charAt(j) == 'e' || string.charAt(j) == 'y' ||
                        string.charAt(j) == 'u' || string.charAt(j) == 'i' ||
                        string.charAt(j) == 'o' || string.charAt(j) == 'a') {
                    ++cnt;
                } else {
                    cnt = 0;
                }
                if (cnt == 3) {
                    break;
                }
            }
            if (cnt < 3) {
                System.out.println(string);
            }
        }
    }
}
