/*
Problem Link: https://leetcode.com/problems/4sum/
*/

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1;
                int d = nums.length - 1;
                while (c < d) {
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        quadruplets.add(temp);
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        c++;
                        d--;

                    } else if (sum > target) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }
        return quadruplets;
    }
}