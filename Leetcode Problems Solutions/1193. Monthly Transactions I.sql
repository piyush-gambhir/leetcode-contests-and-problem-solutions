-- Problem Link: https://leetcode.com/problems/monthly-transactions-i/

-- Write your MySQL query statement below
SELECT trans_date AS month, country, COUNT(id) AS tran_count, COUNT() AS,  SUM(amount) AS transaction_total_amount, SUM(amount) as transaction_total_amount