/*
Problem Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScorePossible = 0;

        for (int i = 0; i < k; i++) {
            maxScorePossible += cardPoints[i];
        }
    }
}