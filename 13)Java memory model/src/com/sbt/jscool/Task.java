package com.sbt.jscool;

import java.util.concurrent.Callable;

public class Task<T> {

    private volatile Callable<? extends T> callable;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public synchronized T get() throws Exception, ThreadException {
        return this.callable.call();
    }
}
