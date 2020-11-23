// SIMPLE CURSOR USING %ROWTYPE
 
DECLARE 
 emp_rec employee%rowtype;
 
 CURSOR emp_cur  IS 
  SELECT * FROM employee WHERE esal > 40000; 
 
 BEGIN 
 OPEN emp_cur; 
 
 FETCH emp_cur INTO emp_rec; 
    dbms_output.put_line (emp_rec.ename || '  ' || emp_rec.esal); 
  CLOSE emp_cur; 
 
 END; 
 
-----------------------------------------------------------------------------------------------
 
DECLARE 
 
    CURSOR emp_cur IS 
 
SELECT ename, edept, esal FROM employee; 
     emp_rec emp_cur%rowtype; 
 
BEGIN 

 IF NOT emp_cur%ISOPEN THEN 
     OPEN emp_cur; 
  END IF; 
 
  LOOP 

FETCH emp_cur INTO emp_rec; 

  EXIT WHEN emp_cur%NOTFOUND; 
     dbms_output.put_line(emp_rec.ename || ' ' ||emp_rec.edept || ' ' ||emp_rec.esal); 
  END LOOP; 
  END; 
