package com.github.brscherer.core_engineering.homework_2;

import java.util.Random;

public class EvenThread extends Thread {
    private Integer SLEEP_TIME = 500;

    public EvenThread() {
        System.out.println("EvenThread initialized");
    }

    public void run(){
        for (int i=0; i<10; i++) {
            try {
                System.out.println("even: " + randomEvenNumber(1, 500));
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int randomEvenNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).limit(1).map(n -> n * 2).findFirst().getAsInt();
    }
}
