package com.executor.poc;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class TestParellalism {

    static class ForkJoinTesting extends RecursiveTask<Long> {
        private final int[] arr;
        private final int start;
        private final int end;

        ForkJoinTesting(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int mid = (start + end) / 2;
            int THRESHOLD = 5;
            if (end - start < THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {

                ForkJoinTesting task1 = new ForkJoinTesting(arr, start, mid);
                ForkJoinTesting task2 = new ForkJoinTesting(arr, mid, end);

                task1.fork();
                long task2Calculation = task2.compute();
                long task1Calculation = task1.join();

                return task1Calculation + task2Calculation;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[299];
        IntStream.range(0, a.length).forEach(i -> a[i] = random.nextInt(999));

        ForkJoinTesting forkJoinTesting = new ForkJoinTesting(a, 0, a.length);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        System.out.println(Arrays.toString(a));
        System.out.println(forkJoinPool.invoke(forkJoinTesting));

    }
}
