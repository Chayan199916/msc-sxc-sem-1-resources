declare

     v_employee    emp%rowtype;

 begin

     select  *

     into v_employee

     from emp

       where eid = 13;
 
    update emp

     set esal = v_employee.esal + 10000

        where eid = v_employee.eid;

 end;
 /