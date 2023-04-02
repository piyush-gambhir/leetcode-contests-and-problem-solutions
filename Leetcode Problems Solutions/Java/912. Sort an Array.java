/*
Problem Link: https://leetcode.com/problems/sort-an-array/
*/

class Solution {
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    private static int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start] };
        }
        int mid = (start + end) / 2;
        int[] left = mergeSort(nums, start, mid);
        int[] right = mergeSort(nums, mid + 1, end);
        return merge(left, right);
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}