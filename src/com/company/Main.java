package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Thread producer1 = new Thread(new Producer(resource));
        Thread producer2 = new Thread(new Producer(resource));
        Thread producer3 = new Thread(new Producer(resource));

        Thread consumer1 = new Thread(new Consumer(resource));
        Thread consumer2 = new Thread(new Consumer(resource));
        Thread consumer3 = new Thread(new Consumer(resource));

        Thread.sleep(5000);
        producer1.start();
        Thread.sleep(5000);
        producer2.start();
        Thread.sleep(5000);
        producer3.start();
        Thread.sleep(5000);

        consumer1.start();
        Thread.sleep(5000);
        consumer2.start();
        Thread.sleep(5000);
        consumer3.start();



    }
}
