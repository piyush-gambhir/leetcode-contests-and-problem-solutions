/*
Problem Link: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
*/

import java.util.*;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        suffixSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = i * nums[i] - prefixSum[i];
            int rightSum = suffixSum[i] - (nums.length - i - 1) * nums[i];
            result[i] = leftSum + rightSum;
        }
        
        return result;

    }
}

/*
 * 1. Brute Force Approach
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.abs(nums[i] - nums[j]);
            }
            result[i] = sum;
        }
        return result;
    }
}
