-- 코드를 입력하세요
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, B.AMOUNT*P.PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT P JOIN (
    SELECT PRODUCT_ID, SUM(AMOUNT) as AMOUNT
    FROM FOOD_ORDER
    WHERE LEFT(PRODUCE_DATE, 7) = "2022-05"
     GROUP BY PRODUCT_ID
) B 
ON P.PRODUCT_ID = B.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID;
