"""
Problem Link: https://leetcode.com/problems/n-queens/
"""

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def isSafe(board, queens, row, col):

            for i in range(col):
                if(queens[i] == row):
                    return False

        def solveNQueens(board, queens, col, n):
            pass

        result = []
        queens = [-1] * n
        
