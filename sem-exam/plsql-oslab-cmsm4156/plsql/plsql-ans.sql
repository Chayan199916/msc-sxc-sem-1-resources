-- gr - A
-- 1. b

-- Write a PL/SQL code to store the first n positive integers along with their cubes in an already created
-- table. 'n' should be taken as an input from the user. The program will also display the output of the
-- table

--table creation

create table cubes_of_numbers(input_number number,cube_of_number number);

--plsql code goes here

set serveroutput on
set verify off

declare	
		limit_var cubes_of_numbers.input_number%type;
		c_o_n cubes_of_numbers.cube_of_number%type;
		loop_var cubes_of_numbers.input_number%type;
        content_of_table cubes_of_numbers%rowtype;
        cursor cur_cubes_of_numbers
        is
        select * from cubes_of_numbers;
begin
		limit_var := &limit_of_entry;
		for loop_var in 1..limit_var
        loop
			c_o_n := power(loop_var, 3);
			insert into cubes_of_numbers values(loop_var, c_o_n);
		end loop;
        open cur_cubes_of_numbers;
        dbms_output.put_line('Content of the table goes here ----');
        dbms_output.put_line('-----------------------------------');
        dbms_output.put_line('input_number cube_of_number');
        dbms_output.put_line('-----------------------------------');
        loop
            fetch cur_cubes_of_numbers into content_of_table;
            if cur_cubes_of_numbers%notfound then
                exit;
            else
                dbms_output.put_line(content_of_table.input_number || '              ' || content_of_table.cube_of_number);
            end if;
        end loop;
        close cur_cubes_of_numbers;
end;
/

-- 1.a

-- Write a Function FAREA to calculate the Area of a Square or Area of a Circle. It accepts a number
-- and a character parameter. The character parameter is either ‘C’ to compute area of a Circle or ‘S’ to
-- compute the Area of a Square. Raise an Exception in case of invalid input.

declare
    input_val number;
    input_choice varchar2(1);
    area number;
    invalid_choice exception;
    function FAREA(val in number, choice in varchar2)
    return number
    is
        area number;
        pi constant number := 3.14;
        circle_choice varchar2(1) := 'C';
        square_choice varchar2(1) := 'S';
    begin
        if choice = circle_choice then
            area := pi * val * val;
        elsif choice = square_choice then
            area := val * val;
        else
            raise invalid_choice;
        end if;
        return area;
        exception
            when invalid_choice then
                dbms_output.put_line('You have chosen wrong input. Do check and choose between "S" and "C"');
                return -1;
    end;
begin
    input_val := &input_number;
    input_choice := '&input_choice';
    area := FAREA(input_val, input_choice);
    if area != -1 then
        dbms_output.put_line('Area : ' || area);
    end if;
end;
/

-- 3. Create the following Tables maintaining proper Integrity Constraints.
-- Student (s_roll, s_name, s_address, c_id)
-- Course (c_id, c_name, c_fees, c_startdate)

-- Insert at least 5 records in each table. Keep proper validation so that the value of course fees (c_fees) lies
-- between 5000-50000 and the c-id starts with the letters ‘CR’. [5]
-- a) Write a PL/SQL code using cursor to increase the course fees of the course ‘Python Programming’ by
-- 10% and other courses by 5%. Ensure that the updation is properly done within the validation limit.
-- b) Write a procedure/function to input the c-id of a Course and return the Course details. Use proper
-- Exception Handling in case of invalid data input.

create table students_sxc_2k21(s_roll number(4) not null, s_name varchar2(15) not null, 
    s_address varchar2(25), c_id varchar2(5), primary key(s_roll), 
        foreign key(c_id) references courses_sxc_2k21(c_id));

create table courses_sxc_2k21(c_id varchar2(5) not null check(c_id like 'CR%'), 
    c_name varchar2(25) not null, c_fees number(5) not null check(c_fees >= 5000 and c_fees <= 50000), 
        c_startdate date, primary key(c_id));

insert into students_sxc_2k21 values(50,'Manjistha','Kharagpur','CR1');
insert into students_sxc_2k21 values(51,'Chayan','Sodpur','CR1');
insert into students_sxc_2k21 values(52,'Reshav','Sodpur','CR2');
insert into students_sxc_2k21 values(53,'Ravindrababu','Chennai','CR4');
insert into students_sxc_2k21 values(54,'Aswini','Uluberia','CR5');

insert into courses_sxc_2k21 values('CR1', 'Algo Ds', 5500, '02-sep-05');
insert into courses_sxc_2k21 values('CR2', 'Python Programming', 7500, '05-sep-05');
insert into courses_sxc_2k21 values('CR3', 'Soft Eng', 10500, '06-sep-05');
insert into courses_sxc_2k21(c_id, c_name, c_fees) values('CR4', 'Dbms', 9500);
insert into courses_sxc_2k21 values('CR5', 'Java', 15500, '08-sep-05');
insert into courses_sxc_2k21(c_id, c_name, c_fees) values('CR6', 'Dbms', 49990);

declare 
		new_fees courses_sxc_2k21.c_fees%type;
		fees courses_sxc_2k21.c_fees%type;
		name courses_sxc_2k21.c_name%type;
		id courses_sxc_2k21.c_id%type;
        fees_overflow exception;
		start_date courses_sxc_2k21.c_startdate%type;
		cursor cur_courses
		is
		select * from courses_sxc_2k21;
