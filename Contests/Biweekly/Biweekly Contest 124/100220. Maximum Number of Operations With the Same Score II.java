import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return 1 + Math.max(
                maxOperationsHelper(2, n - 1, nums[0] + nums[1], nums, dp),
                Math.max(
                        maxOperationsHelper(0, n - 3, nums[n - 1] + nums[n - 2], nums, dp),
                        maxOperationsHelper(1, n - 2, nums[0] + nums[n - 1], nums, dp)));
    }

    private int maxOperationsHelper(int startIndex, int endIndex, int targetSum, int[] arr, int[][] dp) {
        if (startIndex >= endIndex) {
            return 0;
        }

        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }

        int count1 = (startIndex + 1 <= endIndex && arr[startIndex] + arr[startIndex + 1] == targetSum)
                ? 1 + maxOperationsHelper(startIndex + 2, endIndex, targetSum, arr, dp)
                : 0;

        int count2 = (endIndex - 1 >= startIndex && arr[endIndex] + arr[endIndex - 1] == targetSum)
                ? 1 + maxOperationsHelper(startIndex, endIndex - 2, targetSum, arr, dp)
                : 0;

        int count3 = (arr[startIndex] + arr[endIndex] == targetSum)
                ? 1 + maxOperationsHelper(startIndex + 1, endIndex - 1, targetSum, arr, dp)
                : 0;

        return dp[startIndex][endIndex] = Math.max(count1, Math.max(count2, count3));
    }
}
