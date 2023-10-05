"""
Problem Link: https://leetcode.com/problems/method-chaining/
"""

import pandas as pd


def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    return animals[animals.weight > 100][['name']].sort_values(by='weight', ascending=False)
