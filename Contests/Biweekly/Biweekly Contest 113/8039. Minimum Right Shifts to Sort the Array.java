import java.util.List;

public class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) < minVal) {
                minVal = nums.get(i);
                minIndex = i;
            }
        }


        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;

        for (int i = 1; i < n; i++) {
            if (nums.get((minIndex + i) % n) < nums.get((minIndex + i - 1) % n)) {
                return -1;
            }
        }

        return n - minIndex;
    }
}
