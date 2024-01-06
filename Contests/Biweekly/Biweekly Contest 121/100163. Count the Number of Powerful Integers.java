import java.util.Arrays;

class Solution {
    private long countPowerfulIntegers(int level, int isStartInclusive, int isFinishInclusive, String start,
            String finish, String S, int limit, int length,
            long[][][] dp) {
        if (level == finish.length()) {
            return 1;
        }
        if (dp[level][isStartInclusive][isFinishInclusive] != -1) {
            return dp[level][isStartInclusive][isFinishInclusive];
        }
        long count = 0;
        int startDigit = isStartInclusive != 0 ? start.charAt(level) - '0' : 0;
        int finishDigit = isFinishInclusive != 0 ? Math.min(limit, finish.charAt(level) - '0') : limit;

        for (int i = startDigit; i <= finishDigit; i++) {
            int newStartInclusive = i != (start.charAt(level) - '0') ? 0 : isStartInclusive;
            int newFinishInclusive = i != (finish.charAt(level) - '0') ? 0 : isFinishInclusive;

            if (level < length) {
                count += countPowerfulIntegers(level + 1, newStartInclusive, newFinishInclusive, start, finish, S,
                        limit, length, dp);
            } else {
                if ((S.charAt(level - length) - '0') == i) {
                    count += countPowerfulIntegers(level + 1, newStartInclusive, newFinishInclusive, start, finish, S,
                            limit, length, dp);
                }
            }
        }
        return dp[level][isStartInclusive][isFinishInclusive] = count;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = String.valueOf(start);
        String finishStr = String.valueOf(finish);
        String temp = "0".repeat(Math.max(0, finishStr.length() - startStr.length()));
        startStr = temp + startStr;
        long[][][] dp = new long[16][2][2];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int lim = limit;
        int length = finishStr.length() - s.length();
        return countPowerfulIntegers(0, 1, 1, startStr, finishStr, s, lim, length, dp);
    }
}