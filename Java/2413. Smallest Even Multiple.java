/*
 * Problem Link: https://leetcode.com/problems/smallest-even-multiple/
 */

class Solution {
    public int smallestEvenMultiple(int n) {
        if (n == 1 && n == 2) {
            return 2;
        }
        if (n % 2 == 0) {
            return n;
        } else {
            return n * 2;
        }
    }
}