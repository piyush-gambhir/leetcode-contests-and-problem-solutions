import java.util.*;

class Solution {
    public int maxOperations(int[] nums) {
        int operationCount = 1;
        int targetSum = nums[0] + nums[1];
        for (int i = 2; i < nums.length - 1;) {
            if (nums[i] + nums[i + 1] == targetSum) {
                operationCount++;
                i += 2;
            } else {
                break;
            }
        }
        return operationCount;
    }
}