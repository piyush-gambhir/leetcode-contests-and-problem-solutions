-- Problem Link: https://leetcode.com/problems/capital-gainloss/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT stock_name, 
    SUM(CASE WHEN operation = 'buy' THEN -price ELSE price END) AS capital_gain_loss 
FROM Stocks
GROUP BY stock_name;
