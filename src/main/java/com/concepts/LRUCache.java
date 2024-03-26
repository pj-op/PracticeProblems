package com.concepts;

        /*Implement the LRUCache class:

        LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        int get(int key) Return the value of the key if the key exists, otherwise return -1.
        void put(int key, int value) Update the value of the key if the key exists.
        Otherwise, add the key-value pair to the cache.
        If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        The functions get and put must each run in O(1) average time complexity.
        */

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> lruMap = null;

    public LRUCache(int capacity) {
        lruMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        return lruMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

        lruMap.put(key, value);
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */