package com.concepts;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if (list.contains(key)) {
            new MyHashSet().remove(key);
        } else {
            list.add(key);
        }
    }

    public void remove(int key) {
        if (list.contains(key)) {
            list.remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
        System.out.println(myHashSet.list);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */