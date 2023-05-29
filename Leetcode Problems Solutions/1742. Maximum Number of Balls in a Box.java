/*
Problem Link: https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
*/

import java.util.*;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] box = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            box[sum]++;
            max = Math.max(max, box[sum]);
        }
        return max;
    }
}