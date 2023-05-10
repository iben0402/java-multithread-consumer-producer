package com.company;
import java.util.Random;

public class Producer implements Runnable{
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int counter = 0;
        Random random = new Random();
        while(counter < 100) {
            int randomNumber = random.nextInt(10);

            // random product to put to the warehouse
            Products product = Products.values()[randomNumber];

            // random amount of the product to put to the warehouse
            randomNumber = random.nextInt(5) + 5;

            resource.put(product, randomNumber);

            //random time to sleep
            randomNumber = random.nextInt(15) + 25;
            counter++;
            try {
                Thread.sleep(randomNumber*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
