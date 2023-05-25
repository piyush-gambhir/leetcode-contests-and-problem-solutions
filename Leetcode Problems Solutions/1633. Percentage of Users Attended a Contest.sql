-- Problem Link: https://leetcode.com/problems/percentage-of-users-attended-a-contest/

-- Write your MySQL query statement below
SELECT DISTINCT contest_id, ROUND((COUNT(DISTINCT user_id)/(SELECT COUNT(DISTINCT user_id)
    FROM Users ))*100, 2) as percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id ASC;