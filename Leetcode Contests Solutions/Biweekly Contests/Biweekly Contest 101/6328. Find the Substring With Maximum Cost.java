import java.util.*;

class Solution {
    public int maxSubstringCost(String s, String chars, int[] vals) {
        Map<Character, Integer> valMap = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < chars.length(); i++) {
            valMap.put(chars.charAt(i), vals[i]);
            maxVal = Math.max(maxVal, vals[i]);
        }
        int[] prefixSum = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cost = valMap.getOrDefault(c, c - 'a' + 1);
            prefixSum[i + 1] = prefixSum[i] + cost;
        }
        int maxCost = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                int cost = prefixSum[j] - prefixSum[i];
                maxCost = Math.max(maxCost, cost);
            }
        }
        return maxCost;
    }
}
