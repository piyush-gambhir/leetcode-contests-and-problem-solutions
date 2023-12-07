"""
Problem Link: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/
"""

import pandas as pd

def count_unique_subjects(teacher: pd.DataFrame) -> pd.DataFrame:
    result = teacher.groupby('teacher_id')['subject_id'].unique().reset_index()
    result['cnt'] = result['subject_id'].apply(lambda x: len(x))
    result = result[['teacher_id', 'cnt']]
    return result
