package com.sbt.jscool;

public class Human extends Creature {
    @Override
    public void live() {
        System.out.println("Human live");
    }

    @Override
    public void reproduced() {
        System.out.println("Human reproduced");
    }

    @Override
    public void death() {
        System.out.println("Human death");
    }

}
