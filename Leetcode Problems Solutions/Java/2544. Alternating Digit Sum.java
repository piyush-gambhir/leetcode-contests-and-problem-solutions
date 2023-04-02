/*
Problem Link: https://leetcode.com/problems/alternating-digit-sum/
*/

class Solution {
    private int reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }

    public int alternateDigitSum(int n) {
        boolean positive = true;
        int sum = 0;

        int reverseNum = reverseNumber(n);
        while (reverseNum > 0) {
            int digit = reverseNum % 10;
            if (positive) {
                sum += digit;
            } else {
                sum -= digit;
            }
            positive = !positive;
            reverseNum /= 10;
        }

        return sum;
    }
}