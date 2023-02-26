/*
Problem Link: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
*/

class Solution {
    public String freqAlphabets(String s) {
        String updatedString = "";
        if (s.length() == 0)
            return updatedString;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                updatedString += (char) (Integer.parseInt(s.substring(i, i + 2)) + 96);
                i += 2;
            } else {
                updatedString += (char) (Integer.parseInt(s.substring(i, i + 1)) + 96);
            }
        }
        return updatedString;
    }
}