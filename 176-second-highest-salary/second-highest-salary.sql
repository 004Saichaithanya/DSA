# Write your MySQL query statement below
SELECT  MAX(salary) as SecondHighestSalary 
FROM (
    SELECT DISTINCT salary
    FROM Employee 
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) t;