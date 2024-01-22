import java.util.*;

class Solution {
    public int minimumCost(int[] nums) {
        int length = nums.length;
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                minCost = Math.min(minCost, nums[0] + nums[i] + nums[j]);
            }
        }
        return minCost;
    }
}
