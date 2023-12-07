-- Problem Link: https://leetcode.com/problems/fix-names-in-a-table/

-- Write your MySQL query statement below
SELECT user_id, CONCAT(UPPER(SUBSTR(name, 1, 1)), LOWER(SUBSTR(name, 2))) as name FROM Users ORDER BY user_id;