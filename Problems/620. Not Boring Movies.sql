-- Problem Link: https://leetcode.com/problems/not-boring-movies/ 

-- Write your MySQL query statement below
SELECT *
FROM Cinemas
WHERE id % 2 = 1 AND description != 'boring'
ORDER BY rating DESC;