begin
	open cur_courses;
	loop
		fetch cur_courses into id, name, fees, start_date;
        if cur_courses%notfound then
            exit;
		elsif name = 'Python Programming’ then
			new_fees := fees + (10 / 100 * fees);
		else
            new_fees := fees + (5 / 100 * fees);
		end if;
        if new_fees > 50000 then
            raise fees_overflow;
        end if;
		update courses_sxc_2k21 
        set c_fees=new_fees 
        where c_id = id;
        commit;
	end loop;
    exception
        when fees_overflow then
            dbms_output.put_line('Increment in fees not allowed for id : '|| id || ' coz it has fees : ' || fees);
    close cur_courses;
end;
/		

set serveroutput on;
declare
    details courses_sxc_2k21%rowtype;
    id courses_sxc_2k21.c_id%type;
    procedure get_details(id in courses_sxc_2k21.c_id%type, details out courses_sxc_2k21%rowtype)
    is
    begin
        select * into details from courses_sxc_2k21 where c_id = id;
        exception
            when no_data_found then
                dbms_output.put_line('No such data present for this id value');
    end;
begin
    id := '&course_id';
    get_details(id, details);
    dbms_output.put_line(details.c_id || ' ' || details.c_name || ' ' || details.c_fees || ' ' || details.c_startdate);
end;
/

-- 2. Create the following tables with proper integrity constraints:
-- Emp (e_id, e_name, e_sal, d_id)
-- Dept (d_id, d_name, d_location)
-- Every employee id must begin with ‘EOM’, the salary range of an employee should be between 15000
-- and 150000, and the departments are in one of the following locations: Kolkata, Chennai, Bangalore,
-- and Gurgaon. Insert at least 5 records in each table. [5]
-- i) Write a PL/SQL code using Cursor to increase the salary of all the employees of Chennai by 15% and
-- decrease the salaries of employees residing in Gurgaon by 5%, setting the maximum and minimum
-- ceiling as given.
-- ii) Write a procedure/function to input the id (e_id) of an employee and return the corresponding
-- employee details. Use proper Exception Handling in case of invalid data input.

create table employees_sxc_2k21(e_id varchar2(10) not null check(e_id like 'EOM%'), 
    e_name varchar2(15) not null, 
    e_sal number check(e_sal >= 15000 and e_sal <= 150000), 
    d_id varchar2(5), primary key(e_id), 
        foreign key(d_id) references departs_sxc_2k21(d_id));

create table departs_sxc_2k21(d_id varchar2(5) not null, 
    d_name varchar2(15) not null, 
    d_location varchar2(15) check(d_location in('Kolkata', 'Chennai', 'Bangalore', 'Gurgaon')), 
    primary key(d_id));

insert into Emp values('EOM1','Manjistha',17500,'D1');
insert into Emp values('EOM2','Chayan',18500,'D2');
insert into Emp values('EOM3','Reshav',19500,'D1');
insert into Emp values('EOM6','Karan',19500,'D5');
insert into Emp values('EOM4','Sagnik',57500,'D3');
insert into Emp values('EOM5','Anu',66500,'D4');

insert into Dept values('D1', 'HR', 'Kolkata');
insert into Dept values('D2', 'Specialist', 'Chennai');
insert into Dept values('D3', 'Tech', 'Bangalore');
insert into Dept values('D4', 'Publish', 'Kolkata');
insert into Dept values('D5', 'Supervising', 'Gurgaon');


declare 
		new_salary Emp.e_sal%type;
        id Emp.e_id%type;
        name Emp.e_name%type;
        salar Emp.e_sal%type;
        dept Emp.d_id%type;
		cursor cur_employees_1
		is
		select * from Emp where d_id = (select d_id from Dept where d_location = 'Chennai');
        
        cursor cur_employees_2
		is
		select * from Emp where d_id = (select d_id from Dept where d_location = 'Gurgaon');
begin
	open cur_employees_1;
	loop
		fetch cur_employees_1 into id, name, salar, dept;
        if cur_employees_1%notfound then
            exit;
		else
            new_salary := salar + (15 / 100 * salar);
		end if;
        if new_salary > 150000 then
            new_salary := 150000;
        end if;
		update Emp 
        set e_sal = new_salary 
        where e_id = id;
        commit;
	end loop;
    open cur_employees_2;
	loop
		fetch cur_employees_2 into id, name, salar, dept;
        if cur_employees_2%notfound then
            exit;
		else
            new_salary := salar - (5 / 100 * salar);
		end if;
        if new_salary < 15000 then
            new_salary := 15000;
        end if;
		update Emp 
        set e_sal = new_salary 
        where e_id = id;
        commit;
	end loop;
    close cur_employees_1;
    close cur_employees_2;
end;
/		

set serveroutput on
	declare
        details Emp%rowtype;
        id Emp.e_id%type;
    procedure display_details(id in Emp.e_id%type, details out Emp%rowtype)
    is
    begin
        select * into details from Emp where e_id = id;
        exception
            when no_data_found then
                dbms_output.put_line('No such data present for this id value');
    end;
	begin
        id := '&emp_id';
        display_details(id, details);
        dbms_output.put_line(details.e_id || ' ' || details.e_name || ' ' || details.e_sal || ' ' || details.d_id);
	end;
	/