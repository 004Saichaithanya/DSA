# Write your MySQL query statement below
SELECT m.name
FROM Employee e
JOIN Employee m ON e.managerId = m.id
GROUP BY e.managerId
HAVING COUNT(*) >= 5;
