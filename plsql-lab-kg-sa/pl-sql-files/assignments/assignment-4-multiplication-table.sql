-- multiplication table

--  create table multi_tab(First_No number(4), Second_No number(2), prod number (5));

 set serveroutput on
 set verify off

 declare

     n1 number(4);
     prod number (5);

 begin

     n1:= &n1;

     delete multi_tab;
     
     for n2 in 1..10

     loop

         prod:=n1*n2;

         insert into multi_tab values(n1,n2,prod);

     end loop;

 end;