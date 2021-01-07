-- -- table creation
-- create table customers_table(id number primary key, name varchar2(10), age number, address varchar2(20), salary number);
-- -- data insertion
-- insert into customers_table(id, name, age, address, salary) values(1, 'chayan', 21, 'sodepur', 10);
-- insert into customers_table(id, name, age, address, salary) values(2, 'manjistha', 21, 'kharagpur', 50);
-- insert into customers_table(id, name, age, address, salary) values(3, 'reshav', 22, 'sodepur', 80);
-- insert into customers_table(id, name, age, address, salary) values(4, 'sagnik', 22, 'sodepur', 50);
-- insert into customers_table(id, name, age, address, salary) values(5, 'sanglap', 21, 'sodepur', 50);

--sql%rowcount use
set serveroutput on
-- DECLARE
--  total_rows number(2);
-- BEGIN
--  UPDATE customers_table
--  SET salary = salary + 500;
--  IF sql%notfound THEN
--  dbms_output.put_line('no customers selected');
--  ELSIF sql%found THEN
--  total_rows := sql%rowcount;
--  dbms_output.put_line( total_rows || ' customers selected ');
--  END IF;
-- END;
-- /

--cursor demo
declare
    c_id customers_table.id%type;
    c_name customers_table.name%type;
    c_age customers_table.age%type;
    c_address customers_table.address%type;
    c_salary customers_table.salary%type;
    cursor cur_customers is 
    select id, name, age, address, salary from customers_table;
begin
    open cur_customers;
    loop
        fetch cur_customers into c_id, c_name, c_age, c_address, c_salary;
        if cur_customers%notfound then
            exit;
        else
            dbms_output.put_line(c_id || ' ' || c_name || ' ' || c_age || ' ' || c_address || ' ' || c_salary);
        end if;
    end loop;
    close cur_customers;
end;
/
