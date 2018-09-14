package com.github.brscherer.core_engineering.homework_7.models;

public class Thor implements God {
    @Override
    public void kill() {
        System.out.println("Thor has killed everyone!");
    }

    @Override
    public void die() {
        System.out.println("Thor is dead!");
    }
}
