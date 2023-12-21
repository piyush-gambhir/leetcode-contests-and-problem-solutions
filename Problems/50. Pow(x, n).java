/*
Problem Link: https://leetcode.com/problems/powx-n/
*/

import java.util.*;

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        if (n == 0) {
            return 1;
        }
        ans = myPow(x, n / 2);

        if (n % 2 == 0) {
            return ans * ans;
        } else {
            if (n > 0) {
                return x * ans * ans;
            } else {
                return (ans * ans) / x;
            }
        }
    }
}