/*
Problem Link: https://leetcode.com/problems/kth-missing-positive-number/
*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int j = 0;
        while (k > 0) {
            if (j < arr.length && arr[j] == i) {
                j++;
            } else {
                k--;
            }
            i++;
        }
        return i - 1;
    }
}