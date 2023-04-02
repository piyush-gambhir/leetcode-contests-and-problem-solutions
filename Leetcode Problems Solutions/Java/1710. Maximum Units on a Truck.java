/*
Problem Link: https://leetcode.com/problems/maximum-units-on-a-truck/
*/

import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] box : boxTypes) {
            int count = Math.min(truckSize, box[0]);
            ans += count * box[1];
            truckSize -= count;
            if (truckSize == 0)
                break;
        }
        return ans;
    }
}