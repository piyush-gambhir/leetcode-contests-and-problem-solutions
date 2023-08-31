import pandas as pd


def count_rich_customers(store: pd.DataFrame) -> pd.DataFrame:
    rich_customers = store[store['amount'] > 500]
    rich_customers = store['customer_id'].unique()
    rich_count = len(rich_customers)
    return pd.DataFrame([rich_count], columns=['rich_count'])
