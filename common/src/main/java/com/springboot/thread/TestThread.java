package com.springboot.thread;

import com.springboot.threadLocal.AuthTokenHolder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {
    public static int count = 0;

    public class Number {
        int     i    = 1;
        boolean flag = false;//偶数true 奇数 flase
    }

    public class PrintOdd implements Runnable {
        Number number;

        public PrintOdd(Number number) {
            this.number = number;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("PrintOdd");
            while (number.i <= 100) {
                synchronized (number) {
                    if (number.flag) {
                        try {
                            number.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "==>" + number.i);
                        number.i++;
                        number.flag = true;
                        number.notify();
                    }
                }
            }

        }
    }

    public class PrintEven implements Runnable {
        Number number;

        public PrintEven(Number number) {
            this.number = number;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("PrintEven");
            while (number.i <= 100) {
                synchronized (number) {

                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "==>" + number.i);
                        number.i++;
                        number.flag = false;
                        number.notify();
                    } else {
                        try {
                            number.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }
    }

    public static void main(String[] args) {
        int count = 0;
        Number num = new TestThread().new Number();
        PrintOdd printOdd = new TestThread().new PrintOdd(num);
        PrintEven printEven = new TestThread().new PrintEven(num);
        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);
        //   thread1.start();
        //  thread2.start();

        TestThread testThread = new TestThread();
           testThread.testRun();
        //testThread.testRunWithLock();

    }

    public void testRun() {
        Object obj = new Object();

        Thread odd = new Thread(() -> {
            AuthTokenHolder.setToken("odd");
            while (count <= 100) {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    obj.notifyAll();
                    try {
                        if (count <= 100) {
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
            System.out.println(AuthTokenHolder.getToken());

        }, "odd");
        Thread even = new Thread(() -> {

            while (count <= 100) {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    obj.notifyAll();
                    try {
                        if (count <= 100) {
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        }, "even");
        odd.start();
        even.start();
    }

    /**
     * 使用 ReentrantLock 和 condition
     * 线各启动顺序不影响结果
     */
    public void testRunWithLock() {

        ReentrantLock lock = new ReentrantLock();
        Condition odd = lock.newCondition();
        Condition even = lock.newCondition();

        Thread oddThread = new Thread(() -> {
            lock.lock();
            try {

                while (count < 100) {

                    while (count % 2 == 0) {
                        //释放锁
                        odd.awaitNanos(100);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    even.signal();

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "odd");
        Thread evenThread = new Thread(() -> {
            lock.lock();
            try {
                while (count < 100) {

                    while (count % 2 == 1) {
                        //释放锁
                        odd.awaitNanos(100);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    even.signal();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "even");

        oddThread.start();
        evenThread.start();

    }
}
