/*
Problem Link: https://leetcode.com/problems/to-lower-case/
*/

class Solution {
    public String toLowerCase(String s) {
        String updatedString = "";
        if (s.length() == 0)
            return updatedString;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                updatedString += (char) (s.charAt(i) + 32);
            } else {
                updatedString += s.charAt(i);
            }
        }
        return updatedString;
    }
}