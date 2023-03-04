/*
Problem Link: https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
*/

/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
*/

import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int bad = -1, mi = -1, ma = -1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < minK || n > maxK) {
                bad = i;
            }
            if (n == minK) {
                mi = i;
            }
            if (n == maxK) {
                ma = i;
            }
            int start = Math.min(mi, ma);
            if (start > bad) {
                res += (start - bad);
            }
        }
        return res;
    }
}
