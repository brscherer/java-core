package com.github.brscherer.core_engineering.homework_10.model;

import com.github.brscherer.core_engineering.homework_10.template.HotDrinkTemplate;

public class IrishCoffee extends HotDrinkTemplate{

    @Override
    protected void getIngredients() {
        System.out.println("Getting coffee and whiskey...");
    }

    @Override
    protected void prepare() {
        System.out.println("Preparing Irish Coffee...");
    }
}
