package com.sbt.jscool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {

    public static void printAllMethods(Class c) {

        while (c != null) {
            System.out.format("class name: %s", c.getName());
            Method[] methods = c.getDeclaredMethods();
            System.out.println();
            for (int i = 0; i < methods.length; ++i) {
                System.out.println(methods[i].toString());
            }
            c = c.getSuperclass();
        }
    }
    

    public static void main(String[] args) {
	    Human human1 = new Human();

	    printAllMethods(human1.getClass());
    }
}
