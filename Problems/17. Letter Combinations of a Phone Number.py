"""
Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
"""


class Solution:

    def get_letters(self, digit):
        if digit == "2":
            return ["a", "b", "c"]
        elif digit == "3":
            return ["d", "e", "f"]
        elif digit == "4":
            return ["g", "h", "i"]
        elif digit == "5":
            return ["j", "k", "l"]
        elif digit == "6":
            return ["m", "n", "o"]
        elif digit == "7":
            return ["p", "q", "r", "s"]
        elif digit == "8":
            return ["t", "u", "v"]
        elif digit == "9":
            return ["w", "x", "y", "z"]

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        if (len(digits) == 1):
            return self.get_letters(digits)

        result = []

        for i in range(len(digits)):
            letters = self.get_letters(digits[i])
            if not result:
                result = letters
            else:
                temp = []
                for j in range(len(result)):
                    for k in range(len(letters)):
                        temp.append(result[j] + letters[k])
                result = temp

        return result
