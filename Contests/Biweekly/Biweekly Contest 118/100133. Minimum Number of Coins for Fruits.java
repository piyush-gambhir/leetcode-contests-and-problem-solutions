import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxSequenceLength = Math.min(calculateMaxSequenceLength(hBars), calculateMaxSequenceLength(vBars));
        return maxSequenceLength * maxSequenceLength;
    }

    private int calculateMaxSequenceLength(int[] nums) {
        int maxLength = 0, currentLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1)
                currentLength++;
            else
                currentLength = 0;
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength + 1;
    }
}
