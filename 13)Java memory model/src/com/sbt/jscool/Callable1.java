package com.sbt.jscool;

import java.util.concurrent.Callable;

public class Callable1 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return System.currentTimeMillis();
    }
}
