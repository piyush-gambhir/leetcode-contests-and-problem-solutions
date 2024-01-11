"""
Problem Link: https://leetcode.com/problems/roman-to-integer/
"""


class Solution:
    def romanToInt(self, s: str) -> int:
        def romanToIntHelper(str):
            value = 0
            if (str == 'I'):
                value = 1
            elif (str == 'V'):
                value = 5
            elif (str == 'X'):
                value = 10
            elif (str == 'L'):
                value = 50
            elif (str == 'C'):
                value = 100
            elif (str == 'D'):
                value = 500
            elif (str == 'M'):
                value = 1000
            return value

        integer = 0
        for i in range(len(s)):
            if i > 0 and romanToIntHelper(s[i]) > romanToIntHelper(s[i-1]):
                integer += romanToIntHelper(s[i]) - \
                    2 * romanToIntHelper(s[i-1])
            else:
                integer += romanToIntHelper(s[i])

        return integer
