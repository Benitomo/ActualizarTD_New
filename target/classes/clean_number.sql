DROP FUNCTION IF EXISTS CLEAN_NUMBER;
DELIMITER $$
CREATE FUNCTION CLEAN_NUMBER(STR VARCHAR(105))
RETURNS VARCHAR(105) DETERMINISTIC
BEGIN
DECLARE LEN INT DEFAULT LENGTH(STR);
DECLARE I INT DEFAULT 1;
DECLARE NEWSTR VARCHAR(105) DEFAULT "";
DECLARE C CHAR;
WHILE I <= LEN DO
SET C = SUBSTR(STR, I, 1);
IF C >= 'a' AND C <= 'z' OR        C >= 'A' AND C <= 'Z' OR        C >= '0' AND C <= '9' THEN   SET NEWSTR = CONCAT(NEWSTR, C);
END IF;
SET I = I+1;
END WHILE;
RETURN NEWSTR;
END$$