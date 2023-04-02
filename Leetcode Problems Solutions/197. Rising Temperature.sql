-- Problem Link: https://leetcode.com/problems/rising-temperature/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT Weather1.id FROM Weather AS Weather1, Weather AS Weather2
WHERE Weather1.Temperature > Weather2.Temperature 
AND DATEDIFF(Weather1.RecordDate, Weather2.RecordDate) = 1;