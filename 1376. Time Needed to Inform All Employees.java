/*
Problem Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/
*/

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> subordinates = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != headID) {
                int managerId = manager[i];
                if (!subordinates.containsKey(managerId)) {
                    subordinates.put(managerId, new ArrayList<>());
                }
                subordinates.get(managerId).add(i);
            }
        }
        return informSubordinates(headID, subordinates, informTime);
    }

    private int informSubordinates(int employeeId, Map<Integer, List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        if (subordinates.containsKey(employeeId)) {
            for (int subordinateId : subordinates.get(employeeId)) {
                int time = informSubordinates(subordinateId, subordinates, informTime);
                maxTime = Math.max(maxTime, time);
            }
        }
        maxTime += informTime[employeeId];
        return maxTime;
    }
}