/*
Problem Link: https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
*/

import java.util.*;

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = m - 1;
            int idx = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums1[i] <= nums2[mid]) {
                    idx = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (idx != -1) {
                ans = Math.max(ans, idx - i);
            }
        }
        return ans;
    }
}