import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        Map<Integer, Integer> ump = new HashMap<>();

        int ans = 0;
        while (j < n) {
            ump.put(nums[j], ump.getOrDefault(nums[j], 0) + 1);
            if (ump.get(nums[j]) > k) {
                while (i < j && ump.get(nums[j]) > k) {
                    if (ump.get(nums[i]) == 1)
                        ump.remove(nums[i]);
                    else
                        ump.put(nums[i], ump.get(nums[i]) - 1);
                    i++;
                }
            }
            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }
}