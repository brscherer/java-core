package com.github.brscherer.core_engineering.homework_1;

public class Room {
    private Lamp lamp;
    private boolean status;

    public Room(Lamp lamp) {

        this.lamp = lamp;
        this.status = false;
    }

    public boolean status() {
        return status;
    }

    public void switchStatus() {
        if(status()) {
            this.status = false;
            this.lamp.off();
        }
        else {
            this.status = true;
            this.lamp.on();
        }
    }
}