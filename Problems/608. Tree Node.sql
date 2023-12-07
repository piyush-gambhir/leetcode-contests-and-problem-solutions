-- Problem Link: https://leetcode.com/problems/tree-node

-- Write your MySQL query statement below
SELECT  id, parent_id, name, IFNULL(SUM(salary), 0) AS salary FROM