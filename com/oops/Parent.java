package com.oops;

 class Child extends Parent {
    public  Integer m1(int a, int b) {
        return a - b;
    }
}

public class Parent {
    public Object m1(int a, int b) {
        System.out.println("Parent");
        return a + b;
    }

    public static void main(String[] args) {
        Parent p1 = new Child();
        System.out.println(p1.m1(10, 20));
    }
}


