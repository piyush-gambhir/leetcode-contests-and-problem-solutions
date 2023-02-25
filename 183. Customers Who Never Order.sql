-- Problem Link: https://leetcode.com/problems/customers-who-never-order/

-- Write your MySQL query statement below
SELECT Customers.name AS 'Customers' FROM Customers
WHERE Customers.id NOT IN 
(SELECT Orders.customerID FROM Orders);

