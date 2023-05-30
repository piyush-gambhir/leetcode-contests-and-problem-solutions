-- Problem Link: https://leetcode.com/problems/exchange-seats/

-- Write your MySQL query statement below
SELECT (CASE 
WHEN id % 2 = 0 THEN id - 1
WHEN id = (SELECT MAX(id)
        FROM Seat) AND (SELECT COUNT(*)
        FROM Seat) % 2 = 1 THEN id
ELSE id + 1
END) AS id, student
FROM Seat
ORDER BY id ASC;
