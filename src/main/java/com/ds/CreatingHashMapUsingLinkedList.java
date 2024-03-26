package com.ds;

import java.util.LinkedList;
import java.util.List;

public class CreatingHashMapUsingLinkedList {

    List<CustomEntry> myMap;

    public CreatingHashMapUsingLinkedList() {
        myMap = new LinkedList<>();
    }

    public void put(int key, int value) {
        CustomEntry customEntry = new CustomEntry(key, value);
        if (myMap.contains(customEntry)) {
            myMap.remove(customEntry);
        }
        myMap.add(new CustomEntry(key, value));
    }

    public int get(int key) {
        CustomEntry res = myMap.stream().filter(element -> key == element.getKey()).findFirst().orElse(new CustomEntry(-1, -1));
        return res.getValue();
    }

    public void remove(int key) {
        myMap.removeIf(customEntry -> customEntry.getKey() == key);
    }
}


class CustomEntry {
    int key;
    int value;

    CustomEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomEntry that = (CustomEntry) o;

        return key == that.key;
    }

    @Override
    public int hashCode() {
        return key;
    }

    @Override
    public String toString() {
        return "CustomEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}