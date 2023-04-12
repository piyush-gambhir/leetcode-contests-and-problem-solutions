/*
Problem Link: https://leetcode.com/problems/range-sum-query-immutable/
*/

import java.util.*;

class NumArray {

    int[] arr;

    public NumArray(int[] nums) {
        arr = Arrays.copyOf(nums, nums.length);

    }

    public int sumRange(int left, int right) {
        int sum = 0;
        while (left <= right) {
            sum += arr[left];
            left++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */