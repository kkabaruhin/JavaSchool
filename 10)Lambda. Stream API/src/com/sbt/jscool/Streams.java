package com.sbt.jscool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {

    private ArrayList<T> data;

    public Streams<T> of(Collection<T> collection) {
        this.data = new ArrayList<T>();
        this.data.addAll(collection);
        return this;
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        ArrayList<T> newData = new ArrayList<T>();
        for (T x : this.data) {
            if (predicate.test(x)) {
                newData.add(x);
            }
        }

        return new Streams<T>().of(newData);
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> mapper) {
        ArrayList<R> newData = new ArrayList<R>();
        for (T x: this.data) {
            newData.add(mapper.apply(x));
        }
        return new Streams<R>().of(newData);
    }

    public <E,C,F, R>Map<C, R> toMap(Function<? super T, C> keyFunction, Function<? super T, R> valueFunction) {
        Map<C, R> result = new TreeMap<C, R>();

        for (T x: this.data) {
            C key = keyFunction.apply(x);
            R value = valueFunction.apply(x);
            result.put(key, value);
        }

        return result;
    }

}
