-- Problem Link: https://leetcode.com/problems/duplicate-emails

-- Write your MySQL query statement below
SELECT email AS Email 
FROM Person 
GROUP BY email
HAVING COUNT(email) > 1;