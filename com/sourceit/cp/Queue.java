package com.sourceit.cp;

public class Queue {
    TransferItem item ;
    volatile Storage<Object> queue = new Storage<Object>(Object.class, 10);
    int n = 0;

    synchronized void put(int n) {
        if(queue.size() == 10)
            try {
                System.out.println("Producer is sleeping");
                wait();
                System.out.println("Producer awake");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            item = new TransferItem();
            item.isValuePresent = true;
            item.put(n);
            queue.push(item);
            notify();
    }

    synchronized int get() {
        if (queue.size() == 0)
            try {
                System.out.println("Consumer is sleeping");
                wait();
                System.out.println("Consumer awake");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
            item = (TransferItem)queue.pop();
            int value = item.get();
            notify();
            return value;
    }
}
