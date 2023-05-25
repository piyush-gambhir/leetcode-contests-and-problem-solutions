-- Problem Link: https://leetcode.com/problems/students-and-examinations

-- Write your MySQL query statement below

SELECT student_id, student_name, subject_name, COUNT(student_id) AS attended_exams
FROM Students S JOIN Subjects SU LEFT JOIN Examinations E   
    WHERE S.student_id = E.student_id AND SU.subject_name = E.subject_name
GROUP BY student_id, subject_name
ORDER BY student_id, subject_name;
