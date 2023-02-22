/*
Problem Link: https://leetcode.com/problems/check-if-it-is-a-straight-line/
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][1] - coordinates[i - 1][1])
                    * (coordinates[i - 1][0] - coordinates[i - 2][0]) != (coordinates[i - 1][1] - coordinates[i - 2][1])
                            * (coordinates[i][0] - coordinates[i - 1][0])) {
                return false;
            }
        }
        return true;
    }
}