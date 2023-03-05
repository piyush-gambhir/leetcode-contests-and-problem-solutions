-- Problem Link: https://leetcode.com/problems/top-travellers/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT Users.name, SUM(Rides.distance) AS travelled_distance 
FROM Users, Rides
WHERE Users.id = Rides.user_id
GROUP BY Users.name
ORDER BY travelled_distance DESC, name ASC;

