-- Problem Link: https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/

-- Write your MySQL query statement below
SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;