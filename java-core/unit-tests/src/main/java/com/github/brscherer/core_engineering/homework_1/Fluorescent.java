package com.github.brscherer.core_engineering.homework_1;

public class Fluorescent implements Lamp{
    @Override
    public void on() {
        System.out.println("Fluorescent Lights On!");
    }

    @Override
    public void off() {
        System.out.println("Fluorescent Lights Off!");
    }
}