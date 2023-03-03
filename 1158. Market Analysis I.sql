-- Problem Link: https://leetcode.com/problems/market-analysis-i/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT Users.user_id AS buyer_id,
    Users.join_date,
    IFNULL(COUNT(Orders.buyer_id), 0) AS orders_in_2019
FROM Users, Orders
WHERE Users.user_id = Orders.buyer_id
    AND YEAR(order_date) = '2019'
GROUP BY Users.user_id
ORDER BY Users.join_date ASC, orders_in_2019 DESC;