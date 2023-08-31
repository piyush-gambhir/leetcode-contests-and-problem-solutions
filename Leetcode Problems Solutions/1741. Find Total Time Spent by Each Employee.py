"""
Problem Link: https://leetcode.com/problems/find-total-time-spent-by-each-employee/
"""

import pandas as pd

def total_time(employees: pd.DataFrame) -> pd.DataFrame:
    employees['time_spent'] = employees['out_time'] - employees['in_time']
    result = employees.groupby(['event_day', 'emp_id'])['time_spent'].sum().reset_index()
    result.columns = ['day', 'emp_id', 'total_time']
    return result