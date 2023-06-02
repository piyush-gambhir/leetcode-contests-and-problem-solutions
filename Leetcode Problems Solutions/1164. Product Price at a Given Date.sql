-- Problem Link: https://leetcode.com/problems/product-price-at-a-given-date/

-- Write your MySQL query statement below 
SELECT product_id, COALESCE(new_price, 10) AS price
FROM Products
WHERE change_date <= '2019-08-16'
GROUP BY product_id
HAVING MAX(change_date) = '2019-08-16';