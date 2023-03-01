/*
Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
*/

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minimum = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            minimum = Math.min(minimum, nums[mid]);
            if (nums[left] <= nums[mid]) {
                minimum = Math.min(minimum, nums[left]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return minimum;
    }
}