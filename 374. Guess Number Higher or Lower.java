/*
Problem Link: https://leetcode.com/problems/guess-number-higher-or-lower/
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

import java.util.*;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int pickedNumber = 0;

        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                pickedNumber = mid;
                break;
            } else if (guessResult == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return pickedNumber;
    }
}