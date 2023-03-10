/*
Problem Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal/
*/

class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }

        int minimumOperations = 0;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            minimumOperations += (arr[right] - arr[left]) / 2;
            left++;
            right--;
        }

        return minimumOperations;
    }
}