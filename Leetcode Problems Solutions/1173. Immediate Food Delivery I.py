"""
Problem Link: https://leetcode.com/problems/immediate-food-delivery-i/
"""

import pandas as pd

def food_delivery(delivery: pd.DataFrame) -> pd.DataFrame:
    immediate_orders = delivery[delivery['order_date']
                                == delivery['customer_pref_delivery_date']]
    immediate_percentage = round(((len(immediate_orders)/len(delivery)) * 100), 2)
    
    return pd.DataFrame([immediate_percentage], columns=['immediate_percentage'])
