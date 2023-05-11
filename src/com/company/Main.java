package com.company;

import java.util.Scanner;

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

        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("You can exit program by typing 'exit'.");
        while(true) {
            input = scan.nextLine();
            if(input.equals("exit")) {

                producer1.interrupt();
                producer2.interrupt();
                producer3.interrupt();

                consumer1.interrupt();
                consumer2.interrupt();
                consumer3.interrupt();

                System.exit(0);
            }
        }

    }
}
