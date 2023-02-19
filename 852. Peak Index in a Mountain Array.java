/*
Problem Link: https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }

        int peak = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[peak]) {
                peak = i;
            }
        }
        return peak;

    }
}