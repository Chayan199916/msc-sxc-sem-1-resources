DECLARE

  no NUMBER := 5;

  BEGIN

  LOOP

  DBMS_OUTPUT.PUT_LINE ('Inside value: no = ' || no);

  no := no -1;

  IF no = 0 THEN EXIT;

  END IF;

  END LOOP;

  DBMS_OUTPUT.PUT_LINE('Outside loop end');

  END;

  /