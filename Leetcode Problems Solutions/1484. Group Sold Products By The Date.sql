-- Problem Link: https://leetcode.com/problems/group-sold-products-by-the-date/

-- Write your MySQL query statement below
SELECT sell_date, COUNT(sell_date) AS num_sold,GROUP_CONCAT(DISTINCT product ORDER BY product) AS products 
FROM (SELECT DISTINCT sell_date, product FROM Activities) as Activities 
GROUP BY sell_date;
