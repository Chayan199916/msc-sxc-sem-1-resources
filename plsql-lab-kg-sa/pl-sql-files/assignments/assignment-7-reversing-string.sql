SET SERVEROUTPUT ON

SET VERIFY OFF

declare

    input_string varchar(20) := '&input_string';
    output_string varchar(20);
    str_len number;

begin

    str_len := length(input_string);

    for i in 1..str_len
    loop

        output_string := output_string || substr(input_string, -i, 1); 
        -- or use for i in reverse 1..str_len
    
    end loop;

    dbms_output.put_line('Reverse of the string is ' || output_string);

end;
/