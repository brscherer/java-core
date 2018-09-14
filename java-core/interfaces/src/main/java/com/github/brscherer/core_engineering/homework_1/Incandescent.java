package com.github.brscherer.core_engineering.homework_1;

public class Incandescent implements Lamp {
    @Override
    public void on() {
        System.out.println("Incandescent Lights On!");
    }

    @Override
    public void off() {
        System.out.println("Incandescent Lights Off!");
    }
}