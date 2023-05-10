package com.company;

public class Resource {
    private int[] amounts = new int[10];
    private int maxCapacity = 20;

    public synchronized String take(Products product, int amount) throws InterruptedException {
        int idx = 0;

        for (int i = 0; i < 10; i++) {
            if(Products.values()[i].equals(product)) {
                idx = i;
                break;
            }
        }

        while (amounts[idx] == 0) {
            wait();
        }

        int amountTaken = Integer.min(amount, amounts[idx]);
        amounts[idx] -= amountTaken;

        String ret = "Customer took " + amountTaken + " of " + product.toString() + " from the warehouse.";
        ret += "There is now " + amounts[idx] + " of this product";

        return ret;
    }

    public synchronized void put(Products product, int amount) {
        int idx = 0;

        for (int i = 0; i < 10; i++) {
            if(Products.values()[i].equals(product)) {
                idx = i;
                break;
            }
        }
        int amountToPut = Integer.min(maxCapacity-amounts[idx], amount);
        amounts[idx] += amountToPut;

        System.out.println("Put " + amountToPut + " of " + product.toString() + " to the warehouse.");
        System.out.println("There is now " + amounts[idx] + " of this product");

        notifyAll();
    }
}
