/*
Problem Link: https://leetcode.com/problems/repeated-substring-pattern/
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                int j = i;
                while (j < n) {
                    if (!s.substring(j, j + i).equals(sub)) {
                        break;
                    }
                    j += i;
                }
                if (j == n) {
                    return true;
                }
            }
        }
        return false;
    }
}