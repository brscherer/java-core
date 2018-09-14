package com.github.brscherer.core_engineering.homework_2;

public class Main {
    public static void main(String[] args) {
        EvenThread even = new EvenThread();
        OddThread odd = new OddThread();

        even.start();
        odd.start();
    }
}
