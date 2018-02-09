package com.sourceit.cp;

public class TransferItem {
    private int value;
    protected volatile boolean isValuePresent = false;

    public synchronized int get() {
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        System.out.println("Put: " + value);
    }
}
