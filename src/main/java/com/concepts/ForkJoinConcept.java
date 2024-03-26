package com.concepts;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinConcept {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        /*ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        Thread t1 = new Thread(() -> forkJoinPool.submit(() -> Arrays.stream(arr).parallel().forEach(element -> {
            try {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        })).invoke());
        t1.start();
        t1.join();

        Thread t2 = new Thread(() -> System.out.println("THIS IS THREAD 2"));
        t2.start();*/

        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        System.out.println(forkJoinPool.getPoolSize());
        forkJoinPool.submit(() -> System.out.println(Thread.currentThread().getName() + " This is fork-join pool")).invoke();
    }
}
