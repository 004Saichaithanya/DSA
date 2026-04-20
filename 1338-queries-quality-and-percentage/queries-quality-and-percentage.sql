# Write your MySQL query statement below
SELECT query_name , ROUND(AVG(rating/position),2) as quality,
(
    SELECT  ROUND(COUNT(*)/COUNT(q1.rating) * 100,2)
    FROM Queries q2
    WHERE q2.query_name = q1.query_name
    AND q2.rating < 3
) as poor_query_percentage 
FROM Queries q1
Group by query_name