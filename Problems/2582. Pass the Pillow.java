/*
Problem Link: https://leetcode.com/problems/pass-the-pillow/
*/

class Solution {
    public int passThePillow(int n, int time) {
        int effectiveTime = time % (2 * (n - 1));
        int position = 1;
        boolean forward = true;

        while (effectiveTime > 0) {
            if (forward) {
                if (position == n) {
                    forward = false;
                    position--;
                } else {
                    position++;
                }
            } else {
                if (position == 1) {
                    forward = true;
                    position++;
                } else {
                    position--;
                }
            }
            effectiveTime--;
        }
        return position;
    }
}
