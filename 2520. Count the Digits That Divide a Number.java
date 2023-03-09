/*
Problem Link: https://leetcode.com/problems/count-the-digits-that-divide-a-number/
*/

class Solution {
    public int countDigits(int num) {
        int numCopy = num;

        int count = 0;

        while (numCopy > 0) {
            int digit = numCopy % 10;
            if (digit != 0 && num % digit == 0) {
                count++;
            }
            numCopy /= 10;
        }
        return count;
    }
}