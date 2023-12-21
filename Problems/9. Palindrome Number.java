/*
Problem Link: https://leetcode.com/problems/palindrome-number/
*/

class Solution {
    public boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        int i = 0, j = xString.length() - 1;
        while (i < j) {
            if (xString.charAt(i) != xString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}