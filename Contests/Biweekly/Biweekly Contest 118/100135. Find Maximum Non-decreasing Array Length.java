class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = (nums[1] >= nums[0]) ? 2 : 1;

        for (int i = 2; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Math.max(1, dp[i - 2] + 1);
            }
        }

        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}