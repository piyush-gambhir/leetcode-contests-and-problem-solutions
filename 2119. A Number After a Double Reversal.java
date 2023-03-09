/*
Problem Link: https://leetcode.com/problems/a-number-after-a-double-reversal/
*/

class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num < 10) {
            return true;
        }

        if (num % 10 == 0) {
            return false;
        }

        return true;
    }
}