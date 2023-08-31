"""
Problem Link: https://leetcode.com/problems/group-sold-products-by-the-date/
"""

import pandas as pd

def categorize_products(activities: pd.DataFrame) -> pd.DataFrame:
    result = activities.groupby('sell_date')['product'].unique().reset_index()
    result['product'] = result['product'].apply(lambda x: ",".join(sorted(x)))
    result['num_sold'] = result['product'].apply(lambda x: len(x.split(',')))
    return result[['sell_date', 'num_sold', 'product']].rename(columns={'product': 'products'}).sort_values(by='sell_date')

    
    
