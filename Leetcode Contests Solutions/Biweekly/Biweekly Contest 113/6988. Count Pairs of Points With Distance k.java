import java.util.HashMap;
import java.util.List;

public class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;

        // Loop to populate the hash map with frequencies of XOR combinations.
        for (List<Integer> point : coordinates) {
            int x = point.get(0);
            int y = point.get(1);
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
            hashMap.put(y, hashMap.getOrDefault(y, 0) + 1);
        }

        // Loop to find the pairs
        for (int i = 0; i < coordinates.size(); i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                int x1 = coordinates.get(i).get(0);
                int y1 = coordinates.get(i).get(1);
                int x2 = coordinates.get(j).get(0);
                int y2 = coordinates.get(j).get(1);

                int distance = (x1 ^ x2) + (y1 ^ y2);
                if (distance == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
