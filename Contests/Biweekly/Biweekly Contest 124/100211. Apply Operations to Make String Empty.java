import java.util.*;

class Solution {
    public String lastNonEmptyString(String s) {
        int[] charFrequency = new int[26];
        int maxFrequency = 0;

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            charFrequency[index]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[index]);
        }

        char[] result = new char[s.length()];
        int resultIndex = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (charFrequency[index] == maxFrequency) {
                charFrequency[index] = -1;
                result[resultIndex++] = ch;
            }
        }
        StringBuilder reversed = new StringBuilder(new String(result, 0, resultIndex));
        return reversed.reverse().toString();
    }
}
