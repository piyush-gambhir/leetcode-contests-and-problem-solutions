/*
Problem Link: https://leetcode.com/problems/calculate-money-in-leetcode-bank/
*/

import java.util.*;

class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int week = 0;
        int day = 0;
        int money = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                week++;
                day = 1;
                money = week;
            } else {
                day++;
                money++;
            }
            sum += money;
        }
        return sum;
    }
}