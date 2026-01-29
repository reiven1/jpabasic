SELECT * FROM CUSTOMER_HSW;
SELECT * FROM PRODUCT_HSW;
SELECT * FROM product_customer_hsw;
SELECT * FROM CART_HSW;

SELECT * FROM cart_kwj;

SELECT * FROM choiselesson_hsw ;
SELECT * FROM user_constraints;
SELECT * FROM user_cons_columns 
			JOIN user_constraints using(constraint_name)
WHERE user_constraints.table_name='LESSON2_HSW';

SELECT * FROM MEMBER;

SELECT * FROM board;
SELECT * FROM user_sequences;

SELECT * FROM BOARD_COMMENT 
RIGHT JOIN BOARD 
ON BOARD_NO=BOARD_REF;