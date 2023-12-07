"""
Problem Link: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/
"""

import pandas as pd


def largest_orders(orders: pd.DataFrame) -> pd.DataFrame:
    return orders['customer_number'].mode().to_frame()
