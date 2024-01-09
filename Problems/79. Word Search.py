"""
Problem Link: https://leetcode.com/problems/word-search/
"""

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        def dfs(board, word, i, j, index):
            if (len(word) == index):
                return True
            if (i < 0 or j < 0 or i >= len(board) or j >= len(board[0])):
                return False
            if (word[index] != board[i][j]):
                return False

            temp = board[i][j]
            board[i][j] = ''
            found = dfs(board, word, i + 1, j, index + 1) or \
                    dfs(board, word, i - 1, j, index + 1) or \
                    dfs(board, word, i, j + 1, index + 1) or \
                    dfs(board, word, i, j - 1, index + 1)
            board[i][j] = temp
            return found

        for i in range(len(board)):
            for j in range(len(board[0])):
                if (board[i][j] == word[0] and dfs(board, word, i, j, 0)):
                    return True

        return False
