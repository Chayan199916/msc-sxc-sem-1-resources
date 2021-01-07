--.....UPDATE SALARY OF AN EMPLOYEE BY GIVING THE EID AND THE PERCENT RAISED AS ARGUMENTS TO A PROCEDURE​//

-- create table emp( e_id varchar2(4) primary key,e_name varchar2(30),salary number(12));
 
-- insert into emp values ('e1','Sayani',13000);

-- insert into emp values ('e5','Silpa',6000);

-- insert into emp values ('13','Anu',20000);

-- insert into emp values ('14','Abhi',25000);

-- create or replace procedure adjust_salary(​in_employee_id in emp.e_id%type,​ in_percent in number​) 
-- is​
-- BEGIN​
--     UPDATE emp​
--     SET salary = salary + salary * in_percent / 100​
--     WHERE e_id = in_employee_id;​
--     commit;
-- END;​
-- /
CREATE OR REPLACE PROCEDURE adjust_salary(in_employee_id IN emp.e_id%TYPE, in_percent IN NUMBER)
IS
BEGIN
    UPDATE emp
    SET salary = salary + salary * in_percent / 100
    WHERE e_id = in_employee_id;
    commit;
END adjust_salary;
/