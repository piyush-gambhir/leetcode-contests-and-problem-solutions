/*
Problem Link: https://leetcode.com/problems/count-largest-group/
*/

import java.util.*;

class Solution {
    private int digitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {

        int max = Integer.MIN_VALUE;
        int count = 0;
        int[] digitsSum = new int[37];

        for (int i = 1; i <= n; i++) {
            int sum = digitsSum(i);
            digitsSum[sum]++;
            if (digitsSum[sum] > max) {
                max = digitsSum[sum];
            }
        }

        for (int i = 0; i < digitsSum.length; i++) {
            if (digitsSum[i] == max) {
                count++;
            }
        }
        return count;
    }
}