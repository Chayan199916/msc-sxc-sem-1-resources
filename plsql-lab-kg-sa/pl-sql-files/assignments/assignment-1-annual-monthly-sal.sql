set serveroutput on

set verify off
 
declare

     an_sal number;

     mnt_sal number;

begin

     an_sal := &an_sal;

     dbms_output.put_line('Enter annual salary');

     dbms_output.put_line('Monthly salary ' || (an_sal/12));

end;

/
