"""
Problem Link: https://leetcode.com/problems/create-a-new-column/
"""

import pandas as pd


def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    employees = employees.assign(bonus=lambda x: x["salary"] * 2)
    return employees
