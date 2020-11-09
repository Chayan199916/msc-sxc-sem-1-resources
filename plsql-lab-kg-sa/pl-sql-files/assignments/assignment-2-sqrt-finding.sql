SET SERVEROUTPUT ON

SET VERIFY OFF
 
DECLARE

     v_num NUMBER :=&v_num;

BEGIN

     DBMS_OUTPUT.PUT_LINE('Square root of ' || v_num || ' is ' || round(sqrt(v_num), 3));

EXCEPTION

     WHEN VALUE_ERROR THEN

     DBMS_OUTPUT.PUT_LINE('An Error has occured');


END;
/