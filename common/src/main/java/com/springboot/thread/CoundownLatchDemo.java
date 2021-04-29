package com.springboot.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CoundownLatchDemo {
    private static int            threadCount    = 100;
    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {

                count.getAndIncrement();
                System.out.println(count.get());
                countDownLatch.countDown();

            }).start();


        }

        countDownLatch.await();

     //   Thread.currentThread().join();
        System.out.println("###########" + count.get());

    }

    public class CountThred implements Runnable {
        private int count;

        CountThred(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
