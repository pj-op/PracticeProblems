package com.concepts.functionalinterface;

@FunctionalInterface
interface GreetFunctionalInterface {
    String printGreetMessage();

    private static void p1() {

    }

    private void p2() {

    }

    default void m1() {
        System.out.println("this is default method");
    }

    default void m2() {
        System.out.println("this is default method");
    }

    static void util() {
        System.out.println("this is util static method of interface");
    }

    static void util1() {
        System.out.println("this is util static method of interface");
    }
}

public class GreetFunctionalClass {
    public static void main(String[] args) {

        GreetFunctionalInterface impl1 = () -> "Greeting hello!!";
        GreetFunctionalInterface impl2 = () -> "Hi! Good Morning";
        GreetFunctionalInterface impl3 = () -> "hi How are you?";

        System.out.println(impl1.printGreetMessage());
        System.out.println(impl2.printGreetMessage());
        System.out.println(impl3.printGreetMessage());
    }
}
