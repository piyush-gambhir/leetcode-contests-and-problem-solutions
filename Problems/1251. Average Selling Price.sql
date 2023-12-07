-- Problem Link: https://leetcode.com/problems/average-selling-price/

-- Write your MySQL query statement below
SELECT DISTINCT P.product_id, ROUND(SUM(price*units)/(SUM(units)), 2) AS average_price
FROM Prices P JOIN UnitsSold U
    ON P.product_id = U.product_id
        AND P.start_date <= U.purchase_date
        AND P.end_date >= U.purchase_date
GROUP BY product_id;