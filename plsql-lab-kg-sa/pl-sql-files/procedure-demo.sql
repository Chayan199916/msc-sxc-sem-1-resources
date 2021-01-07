set serveroutput on

-- procedure without parameters

-- CREATE PROCEDURE greetings
-- AS
-- BEGIN
--  dbms_output.put_line('Hello World!');
-- END;
-- /
-- execute greetings; -- calling procedure
-- drop procedure greetings; -- for deleting procedure

-- procedure with parameters

-- DECLARE
--  a number;
--  b number;
--  c number;
--  d number;
-- PROCEDURE findMinMax(x IN number, y IN number, min OUT number, max OUT number)
-- IS
-- BEGIN
--  IF x < y THEN
--  min:= x;
--  max:= y;
--  ELSE
--  min:= y;
--  max:= x;
--  END IF;
-- END;
-- BEGIN
--  a:= 23;
--  b:= 45;
--  findMinMax(a, b, c, d);
--  dbms_output.put_line(' Minimum of (23, 45) : ' || c || ' and Maximum of (23, 45) : ' || d);
-- END;
-- /

-- DECLARE
--  a number;
-- Function squareNum(x IN OUT number)
-- return number
-- IS
-- BEGIN
--  x := x * x;
--  return x;
-- END;
-- BEGIN
--  a:= 23;
--  a:=squareNum(a);
--  dbms_output.put_line(' Square of (23): ' || a);
-- END;
-- /

--function with parameters

-- DECLARE
--  a number;
--  b number;
--  c number;
-- Function findMin(x IN number, y IN number)
-- return number
-- IS
--     m number;
-- BEGIN
--  IF x < y THEN
--  m:= x;
--  ELSE
--  m:= y;
--  END IF;
--  return m;
-- END;
-- BEGIN
--  a:= 23;
--  b:= 45;
--  c:=findMin(a, b);
--  dbms_output.put_line(' Minimum of (23, 45) : ' || c);
-- END;
-- /

--recursive function

-- DECLARE
--  num number;
--  factorial number;
-- FUNCTION fact(x number)
-- RETURN number
-- IS
-- BEGIN
--  IF x=0 THEN
--  return 1;
--  ELSE
--  return x * fact(x-1);
--  END IF;
-- END;
-- BEGIN
--  num:= 6;
--  factorial := fact(num);
--  dbms_output.put_line(' Factorial '|| num || ' is ' || factorial);
-- END;
-- /

-- using dual table

-- declare
-- function countTotal
-- return number
-- is
--     totalCount number;
-- begin
--     select count(*) into totalCount from dual;
--     return totalCount;
-- end;
-- begin
--     dbms_output.put_line('Total count : ' || countTotal());
-- end;
-- /