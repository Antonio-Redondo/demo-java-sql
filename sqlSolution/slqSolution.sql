--(1) Write MySQL query to find IPs that mode more than a certain number of requests for a given time period.
SELECT ip, COUNT (ip) AS requests FROM ACCESS
WHERE STARTDATE BETWEEN '2017-01-01 13:00:00 '
AND  '2017-01-01 14:00:00 '
GROUP BY (ip)
HAVING requests > 200;

--(2) Write MySQL query to find requests made by a given IP.
 SELECT ip, COUNT (ip) AS requests FROM ACCESS
WHERE STARTDATE BETWEEN '2017-01-01 13:00:00'
AND '2017-01-01 14:00:00'
GROUP BY (ip)
