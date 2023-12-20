
/*
Problem Link: https://leetcode.com/contest/biweekly-contest-119/problems/length-of-longest-subarray-with-at-most-k-frequency/
*/
import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (map.get(nums[j]) > k) {
                while (i < j && map.get(nums[j]) > k) {
                    if (map.get(nums[i]) == 1)
                        map.remove(nums[i]);
                    else
                        map.put(nums[i], map.get(nums[i]) - 1);
                    i++;
                }
            }
            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }
}