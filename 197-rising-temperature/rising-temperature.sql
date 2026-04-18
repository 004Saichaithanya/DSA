/* Write your PL/SQL query statement below */
SELECT a.id
FROM Weather a
JOIN Weather b
ON a.recordDate = b.recordDate + 1  AND a.temperature > b.temperature;