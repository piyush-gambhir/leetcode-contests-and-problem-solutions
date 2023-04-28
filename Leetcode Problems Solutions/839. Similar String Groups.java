/*
Problem Link: https://leetcode.com/problems/similar-string-groups/
*/

import java.util.*;

class Solution {
    private boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m)
            return false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    ans++;
                    break;
                }
            }
        }
        return n - ans;
    }
}