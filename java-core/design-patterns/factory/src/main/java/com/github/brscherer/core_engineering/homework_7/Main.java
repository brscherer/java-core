package com.github.brscherer.core_engineering.homework_7;

import com.github.brscherer.core_engineering.homework_7.factory.GodFactory;
import com.github.brscherer.core_engineering.homework_7.models.God;

public class Main {
    public static void main(String[] args) {
        GodFactory me = new GodFactory();

        God loki = me.summonGod("LOKI");
        loki.kill();

        God odin = me.summonGod("ODIN");
        odin.die();

        God thor = me.summonGod("THOR");
        thor.die();

    }
}
