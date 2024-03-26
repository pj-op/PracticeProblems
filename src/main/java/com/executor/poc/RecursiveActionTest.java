package com.executor.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RecursiveActionTest {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> intList = new ArrayList<>();
        IntStream.range(0, random.nextInt(100)).forEach(i -> intList.add(random.nextInt(999999)));
//        System.out.println(intList);
        TestRecursiveAction testRecursiveAction = new TestRecursiveAction(intList);
        TestRecursiveTask testRecursiveTask = new TestRecursiveTask(intList);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

//        forkJoinPool.invoke(testRecursiveAction);
        System.out.println(forkJoinPool.invoke(testRecursiveTask));
    }
}

class TestRecursiveAction extends RecursiveAction {

    private final List<Integer> list;

    TestRecursiveAction(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void compute() {
        if (list.size() <= 3) {
            System.out.println(list.stream().map(x -> x * 2).map(String::valueOf).collect(Collectors.joining(",")));
        } else {
            int mid = list.size() / 2;
            List<Integer> firstList = list.subList(0, mid);
            List<Integer> secList = list.subList(mid, list.size());

            TestRecursiveAction t1 = new TestRecursiveAction(firstList);
            TestRecursiveAction t2 = new TestRecursiveAction(secList);


            invokeAll(t1, t2);
        }
    }
}

class TestRecursiveTask extends RecursiveTask<Integer> {
    private final List<Integer> listInt;

    TestRecursiveTask(List<Integer> listInt) {
        this.listInt = listInt;
    }

    @Override
    protected Integer compute() {
        if (listInt.size() <= 3) {
            return listInt.stream().mapToInt(x -> x).sum();
        } else {
            int mid = listInt.size() / 2;
            List<Integer> a = listInt.subList(0, mid);
            List<Integer> b = listInt.subList(mid, listInt.size());

            TestRecursiveTask task1 = new TestRecursiveTask(a);
            TestRecursiveTask task2 = new TestRecursiveTask(b);

            task1.fork();
            task2.fork();

            return task1.join() + task2.join();
        }
    }
}