package com.againpractice.dsImpl;

import java.util.EmptyStackException;

public class StackInterfaceImpl implements StackInterface {

    int size = 0;
    StackNode top = null;

    @Override
    public void preview() {
        StackNode currNode = top;
        while (currNode!= null) {
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNextNode();
        }

    }

    @Override
    public void push(int data) {
        StackNode node = new StackNode(data);
        node.setNextNode(top);
        top = node;
        size++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppingNodeData = top.getData();
        top = top.getNextNode();
        size--;
        return poppingNodeData;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
