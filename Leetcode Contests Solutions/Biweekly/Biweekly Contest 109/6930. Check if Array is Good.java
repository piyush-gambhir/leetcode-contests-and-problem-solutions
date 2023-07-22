/*
Problem Link: 
*/

import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int max_num = 0;
        for (int num : nums) {
            max_num = Math.max(max_num, num);
        }
        
        int countMax = 0;
        for (int num : nums) {
            if (num == max_num) countMax++;
        }
        if (countMax != 2) return false;
        
        for (int i = 1; i < max_num; i++) {
            int count = 0;
            for (int num : nums) {
                if (num == i) count++;
            }
            if (count != 1) return false;
        }
        
        return nums.length == max_num + 1;
    }
}
