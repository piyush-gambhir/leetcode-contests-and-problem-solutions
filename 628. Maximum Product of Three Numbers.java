/*
Problem Link: https://leetcode.com/problems/maximum-product-of-three-numbers/
*/

import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(maxProduct1, maxProduct2);
    }
}