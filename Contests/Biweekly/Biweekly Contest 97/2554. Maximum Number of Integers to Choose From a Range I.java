/*
Problem Link: https://leetcode.com/contest/biweekly-contest-97/problems/maximum-number-of-integers-to-choose-from-a-range-i/
*/

import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                sum += i;
                count++;
                if (sum == maxSum) {
                    return count;
                }

                if (sum > maxSum) {
                    return count - 1;
                }
            }
        }
        return count;
    }
}