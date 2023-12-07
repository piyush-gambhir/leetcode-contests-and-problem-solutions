import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxHConsucutive = 0;
        int maxVConsuctive = 0;

        int len = hBars.length;

        if (len != 0)
            maxHConsucutive = 1;

        int lent = vBars.length;

        if (lent != 0)
            maxVConsuctive = 1;

        int count = 1;

        int h = n + 2;
        int v = m + 2;

        for (int i = 0; i < len - 1; i++) {

            int inc = hBars[i] + 1;
            if (hBars[i + 1] == inc) {
                count++;
                if (count > maxHConsucutive) {
                    maxHConsucutive = count;
                }
            } else {
                count = 1;
            }
        }

        count = 1;
        for (int i = 0; i < lent - 1; i++) {

            int inc = vBars[i] + 1;
            if (vBars[i + 1] == inc) {
                count++;
                if (count > maxVConsuctive) {
                    maxVConsuctive = count;
                }
            } else {
                count = 1;
            }
        }

        int ans = 1;

        if (maxVConsuctive > 0)
            maxVConsuctive++;
        if (maxHConsucutive > 0)
            maxHConsucutive++;

        if (maxVConsuctive < maxHConsucutive) {
            ans = maxVConsuctive;
        } else {
            ans = maxHConsucutive;
        }

        if (maxVConsuctive > 0 && maxHConsucutive > 0) {
            return ans * ans;
        } else if (maxVConsuctive > 0 && maxHConsucutive == 0) {

            if (len == 1) {
                return 4;
            } else {
                return 1;
            }
        } else if (maxVConsuctive == 0 && maxHConsucutive > 0) {

            if (lent == 1) {
                return 4;
            } else {
                return 1;
            }

        } else {
            return 1;
        }
    }
}