package com.sbt.jscool;

public class Main {

    public static void main(String[] args) throws Exception {
        Callable1 callable1 = new Callable1();
	    Task<Long> task = new Task<Long>(callable1);

	    Long result = task.get();
        System.out.println(result);
    }
}
