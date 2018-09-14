package com.github.brscherer.core_engineering.homework_10.model;

import com.github.brscherer.core_engineering.homework_10.template.HotDrinkTemplate;

public class HotChocolate extends HotDrinkTemplate {

    @Override
    protected void getIngredients() {
        System.out.println("Getting cocoa, milk, sugar and chantilly...");
    }

    @Override
    protected void prepare() {
        System.out.println("Preparing Hot Chocolate...");
    }
}
