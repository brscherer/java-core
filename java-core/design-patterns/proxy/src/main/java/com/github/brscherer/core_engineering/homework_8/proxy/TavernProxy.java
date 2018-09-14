package com.github.brscherer.core_engineering.homework_8.proxy;

import com.github.brscherer.core_engineering.homework_8.models.Customer;
import com.github.brscherer.core_engineering.homework_8.models.Tavern;

public class TavernProxy implements Tavern {
    private String FORBIDDEN = "orc";
    private final Tavern tavern;

    public TavernProxy(Tavern tavern) {
        this.tavern = tavern;
    }

    @Override
    public void enter(Customer customer) {
        if (customer.getRace().contains(FORBIDDEN))
            System.out.println("Get out of my tavern, f**kn orc!");
        else
            tavern.enter(customer);
    }
}
