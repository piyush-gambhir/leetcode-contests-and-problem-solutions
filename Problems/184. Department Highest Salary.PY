"""
Problem Link: https://leetcode.com/problems/department-highest-salary/
"""

import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    merged_df = pd.merge(employee, department, left_on="departmentId", right_on="id", suffixes=('', '_dept'))
    max_salaries = merged_df.groupby('departmentId')['salary'].max().reset_index()
    highest_salaries = pd.merge(merged_df, max_salaries, on=['departmentId', 'salary'])
    result = highest_salaries[['name_dept', 'name', 'salary']]
    result.columns = ['Department', 'Employee', 'Salary']
    return result