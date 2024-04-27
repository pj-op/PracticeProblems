package com.againpractice.dsImpl;

public class StackNode {
    private int data;
    private StackNode nextNode;

    public StackNode(int data){
        this.data = data;
        this.nextNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public StackNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                ", nextNode=" + nextNode +
                '}';
    }
}
