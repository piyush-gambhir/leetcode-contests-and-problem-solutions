import pandas as pd

def count_salary_categories(accounts: pd.DataFrame) -> pd.DataFrame:
    low_salary = accounts[accounts['income'] < 20000]
    medium_salary = accounts[(accounts['income'] >= 20000)
                             & (accounts['income'] <= 50000)]
    high_salary = accounts[accounts['income'] > 50000]

    return pd.DataFrame(
        {
            'category': ['Low Salary', 'Average Salary', 'High Salary'],
            'accounts_count': [low_salary.shape[0], medium_salary.shape[0], high_salary.shape[0]]
        })
