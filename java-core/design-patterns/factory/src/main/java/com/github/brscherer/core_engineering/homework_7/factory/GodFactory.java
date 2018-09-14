package com.github.brscherer.core_engineering.homework_7.factory;

import com.github.brscherer.core_engineering.homework_7.models.God;
import com.github.brscherer.core_engineering.homework_7.models.Loki;
import com.github.brscherer.core_engineering.homework_7.models.Odin;
import com.github.brscherer.core_engineering.homework_7.models.Thor;

public class GodFactory {
    public God summonGod(String god) {
        switch (god) {
            case "ODIN": return new Odin();
            case "THOR": return new Thor();
            case "LOKI": return new Loki();
            default: throw new RuntimeException("You must summon a real god!");
        }
    }
}
