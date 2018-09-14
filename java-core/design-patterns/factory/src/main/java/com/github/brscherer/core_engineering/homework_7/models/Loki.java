package com.github.brscherer.core_engineering.homework_7.models;

public class Loki implements God {
    @Override
    public void kill() {
        System.out.println("Loki has killed everyone!");
    }

    @Override
    public void die() {
        System.out.println("Loki is dead!");
    }
}
