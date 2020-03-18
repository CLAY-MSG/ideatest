package cn.itcast.day18.demo08.WNTest;

import java.security.Provider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    等待唤醒机制其实就是经典的“生产者与消费者”的问题。
    就拿生产包子消费包子来说等待唤醒机制如何有效利用资源：
    包子铺线程生产包子，吃货线程消费包子。当包子没有时（包子状态为false），吃货线程等待，包子铺线程生产包子
    （即包子状态为true），并通知吃货线程（解除吃货的等待状态）,因为已经有包子了，那么包子铺线程进入等待状态。
    接下来，吃货线程能否进一步执行则取决于锁的获取情况。如果吃货获取到锁，那么就执行吃包子动作，包子吃完（包
    子状态为false），并通知包子铺线程（解除包子铺的等待状态）,吃货线程进入等待。包子铺线程能否进一步执行则取
    决于锁的获取情况。
*/
public class Test {
    public static void main(String[] args) {
        Baozi bz = new Baozi();
        Consumer consumer = new Consumer(bz);
        Producer producer = new Producer(bz);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.submit(consumer);
        ex.submit(producer);

        /*Thread t1 =new Thread(consumer);
        Thread t2 =new Thread(producer);
        t1.start();
        t2.start();*/
        /*consumer.start();
        producer.start();*/
    }
}

