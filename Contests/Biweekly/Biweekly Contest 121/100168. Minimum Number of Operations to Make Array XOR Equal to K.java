import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(new int[] { x, 0 });
        seen.add(x);

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int val = pair[0];
            int ops = pair[1];

            if (val == y) {
                return ops;
            }

            if (!seen.contains(val + 1)) {
                queue.add(new int[] { val + 1, ops + 1 });
                seen.add(val + 1);
            }

            if (!seen.contains(val - 1)) {
                queue.add(new int[] { val - 1, ops + 1 });
                seen.add(val - 1);
            }

            if (val % 5 == 0 && !seen.contains(val / 5)) {
                queue.add(new int[] { val / 5, ops + 1 });
                seen.add(val / 5);
            }

            if (val % 11 == 0 && !seen.contains(val / 11)) {
                queue.add(new int[] { val / 11, ops + 1 });
                seen.add(val / 11);
            }
        }

        return -1;
    }
}
