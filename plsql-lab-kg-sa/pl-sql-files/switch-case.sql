DECLARE

     a number := 7;

 BEGIN

     CASE  

         WHEN a = 1 THEN

             DBMS_OUTPUT.PUT_LINE('value 1');   

         WHEN a = 2 THEN

             DBMS_OUTPUT.PUT_LINE('value 2');   

         WHEN a = 3 THEN

             DBMS_OUTPUT.PUT_LINE('value 3');

           WHEN a = 7 THEN

             DBMS_OUTPUT.PUT_LINE('value 7 first');

          WHEN a>6 AND a<8 THEN

             DBMS_OUTPUT.PUT_LINE('value 7 second');
          ELSE

         DBMS_OUTPUT.PUT_LINE('no matching CASE found');   

     END CASE;   

 END;

 /