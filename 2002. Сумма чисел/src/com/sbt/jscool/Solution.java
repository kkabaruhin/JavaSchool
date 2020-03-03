package com.sbt.jscool;

import java.util.*;
import java.io.*;

public class Solution
{
    public static void main (String[] argv) throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += scanner.nextInt();
        }

        System.out.println(sum);
    }
}
