/*
Problem Link: https://leetcode.com/problems/determine-color-of-a-chessboard-square/
*/

class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '1';

        if ((x + y) % 2 == 0) {
            return false;
        }
        return true;
    }
}