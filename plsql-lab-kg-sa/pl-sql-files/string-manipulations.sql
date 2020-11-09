DECLARE

 greetings varchar2(11) := 'hello world';

 BEGIN

 dbms_output.put_line(UPPER(greetings));

 dbms_output.put_line(LOWER(greetings));

 dbms_output.put_line(INITCAP(greetings));

         /* retrieve the first character in the string */

 dbms_output.put_line ( SUBSTR (greetings, 1, 1));

         /* retrieve the last character in the string */

 dbms_output.put_line ( SUBSTR (greetings, -1, 1));

         /* retrieve five characters, starting from the seventh position. */

 dbms_output.put_line ( SUBSTR (greetings, 7, 5));

         /* retrieve the remainder of the string, starting from the second position. */

 dbms_output.put_line ( SUBSTR (greetings, 2));

         /* find the location of the first "e" */

 dbms_output.put_line ( INSTR (greetings, 'g'));

 END;

 /