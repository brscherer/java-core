package com.github.brscherer.core_engineering.homework_7.models;

public class Odin implements God {
    @Override
    public void kill() {
        System.out.println("Odin has killed everyone!");
    }

    @Override
    public void die() {
        System.out.println("Odin is dead!");
    }
}
