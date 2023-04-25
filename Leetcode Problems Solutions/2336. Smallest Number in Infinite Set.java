/*
Problem Link: https://leetcode.com/problems/smallest-number-in-infinite-set/   
*/

import java.util.*;

class SmallestInfiniteSet {
    static PriorityQueue<Integer> pq;
    static int current;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        current = 1;
    }

    public int popSmallest() {
        if (pq.isEmpty()) {
            int temp = current;
            current++;
            return temp;
        } else {
            return pq.poll();
        }
    }

    public void addBack(int num) {
        if (current > num && !pq.contains(num)) {
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */