package com.github.brscherer.core_engineering.homework_8.models;

public class BlackTavern implements Tavern {

    @Override
    public void enter(Customer customer) {
        System.out.println("Enjoy our beer, dear " + customer.getRace());
    }
}
