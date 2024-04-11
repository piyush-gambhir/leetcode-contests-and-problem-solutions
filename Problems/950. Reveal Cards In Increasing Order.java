/*
Problem Link: https://leetcode.com/problems/reveal-cards-in-increasing-order/
*/

import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            queue.add(i);
        int[] result = new int[n];
        for (int card : deck) {
            result[queue.poll()] = card;
            if (!queue.isEmpty())
                queue.add(queue.poll());
        }
        return result;
    }
}