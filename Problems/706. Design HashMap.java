/*
Problem Link: https://leetcode.com/problems/design-hashmap/
*/

import java.util.*;

class MyHashMap {

    private class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Pair>[] buckets;
    private int size;

    public MyHashMap() {
        this.size = 10000;
        this.buckets = new List[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % size;
        List<Pair> bucket = buckets[index];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        bucket.add(new Pair(key, value));
    }

    public int get(int key) {
        int index = key % size;
        List<Pair> bucket = buckets[index];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % size;
        List<Pair> bucket = buckets[index];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */