"""
Problem Link: https://leetcode.com/problems/create-a-dataframe-from-list
"""

import pandas as pd


def createDataframe(student_data: List[List[int]]) -> pd.DataFrame:
    df = pd.DataFrame(student_data, columns=["student_id", "age"])
    return df
