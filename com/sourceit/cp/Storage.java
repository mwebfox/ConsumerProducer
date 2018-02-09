package com.sourceit.cp;

import java.lang.reflect.Array;

public class Storage<E> {
    private E[] arr;
    private int head = -1;
    private int tail = -1;
    private int size;

     public Storage(Class<E> c, int size) {
        E[] newInstance = (E[]) Array.newInstance(c, size);
        this.arr = newInstance;
        this.size = 0;
    }

    synchronized boolean push(E e) {
        if (size == arr.length)
            return false;
        head = (head + 1) % arr.length;
        arr[head] = e;
        size++;
        if (tail == -1) {
            tail = head;
        }
        return true;
    }

    synchronized E pop() {
        if (size == 0) {
            return null;
        }
        E result = arr[tail];
        arr[tail] = null;
        size--;
        tail = (tail + 1) % arr.length;
        if (size == 0) {
            head = -1;
            tail = -1;
        }
        return result;
    }

    public  synchronized int size() {
        return this.size;
    }
}