/*
Problem Link: https://leetcode.com/problems/valid-triangle-number/
*/

import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = n - 1; i >= 2; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    ans += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}