/*
Problem Link: 
*/

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        
        Collections.sort(vowels);
        
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.remove(0));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
