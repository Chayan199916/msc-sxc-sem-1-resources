SET SERVEROUTPUT ON
SET VERIFY OFF

declare

    input_date date;
    get_day varchar2(15);

begin

    input_date := to_date('&new_date', 'dd-mon-yyyy');
    get_day := rtrim(to_char(input_date, 'day'));

    if get_day in ('saturday', 'sunday') then

        -- dbms_output.new_line;
        dbms_output.put_line('The day of the given date is : ' || get_day || ' and it falls on weekend');
    
    else

        -- dbms_output.new_line;
        dbms_output.put_line('The day of the given date is : ' || get_day || ' and it does not fall on weekend');

    end if;

    exception
    when OTHERS then
        
        dbms_output.put_line('invalid date input');

end;
/