/*
Problem Link: https://leetcode.com/problems/longest-cycle-in-a-graph/
*/

import java.util.*;

class Solution {

    public int longestCycle(int[] edges) {

        int longestCycleLength = -1;
        int timeStep = 1;
        int[] nodeVisitedAtTime = new int[edges.length];

        for (int currentNode = 0; currentNode < edges.length; ++currentNode) {
            if (nodeVisitedAtTime[currentNode] > 0)
                continue;
            final int startTime = timeStep;
            int u = currentNode;
            while (u != -1 && nodeVisitedAtTime[u] == 0) {
                nodeVisitedAtTime[u] = timeStep++;
                u = edges[u];
            }
            if (u != -1 && nodeVisitedAtTime[u] >= startTime)
                longestCycleLength = Math.max(longestCycleLength, timeStep - nodeVisitedAtTime[u]);
        }

        return longestCycleLength;
    }
}
