import pandas as pd


def find_managers(employee: pd.DataFrame) -> pd.DataFrame:
    filtered_employee = employee[employee['managerId'].notnull()]
    report_counts = filtered_employee.groupby('managerId').size()
    managers_with_5_or_more = report_counts[report_counts >= 5].index
    result = employee[employee['id'].isin(managers_with_5_or_more)][['name']]

    return result
