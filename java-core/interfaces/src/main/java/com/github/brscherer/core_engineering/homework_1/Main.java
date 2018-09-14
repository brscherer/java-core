package com.github.brscherer.core_engineering.homework_1;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(new Fluorescent());
        Room room2 = new Room(new Incandescent());

        room.switchStatus();
        room.switchStatus();

        room2.switchStatus();
        room2.switchStatus();
    }
}