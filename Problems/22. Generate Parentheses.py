"""
Problem Link: https://leetcode.com/problems/generate-parentheses/
"""


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def generateParenthesis(result, current, open, close, max):
            if (len(current) == 2 * max):
                result.append(current)
                return

            if (open < max):
                generateParenthesis(result, current + "(", open + 1, close, max)
            if (close < open):
                generateParenthesis(result, current + ")",
                                    open, close + 1, max)

        result = []
        generateParenthesis(result, "", 0, 0, n)
        return result
