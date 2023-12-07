-- Problem Link: https://leetcode.com/problems/https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/

-- Write your MySQL query statement below
SELECT unique_id, name 
FROM EmployeeUNI e1 RIGHT OUTER JOIN employees e2
ON e1.id = e2.id;