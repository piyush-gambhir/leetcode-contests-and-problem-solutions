import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int key : freq.keySet()) {
            pq.offer(freq.get(key));
        }
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first > 1) {
                pq.offer(first - 2);
            }
            if (second > 1) {
                pq.offer(second - 2);
            }
            ans += 2;
        }
        if (pq.size() == 1 && pq.poll() > 1) {
            ans += 3;
        }
        return pq.size() == 0 ? ans : -1;
    }
}
