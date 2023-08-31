"""
Problem Link: https://leetcode.com/problems/classes-more-than-5-students/
"""

import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    result = courses.groupby('class').agg({'student': 'nunique'}).reset_index()
    result = result[result['student'] >= 5]
    result = result[['class']]