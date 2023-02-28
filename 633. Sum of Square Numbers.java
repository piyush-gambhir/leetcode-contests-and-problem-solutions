/*
Problem Link: https://leetcode.com/problems/sum-of-square-numbers/
*/

import java.util.*;

class Solution {
    public boolean judgeSquareSum(int c) {

        int sqrt = (int) Math.sqrt(c);
        int i = 0;
        while (i <= sqrt) {
            int j = (int) Math.sqrt(c - i * i);
            if (i * i + j * j == c) {
                return true;
            }
            i++;
        }
        return false;
    }
}