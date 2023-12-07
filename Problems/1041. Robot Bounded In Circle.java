/*
Problem Link: https://leetcode.com/problems/robot-bounded-in-circle/
*/

import java.util.*;

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                x += dirs[dir][0];
                y += dirs[dir][1];
            } else if (ch == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || dir != 0;
    }
}