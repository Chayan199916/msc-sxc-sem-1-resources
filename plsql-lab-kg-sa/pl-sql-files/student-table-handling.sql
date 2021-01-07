--table creation
-- create table students_sxc(sroll int not null primary key, sname varchar2(10) not null, sdept varchar2(5), smarks int check(smarks >= 1 and smarks <= 100), edob date);

--inserting values
-- insert into students_sxc values(1, 'Dishani', 'CS', 45, '05-Sep-98');
-- insert into students_sxc values(2, 'Riya', 'CS', 90, '25-Sep-98');
-- insert into students_sxc values(3, 'Diya', 'PHY', 98, '27-Oct-99');
-- insert into students_sxc values(4, 'Tiya', 'PHY', 67, '12-July-05');
-- insert into students_sxc values(5, 'Miya', 'CS', 56, '19-July-97');

--list the details of the student having max age

-- select * from students_sxc where floor(months_between(sysdate, edob)/12) = (select max(age) from (select floor(months_between(sysdate, edob)/12) as age from students_sxc));

-- write a procedure/function to input the sroll and return the student details

-- declare
--     studentDetails students_sxc%rowtype;
-- procedure getStudentDetails(roll in students_sxc.sroll%type, details out students_sxc%rowtype)
-- is
-- begin
--     select * into details from students_sxc where sroll = roll;
-- end;
-- begin
--     getStudentDetails(1, studentDetails);
--     dbms_output.put_line(studentDetails.sroll || ' ' || studentDetails.sname || ' ' || studentDetails.smarks || ' ' || studentDetails.edob);
-- end;
-- /