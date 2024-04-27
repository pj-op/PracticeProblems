package com.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyFunctionalClass {

    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = (a, b) -> String.valueOf(a + b);

        BiFunction<Integer, Integer, Integer> testFunction = (a, b) -> a.intValue() * b.intValue();

        System.out.println(myFunctionalInterface.printSomething(4,5));

    }


}
