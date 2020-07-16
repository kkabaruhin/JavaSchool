package com.sbt.jscool;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);

        //Map<Object, Object> map = new Streams<Integer>().of(arrayList).filter(in -> in>1).toMap(in -> in, in -> in);

        //Map<Object, Object> map = new Streams<Integer>().of(arrayList).toMap(in -> in, in -> in*2);

        Map<Object, Object> map = new Streams<Integer>().of(arrayList).transform(in -> in*0.9).toMap(in -> in, in -> in);

        Set<Object> keySet = map.keySet();

        for (Object o: keySet
             ) {
            System.out.print(o + " ");
            System.out.println(map.get(o));
        }
    }
}
