package com.company;

import java.util.Random;

public class Consumer implements Runnable{
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int counter = 0;
        Random random = new Random();
        while(counter<100) {
            int randomNumber = random.nextInt(10);

            // random product to be taken from the warehouse
            Products product = Products.values()[randomNumber];

            // random amount of the product to be taken from the warehouse
            // +1 so that there is no chance that customer wants to take 0 products
            randomNumber = random.nextInt(19) + 1;

            System.out.println("Consumer wants to take " + randomNumber + " of " + product.toString());

            try {
                System.out.println("ID: " + Thread.currentThread().getId() + " -> " + resource.take(product, randomNumber));

            } catch (InterruptedException ex) {

            }
            randomNumber = random.nextInt(15) + 25;

            try {
                Thread.sleep(randomNumber*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
