/*
Problem Link: https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
*/

import java.util.*;

class Solution {
    public boolean isGood(String s) {
        if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
            return true;
        }
        return false;
    }

    public String largestGoodInteger(String num) {

        ArrayList<String> gooStrings = new ArrayList<>();

        for (int i = 0; i < num.length() - 2; i++) {
            String temp = num.substring(i, i + 3);
            if (isGood(temp)) {
                gooStrings.add(temp);
            }
        }

        if (gooStrings.size() == 0) {
            return "";
        }

        return Collections.max(gooStrings);
    }
}