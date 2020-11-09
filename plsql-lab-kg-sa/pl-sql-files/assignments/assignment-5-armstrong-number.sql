SET SERVEROUTPUT ON

SET VERIFY OFF

declare

    input_number number := &input_number;
    result_number number := 0;
    remainder number;
    input_number_cp number;

begin

    input_number_cp := input_number;
    while(input_number > 0)

        loop

            remainder := mod(input_number, 10);
            result_number := result_number + power(remainder, 3);
            input_number := floor(input_number / 10);

            -- dbms_output.put_line(input_number || ' ' || remainder || ' ' || result_number);

        end loop;

    if input_number_cp = result_number then

        dbms_output.put_line(input_number_cp || ' is an armstrong number.');

    else

        dbms_output.put_line(input_number_cp || ' is not an armstrong number.');   

    end if;

end;
/