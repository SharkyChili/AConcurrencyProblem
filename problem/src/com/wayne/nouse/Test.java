package com.wayne.nouse;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) {
        Integer i = 10000;
        CountDownLatch latch = new CountDownLatch(i);

        for (Integer integer = 0; integer < i; integer++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Work.inc();
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Work.count);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Work.count);

    }

}
