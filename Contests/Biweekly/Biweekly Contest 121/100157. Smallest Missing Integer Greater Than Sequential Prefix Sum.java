class Solution {
    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                prefixSum += nums[i];
            } else {
                break;
            }
        }

        int missingInteger = prefixSum;

        while (doesContain(nums, missingInteger)) {
            missingInteger++;
        }

        return missingInteger;
    }

    private static boolean doesContain(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}