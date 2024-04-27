package com.ds;

import com.ds.impl.CustomStackImpl;

public class TestCustomStack {
    public static void main(String[] args) {

        CustomStackImpl customStack = new CustomStackImpl();

        customStack.push(2);
        customStack.push(4);
        customStack.push(12);
        customStack.push(89);

//        customStack.pop();
//        customStack.pop();
//        customStack.pop();
//        customStack.pop();

        System.out.println("Size: "+customStack.size());
        customStack.preview();
        System.out.println("Pop: "+customStack.pop());
        System.out.println("Peek: "+customStack.peek());
        System.out.println("Size: "+customStack.size());
    }
}
