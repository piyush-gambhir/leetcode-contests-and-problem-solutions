/*
Problem Link: https://leetcode.com/problems/count-numbers-with-even-digits/
*/

import java.util.*;

class Solution {

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        return sum;
    }

    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (digitSum(i) % 2 == 0)
                count++;
        }
        return count;
    }
}