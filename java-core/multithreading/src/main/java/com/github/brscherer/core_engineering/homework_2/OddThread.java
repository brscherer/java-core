package com.github.brscherer.core_engineering.homework_2;

import java.util.Random;

public class OddThread extends Thread {
    private Integer SLEEP_TIME = 100;

    public OddThread() {
        System.out.println("OddThread initialized");
    }

    public void run(){
        for (int i=0; i<10; i++) {
            try {
                System.out.println("odd: " + randomOddNumber(1, 500));
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int randomOddNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).limit(1).map(n -> n * 2 + 1).findFirst().getAsInt();
    }
}
