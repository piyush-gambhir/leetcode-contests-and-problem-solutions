/*
Problem Link: https://leetcode.com/problems/build-an-array-with-stack-operations/ 
*/

import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j == target.length) {
                break;
            }
            if (target[j] == i) {
                ans.add("Push");
                j++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}