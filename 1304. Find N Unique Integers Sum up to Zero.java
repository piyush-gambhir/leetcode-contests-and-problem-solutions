/*
Problem Link: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
*/

class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int i = 0;
        if (n % 2 != 0) {
            arr[i++] = 0;
        }
        for (int j = 1; j <= n / 2; j++) {
            arr[i++] = j;
            arr[i++] = -j;
        }
        return arr;
    }
}