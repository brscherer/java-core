package com.github.brscherer.core_engineering.homework_8;

import com.github.brscherer.core_engineering.homework_8.models.BlackTavern;
import com.github.brscherer.core_engineering.homework_8.models.Customer;
import com.github.brscherer.core_engineering.homework_8.proxy.TavernProxy;

public class Main {
    public static void main(String[] args) {
        TavernProxy tavernProxy = new TavernProxy(new BlackTavern());
        tavernProxy.enter(new Customer("elf"));
        tavernProxy.enter(new Customer("human"));
        tavernProxy.enter(new Customer("dwarf"));
        tavernProxy.enter(new Customer("orc"));
        tavernProxy.enter(new Customer("white orc"));
        tavernProxy.enter(new Customer("black orc"));
        tavernProxy.enter(new Customer("hobbit"));

    }
}
