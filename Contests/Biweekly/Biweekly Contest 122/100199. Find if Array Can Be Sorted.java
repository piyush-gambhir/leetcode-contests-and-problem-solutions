class Solution {
    public boolean canSortArray(int[] nums) {
        int[] bitCounts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bitCounts[i] = Integer.bitCount(nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            for (int k = 0; k < nums.length - 1; k++) {
                if (bitCounts[k] == bitCounts[k + 1] && nums[k] > nums[k + 1]) {
                    int temp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = temp;
                }
            }
            if (isSorted(nums)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
