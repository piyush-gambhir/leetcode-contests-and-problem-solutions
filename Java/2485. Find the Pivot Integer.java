/*
Problem Link: https://leetcode.com/problems/find-the-pivot-integer/
*/

class Solution {
    public int pivotInteger(int n) {

        int[] digits = new int[n];

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i <= n; i++) {
            digits[i - 1] = i;
            rightSum += i;
        }

        for (int i = 0; i < n; i++) {
            rightSum -= digits[i];
            if (leftSum == rightSum) {
                return digits[i];
            }
            leftSum += digits[i];
        }
        return -1;
    }
}