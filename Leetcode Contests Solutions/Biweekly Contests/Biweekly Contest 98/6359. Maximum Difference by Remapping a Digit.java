/*
Problem Link: https://leetcode.com/contest/biweekly-contest-98/problems/maximum-difference-by-remapping-a-digit/
*/

class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int max = num;
        int min = num;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String t = s.replace((char) (i + '0'), (char) (j + '0'));
                int n = Integer.parseInt(t);
                if (t.length() == s.length() && n > max) {
                    max = n;
                }
                if (t.length() == s.length() && n < min) {
                    min = n;
                }
            }
        }
        return max - min;
    }
}