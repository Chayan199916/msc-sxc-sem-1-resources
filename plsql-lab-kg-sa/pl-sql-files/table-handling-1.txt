/* create table student(student_id number primary key, first_name varchar2(30), last_name varchar2(30));
 
insert into student values (120,'Virendra','Sehwag');
insert into student values (121,'Vinay','Pathak');
insert into student values (122,'Sachin','Tendulkar');
insert into student values (123,'Ranvir','Shorey'); */

declare
	v_first_name VARCHAR2(35);
	v_last_name VARCHAR2(35);
BEGIN
	SELECT first_name, last_name
	INTO v_first_name, v_last_name
	FROM student
	WHERE student_id = 123;
	DBMS_OUTPUT.PUT_LINE('Student name: ' || v_first_name || ' ' || v_last_name);
EXCEPTION
	WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('There is no student with student id 125');
END;