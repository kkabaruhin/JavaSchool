package org.example;

import org.springframework.stereotype.Component;


public class ClassicalMusic implements Music {
    //private ClassicalMusic() {}

    public static ClassicalMusic createClassicalMusic() {
        System.out.println("factory created ClassicalMusic");
        return new ClassicalMusic();
    }

    public void doMyInit() {
        System.out.println("classical music init");
    }

    public void doMyDestroy() {
        System.out.println("classical music destroy");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
