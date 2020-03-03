package com.sbt.jscool;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[] array;
        int n = scanner.nextInt();

        array = new int[n];
        int max1 = 0, max2 = 0;

        for (int i = 0; i < n; ++i) {
            array[i] = scanner.nextInt();
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
            } else if (array[i] > max2 && array[i] != max1) {
                max2 = array[i];
            }
        }

        for (int i = 0; i < n; ++i) {
            if (max1 > max2 * 2) {
                if (array[i] == max1) {
                    array[i] = array[i] / 4;
                }
            } else {
                if (array[i] == max1) {
                    array[i] = array[i] / 2;
                }
                if (array[i] == max2) {
                    array[i] = array[i] / 2;
                }
            }
            System.out.print(array[i]);
            System.out.print(' ');

        }
    }
}
