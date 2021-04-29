package com.springboot.demo.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JdkProxy implements InvocationHandler {
    private Object target;//需要代理的目标对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    //定义获取代理对象方法
    private Object getJDKProxy(Object targetObject) {
        //为目标对象target赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();//实例化JDKProxy对象
        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());//获取代理对象
        user.addUser("admin", "123123");//执行新增方法
        AtomicInteger count = new AtomicInteger(0);

        new Thread(() -> {
            user.delUser("admin");
        }).start();

        Thread t1 = new Thread(() -> {

            user.addUser("admin2", "1111123123");//执行新增方法
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {

            try {
                t1.join();
                user.delUser("admin2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Lock lock = new ReentrantLock();
        CountDownLatch timerController = new CountDownLatch(2);
        Thread t3 = new Thread(() -> {
            System.out.println("Start t3...");
           /* try {
                timerController.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            for (int i = 0; i < 100; i++) {
                // lock.lock();
                System.out.println(count.get() + ".." + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.getAndIncrement();
                // lock.unlock();

            }
            timerController.countDown();
        });

        Thread t4 = new Thread(() -> {
            System.out.println("Start t4...");
           /* try {
                timerController.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            for (int i = 0; i < 100; i++) {
                //  lock.lock();
                System.out.println(count.get() + ".." + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.getAndIncrement();
                //   lock.unlock();

            }
            timerController.countDown();
        });

        t3.start();
        t4.start();

        new Thread(() -> {

            t2.start();
            t1.start();

        }).start();
        System.out.println(count.get());
    }

}
