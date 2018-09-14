package com.github.brscherer.core_engineering.homework_10;

import com.github.brscherer.core_engineering.homework_10.model.HotChocolate;
import com.github.brscherer.core_engineering.homework_10.model.IrishCoffee;

public class Main {
    public static void main(String[] args) {
        IrishCoffee irishCoffee = new IrishCoffee();
        irishCoffee.start();

        System.out.println("===================");

        HotChocolate hotChocolate = new HotChocolate();
        hotChocolate.start();
    }
}
