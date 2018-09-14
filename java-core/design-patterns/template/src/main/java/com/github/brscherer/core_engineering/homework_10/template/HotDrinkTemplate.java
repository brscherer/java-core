package com.github.brscherer.core_engineering.homework_10.template;

import java.util.List;

public abstract class HotDrinkTemplate {

    protected abstract void getIngredients();

    protected abstract void prepare();

    void heat() {
        System.out.println("Heating drink...");
    }

    void serve() {
        System.out.println("Enjoy your drink!");
    }

    public final void start() {
        getIngredients();
        prepare();
        heat();
        serve();
    }

}
