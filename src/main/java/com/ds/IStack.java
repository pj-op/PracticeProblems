package com.ds;

public interface IStack {
    int pop();

    int size();

    int peek();

    void preview();

    boolean isEmpty();

    void push(int data);
}
