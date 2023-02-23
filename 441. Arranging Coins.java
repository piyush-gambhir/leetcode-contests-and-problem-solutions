/*
Problem Link: https://leetcode.com/problems/arranging-coins/
*/

class Solution {
    public int arrangeCoins(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }
}