package com.concepts;

import jsonpractice.LoadJsonData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    static {
        List<EmpData> empData = new LoadJsonData().prepareEmpList();
    }

    public static void main(String[] args) throws Exception {
        /*
        Thread t1 = new Thread(() -> IntStream.rangeClosed(100, 200).forEach(System.out::println));
        Thread t2 = new Thread(() -> IntStream.rangeClosed(0, 20).forEach(System.out::println));
        t1.start();
        t2.start();
         */

        /*
        String s = IntStream.rangeClosed(2, 100)
                .filter(x -> IntStream.rangeClosed(2, x / 2).noneMatch(y -> x % y == 0))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(s);
        */

        //Generate Fibonacci using streams
        /*Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(5)
                .map(x -> x[0])
                .forEach(
//                        i-> System.out.println(Arrays.toString(i))
                        System.out::println
                );*/

        /*
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Carrot", "Berry");
        var collect = fruits.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        fruits.stream()
                .distinct()
                .filter(element -> fruits.indexOf(element) != fruits.lastIndexOf(element))
                .forEach(System.out::println);

        Set<String> fruitsSet = new HashSet<>();
        fruits.stream()
                .filter(f -> !fruitsSet.add(f))
                .forEach(System.out::println);
        */

        /*String s = Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[1] + array[0]})
                .limit(30)
                .map(x -> x[0])
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(s);*/

        /*String str = "This is Pranjal Soni from Sagar madhya pradesh";
        String x = Arrays.stream(str.split(" "))
                .max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println(x);*/

        //Creating freqmap using Streams
        /*int[] arr = {1, 2, 2, 2, 4, 3, 4, 4, 8, 9, 9, 9, 9, 9, 9};
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.stream(arr).forEach(i -> freqMap.put(i, freqMap.getOrDefault(i, 0) + 1));

        Map.Entry<Integer, Long> entry = Collections.max(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet(), Map.Entry.comparingByValue());

        System.out.println(entry.getKey());*/

        /*var calculation = empData.stream()
                .mapToInt(EmpData::getSalary)
                .average();
                .sum();*/

        /*var eSet = empData.stream()
                .collect(Collectors.groupingBy(EmpData::getGender, Collectors.averagingDouble(EmpData::getSalary)));*/

        /*String s1 = "this is pranjal soni";
        String ans = Arrays.stream(s1.split(" "))
                .max(Comparator.comparing(String::length)).orElse(null);
        System.out.println(ans);
        */

        /*empData.stream()
                .filter(empData1 -> empData1.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDate.now().minusYears(2L)))
                .sorted(Comparator.comparing(EmpData::getFirstName))
                .forEach(System.out::println);*/

        /*Stream.iterate(new int[]{0, 1}, x -> new int[]{x[0] + x[1], x[0]})
                .map(y -> y[0])
                .limit(10)
                .forEach(System.out::println);*/

        /*Stream.iterate(new LocalDate[]{LocalDate.now().minusMonths(1L), LocalDate.now()}, arr -> new LocalDate[]{arr[1], arr[1].minusMonths(1L)})
                .limit(5)
                .forEach(arr -> System.out.println(arr[0] + " == " + arr[1]));*/

        /*Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[1] + arr[0]})
                .limit(50)
                .map(x -> x[0])
                .skip(3)
                .filter(a -> IntStream.rangeClosed(2, a / 2).noneMatch(b -> a % b == 0))
                .forEach(System.out::println);*/

        /*int[] a = {1, 1, 2, 2, 4, 6, 7, 8, 8, 9, 9, 9, 5, 9, 3};

        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;

        for (int ele : a) {
            maxEle = Math.max(maxEle, ele);
            minEle = Math.min(minEle, ele);
        }

        int[] freqArray = new int[maxEle - minEle + 1];
        for (int ele : a) freqArray[ele - minEle]++;

        int maxFreq = -1;
        int ansElement = -1;
        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > maxFreq) {
                maxFreq = freqArray[i];
                ansElement = i;
            }
        }
        System.out.println(maxFreq + " -- " + (ansElement + minEle));

        Map<Integer, Long> freqMap = new HashMap<>();
        IntStream.range(0, a.length).forEach(i -> freqMap.put(a[i], freqMap.getOrDefault(a[i], 0L) + 1));

        System.out.println(freqMap);

        Map.Entry<Integer, Long> ans = Collections.max(Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet(), Map.Entry.comparingByValue());

        System.out.println(ans);*/

    }
}