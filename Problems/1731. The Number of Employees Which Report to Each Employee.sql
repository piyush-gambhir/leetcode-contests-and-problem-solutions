-- Problem Link: https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee/

-- Write your MySQL query statement below

SELECT 
    m.employee_id, 
    m.name, 
    COUNT(e.employee_id) AS reports_count, 
    ROUND(AVG(e.age)) AS average_age
FROM Employees m
JOIN Employees e ON m.employee_id = e.reports_to
WHERE m.reports_to IS NULL
GROUP BY m.employee_id, m.name
ORDER BY m.employee_id; 