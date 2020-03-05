package com.sbt.jscool;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] strings = {"ABC", "AAA", "AA", "AAA", "AAA", "BCFSD", "AA"};

        //1-3 задания
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    if (o1.length() > o2.length()) {
                        return 1;
                    }
                }
                return o1.compareTo(o2);
            }
        };

        TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<>(comparator);

        for (String str : strings
        ) {
            if (stringIntegerTreeMap.containsKey(str)) {
                stringIntegerTreeMap.put(str, stringIntegerTreeMap.get(str) + 1);
            } else {
                stringIntegerTreeMap.put(str, 1);
            }
        }

        System.out.println("Колличество различных слов: " + stringIntegerTreeMap.size());

        for (Map.Entry<String, Integer> kv : stringIntegerTreeMap.entrySet()
        ) {
            System.out.println(kv.getKey() + " встречается " + kv.getValue() + " раз");
        }

        //4 задание
        String[] newStrings = new String[strings.length];

        for (int i = 0; i < strings.length; ++i) {
            newStrings[i] = strings[i];
        }

        for (int i = newStrings.length - 1; i > -1; --i) {
            System.out.println(newStrings[i]);
        }

        //6 задание
        System.out.println("Введите номер строки, которую хотите получить. Или введите -1 для окончания");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 0) {
                break;
            }

            if (number > newStrings.length) {
                System.out.println("Строки с таким номером нет, попробуйте еще");
                continue;
            }

            System.out.println(newStrings[number]);


        }

    }
}
