package com.concepts;

import com.water.Test;

import java.util.concurrent.Semaphore;

public class JavaSemaphore {
    public static void main(String[] args) throws InterruptedException {
        TestTask testTask = new TestTask();
        Thread thread1 = new Thread(testTask);
        Thread thread2 = new Thread(testTask);
        thread1.setName("FirstThread");
        thread2.setName("SecondThread");



        thread1.start();
        thread2.start();

    }
}

class TestTask implements Runnable {

    Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Being run by " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("Currently running with " + i + " -> " + Thread.currentThread().getName());
                Thread.sleep(2000);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
    }
}
