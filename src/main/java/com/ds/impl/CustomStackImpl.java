package com.ds.impl;

import com.ds.IStack;
import com.ds.Node;

import java.util.EmptyStackException;

public class CustomStackImpl implements IStack {

    Node top;
    int size = 0;

    @Override
    public int pop() {
        if (isEmpty()) {throw new EmptyStackException();}
        int poppedNodeData = top.getData();
        top = top.getNext();
        size--;
        return poppedNodeData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int peek() {
        if (isEmpty()) {throw new EmptyStackException();}
        return top.getData();
    }

    @Override
    public void preview() {
        Node currentNode = top;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
}
