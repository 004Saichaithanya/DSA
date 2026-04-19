# Write your MySQL query statement below
SELECT contest_id , ROUND((COUNT(contest_id)/ (SELECT COUNT(*) FROM Users)) * 100 , 2) as percentage 
FROM Users u 
JOIN Register r ON u.user_id = r.user_id
GROUP BY contest_id
ORDER BY percentage DESC , contest_id ASC;
