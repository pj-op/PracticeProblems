package com.new_problems;

public class SealedClassTest {
    public static void main(String[] args) {
        Shape shape = new Square();
        System.out.println(shape.commonMethod("Greetings!!"));
    }
}
