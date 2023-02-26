/*
Problem Link: https://leetcode.com/problems/student-attendance-record-i/
*/

class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countLC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                countLC = 0;
            } else if (s.charAt(i) == 'L') {
                countLC++;
            } else {
                countLC = 0;
            }
            if (countA > 1 || countLC > 2) {
                return false;
            }
        }
        return true;
    }
}