/*
Problem Link: https://leetcode.com/problems/score-of-a-string/ 
*/

class Solution {
    public int scoreOfString(String s) {

        char[] charArray = s.toCharArray();
        int score = 0;
        for (int i = 1; i < charArray.length; i++) {
            score += Math.abs(charArray[i] - charArray[i - 1]);

        }
        return score;
    }
}