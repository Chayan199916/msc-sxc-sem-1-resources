-- Calculate area of circle n ( for radius 1 to 20) store in table
 
--  table creation

-- create table areas(rad number(2), area number (10,4));

SET SERVEROUTPUT ON
SET VERIFY OFF

declare

    radius number(2) := &radius;
    area number(10, 4);
    pi constant number := 3.14;

begin

    delete areas;
    for i in 1..radius
    loop

        area := pi * power(i, 2);
        insert into areas values(i, area);
    
    end loop;

end;
/