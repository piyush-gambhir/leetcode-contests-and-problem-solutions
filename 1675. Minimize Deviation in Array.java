/*
Problem Link: https://leetcode.com/problems/minimize-deviation-in-array/
*/

import java.util.*;

class Solution {
    public int minimumDeviation(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
            pq.add(nums[i]);
            min = Math.min(min, nums[i]);
        }
        int res = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            int cur = pq.poll();
            res = Math.min(res, cur - min);
            if (cur % 2 == 1) {
                break;
            }
            min = Math.min(min, cur / 2);
            pq.add(cur / 2);
        }
        return res;
    }
}