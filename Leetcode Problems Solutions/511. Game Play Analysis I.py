"""
Problem Link: https://leetcode.com/problems/game-play-analysis-i/ 
"""

import pandas as pd

def game_analysis(activity: pd.DataFrame) -> pd.DataFrame:
    activity = activity.sort_values(['player_id', 'event_date'])
    first_login = activity.groupby('player_id').first().reset_index()
    first_login = first_login[['player_id', 'event_date']].rename(columns={'event_date': 'first_login'})    
    return first_login
