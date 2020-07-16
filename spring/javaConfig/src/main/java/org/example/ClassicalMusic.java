package org.example;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("classicalMusic Init");
    }

    @PreDestroy
    public void doDestroy() {
        System.out.println("classicalMusic is destroying");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
