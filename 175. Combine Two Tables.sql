-- Problem Link: https://leetcode.com/problems/combine-two-tables/?envType=study-plan&id=sql-i

-- Write your MySQL query statement below
SELECT firstName, lastName, city, state 
FROM Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;
