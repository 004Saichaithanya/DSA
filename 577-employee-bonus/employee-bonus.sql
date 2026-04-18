/* Write your PL/SQL query statement below */
SELECT e.name , b.bonus
FROM Employee e
LEFT JOIN Bonus b
ON e.empid = b.empid
WHERE b.bonus is NULL OR b.bonus < 1000;