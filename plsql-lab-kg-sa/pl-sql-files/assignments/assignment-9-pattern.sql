SET SERVEROUTPUT ON
SET VERIFY OFF

declare
    n number:=5;
    i number;
    j number;
    k number;
begin
    for i in reverse 1..n
    loop
        for j in 1..n-i
        loop
            dbms_output.put(' ');
        end loop;

        for k in 1..i
        loop
            dbms_output.put('*');
        end loop;

        dbms_output.new_line;
    end loop;
end;
/