import pandas as pd

def sales_person(sales_person: pd.DataFrame, company: pd.DataFrame, orders: pd.DataFrame) -> pd.DataFrame:
    if not company[company['name'] == 'RED'].empty:
        red_com_id = company[company['name'] == 'RED']['com_id'].iloc[0]
    else:
        return sales_person[['name']]    
    sales_ids_with_red_orders = orders[orders['com_id'] == red_com_id]['sales_id'].unique()
    result = sales_person[~sales_person['sales_id'].isin(sales_ids_with_red_orders)][['name']]
    return result
