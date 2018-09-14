package com.github.brscherer.core_engineering.homework_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
    @Test
    public void switchFluorescentStatusOnTest() {
        Room roomFluorescentLight = new Room(new Fluorescent());
        roomFluorescentLight.switchStatus();
        assertTrue(roomFluorescentLight.status());
    }

    @Test
    public void switchFluorescentStatusOffTest() {
        Room roomFluorescentLight = new Room(new Fluorescent());
        roomFluorescentLight.switchStatus();
        roomFluorescentLight.switchStatus();
        assertFalse(roomFluorescentLight.status());
    }

    @Test
    public void switchIncandescentStatusOnTest() {
        Room roomIncandescentLight = new Room(new Incandescent());
        roomIncandescentLight.switchStatus();
        assertTrue(roomIncandescentLight.status());
    }

    @Test
    public void switchIncandescentStatusOffTest() {
        Room roomIncandescentLight = new Room(new Incandescent());
        roomIncandescentLight.switchStatus();
        roomIncandescentLight.switchStatus();
        assertFalse(roomIncandescentLight.status());
    }
}
