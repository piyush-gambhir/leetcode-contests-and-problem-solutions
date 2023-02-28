-- Problem Link: https://leetcode.com/problems/sales-person/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT name FROM SalesPerson 
WHERE sales_id NOT IN (SELECT sales_id FROM Orders WHERE com_id IN (SELECT com_id FROM Company WHERE name = 'RED'));