//Retrieving the records from the emp table and displaying them one by one using cursors:
 
Declare
 var_empid employee.eid%type;
 var_ename employee.ename%type;
 var_sal employee.esal%type;
 
 CURSOR EMP_CURSOR IS
 select eid, ename, esal from employee;

BEGIN 
 open EMP_CURSOR;
 LOOP
 
fetch EMP_CURSOR into var_empid, var_ename, var_sal;
 
 EXIT when EMP_CURSOR%NOTFOUND;
 IF (var_sal > 30000) then
 DBMS_OUTPUT.put_line(var_empid || ' ' || var_ename || ' ' || var_sal);
 ELSE
 DBMS_OUTPUT.put_line(var_ename || ' Salary is less then 3000');
 END IF;
 END LOOP;
 
 close EMP_CURSOR;
 DBMS_OUTPUT.put_line('DONE');
 
 END;