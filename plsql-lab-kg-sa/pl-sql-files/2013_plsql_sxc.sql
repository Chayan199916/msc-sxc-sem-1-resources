-- -- table creation and inserting values

-- create table customer(cust_id varchar(10),cust_name varchar(20),amount number(6));

-- insert into customer values('C1', 'Ashish Paul',5000);
-- insert into customer values('C2', 'Manjistha Paul',5000);
-- insert into customer values('C3', 'Debjani Paul',8000);
-- insert into customer values('C4', 'Chayan Sengupta',50000);
-- insert into customer values('C5', 'Atreyee Shill',3000);
-- insert into customer values('C6', 'Debolina',500);
-- insert into customer values('C7', 'Michaul',2000);

-- create table customer_discount(cust_name varchar(20),amount number(6),discount_amount number(6),primary key(cust_name));

-- set serveroutput on
-- set verify off
-- declare
-- 		id customer.cust_id%type;
-- 		name customer.cust_name%type;
-- 		amt customer.amount%type;
-- 		discount customer_discount.discount_amount%type;
-- begin
-- 		id :='&id';
-- 		select cust_name,amount into name,amt from customer where cust_id=id;
-- 		if (amt > 5000) then
-- 			discount:=20/100*amt;
			
-- 		elsif (amt>=1000 and amt <=5000) then
-- 			discount:=12/100*amt;
			
-- 		else
-- 			discount:=5/100*amt;
			
-- 		end if;
-- 		insert into customer_discount values(name,amt,discount);
--         commit;
-- end;
-- /

-- Create a product table to store some relevant fields about different products sold by a shop.
-- Write a PL/SQL code to fetch the first n products according to their price and store their details
-- in a separate table called Expensive_Product.

-- create table products(prod_id varchar2(5), prod_name varchar2(10), prod_price number(4));
-- create table expensive_products(prod_id varchar2(5), prod_name varchar2(10), prod_price number(4));

-- ALTER TABLE products 
-- modify prod_name varchar(25);

-- insert into products values('P1','Moisturiser',200);
-- insert into products values('P2','Cooking oil',350);
-- insert into products values('P3','Detergent',100);
-- insert into products values('P4','Pulses',150);
-- insert into products values('P5','Spices',50);
-- insert into products values('P6','Essential Oils',500);
-- insert into products values('P7','Protein powder',860);
-- insert into products values('P8','Beverages',400);
-- insert into products values('P9','Sanitizer & disinfectant spray',150);
-- insert into products values('P10','Soaps',100);
-- insert into products values('P11','Pickles and jam',210);

-- set verify off;
-- declare
--     no_of_products number(2) := &no_of_products;
--     id products.prod_id%type;
--     name products.prod_name%type;
--     price products.prod_price%type;
--     counter number(2) := 0;
--     cursor cur_product
--     is
--     select * from products order by prod_price desc;
-- begin
--     open cur_product;
--     loop
--         fetch cur_product into id, name, price;
--         if cur_product%notfound or counter = no_of_products then
--             exit;
--         else
--             insert into expensive_products values(id, name, price);
--             commit;
--             counter := counter + 1;
--         end if;
--     end loop;
--     close cur_product;
-- end;
-- /

-- Create a table to store the detailed information of the students of a college. Write a PL/SQL
-- code to separately store odd-numbered records and even-numbered records to two different
-- tables.

-- create table students_detailed_info(stud_id varchar2(5), stud_name varchar2(20), stud_roll number(3), stud_age number(2));
-- create table odd_students_detailed_info(stud_id varchar2(5), stud_name varchar2(20), stud_roll number(3), stud_age number(2));
-- create table even_students_detailed_info(stud_id varchar2(5), stud_name varchar2(20), stud_roll number(3), stud_age number(2));
-- insert into students_detailed_info values('S1','Manjistha',555,21);
-- insert into students_detailed_info values('S2','Chayan',561,21);
-- insert into students_detailed_info values('S3','Atreyee',520,22);
-- insert into students_detailed_info values('S4','Chirag',554,21);
-- insert into students_detailed_info values('S5','Anamika',512,21);
-- insert into students_detailed_info values('S6','Zuberia',556,21);
-- insert into students_detailed_info values('S7','Atasi',525,22);
-- insert into students_detailed_info values('S8','Shreyashi',595,22);
-- insert into students_detailed_info values('S9','Ouddhav',515,22);
-- insert into students_detailed_info values('S10','Sayani',565,21);
-- insert into students_detailed_info values('S11','Ajay',535,24);
-- insert into students_detailed_info values('S12','Swapna',545,23);

-- set serveroutput on;
-- declare
--     counter number(2) := 1;
--     id students_detailed_info.stud_id%type;
--     name students_detailed_info.stud_name%type;
--     roll students_detailed_info.stud_roll%type;
--     age students_detailed_info.stud_age%type;
--     cursor cur_students_detailed_info
--     is
--     select * from students_detailed_info;
-- begin
--     open cur_students_detailed_info;
--     loop
--         fetch cur_students_detailed_info into id, name, roll, age;
--         if cur_students_detailed_info%notfound then
--             exit;
--         elsif mod(counter, 2) = 0 then
--             insert into even_students_detailed_info values(id, name, roll, age);
--             commit;
--         elsif mod(counter, 2) = 1 then
--             insert into odd_students_detailed_info values(id, name, roll, age);
--             commit;
--         end if;
-- 		counter := counter + 1;
--     end loop;
--     close cur_students_detailed_info;
-- end;
-- /

-- Write a PL/SQL code to store the first n positive integers along with their squares in an
-- already created table. „n‟ should be taken as an input. The program will also display the
-- content of the table.

-- create table square_number(n number,square number);

-- set serveroutput on
-- set verify off

-- declare	
-- 		n number;
-- 		sq square_number.square%type;
-- 		i square_number.n%type;
		
-- begin
-- 		n:=&limit;
-- 		for i in 1..n loop
-- 			sq:=i*i;
-- 			insert into square_number values(i,sq);
-- 			dbms_output.put_line('Number:'||i||' Square:'||sq);
-- 		end loop;
-- end;
-- /

--Write a PL/SQL code to reverse an input string.

-- declare
-- 	str1 varchar2(50) := '&str';
-- 	str2 varchar2(50);
-- 	len number;
-- 	i number;
-- begin
-- 	len := length(str1);
-- 	for i in reverse 1..len
-- 	loop
-- 		str2 := str2 || substr(str1,i,1);
-- 	end loop;
--     dbms_output.put_line('Reverse of String is:'||str2);
-- end;
-- /


