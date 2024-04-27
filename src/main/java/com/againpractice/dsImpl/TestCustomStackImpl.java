package com.againpractice.dsImpl;

public class TestCustomStackImpl {
    public static void main(String[] args) {
        StackInterface stack = new StackInterfaceImpl();

        stack.push(8);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(90);
        System.out.println(stack.pop());

        System.out.println(stack.size());
        stack.preview();

    }
}
