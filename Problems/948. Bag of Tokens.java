/*
Problem Link: https://leetcode.com/problems/bag-of-tokens/
 */

import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0)
            return 0;
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}