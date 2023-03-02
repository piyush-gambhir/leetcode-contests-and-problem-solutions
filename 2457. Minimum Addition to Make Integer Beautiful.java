/*
Problem Link: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/
*/

class Solution {
    private long getDigitSum(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public long makeIntegerBeautiful(long n, int target) {
        long nCopy = n;
        long beautyNumber = n;
        long digitSum = getDigitSum(nCopy);
        long x = 0;
        long round = 1;

        if (digitSum <= target) {
            return x;
        }

        while (digitSum > target) {
            nCopy /= 10;
            beautyNumber = (long) ((nCopy + 1) * Math.pow(10, round));
            digitSum = getDigitSum(beautyNumber);
            x = beautyNumber - n;
            round++;
        }
        return x;
    }
}