/*
Problem Link: https://leetcode.com/problems/categorize-box-according-to-criteria/
*/

class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        int volume = length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 1000 || volume >= 1000000000) {
            if (mass >= 100) {
                return "Both";
            } else {
                return "Bulky";
            }
        } else if (mass >= 100) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}

// class Solution {
// private boolean isBulky(int length, int width, int height) {
// return length >= 10000 || width >= 10000 || height >= 10000 || (length *
// width * height) >= 1000000000;
// }

// private boolean isHeavy(int mass) {
// return mass >= 100;
// }

// public String categorizeBox(int length, int width, int height, int mass) {
// if (isBulky(length, width, height) && isHeavy(mass)) {
// return "Both";
// } else if (!isBulky(length, width, height) && !isHeavy(mass)) {
// return "Neither";
// } else if (isBulky(length, width, height) && !isHeavy(mass)) {
// return "Bulky";
// } else if (!isBulky(length, width, height) && isHeavy(mass)) {
// return "Heavy";
// }
// return "";
// }
// }