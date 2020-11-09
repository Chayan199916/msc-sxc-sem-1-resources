SET SERVEROUTPUT ON

SET VERIFY OFF

declare

    input_number NUMBER := &input_number;
    result_number NUMBER := 1;

begin

    loop

        result_number := result_number  * input_number;
        input_number := input_number - 1;
        if input_number < 1 then

            exit;
        
        end if;
    
    end loop;

    DBMS_OUTPUT.PUT_LINE('Result is : ' || result_number);

end;
/




