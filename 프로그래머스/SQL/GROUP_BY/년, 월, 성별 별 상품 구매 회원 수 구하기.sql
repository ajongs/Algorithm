-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, U.GENDER, COUNT(DISTINCT O.USER_ID) AS USERS
FROM USER_INFO U 
JOIN ONLINE_SALE O
ON U.USER_ID = O.USER_ID
GROUP BY YEAR, MONTH, GENDER
HAVING NOT U.GENDER IS NULL
ORDER BY YEAR, MONTH, GENDER;
