-- POPULATE TEMP_DATE TABLE
DROP TABLE IF EXISTS temp_date;
CREATE TEMPORARY TABLE temp_date (
	index_num int AUTO_INCREMENT PRIMARY key,
	select_date Date
);

DELIMITER $$

DROP PROCEDURE IF EXISTS temp_loop;
CREATE PROCEDURE temp_loop()
BEGIN
	DECLARE X INT;
	SET X = 0;
	
	loop_start: LOOP
		IF X > 6 THEN
			LEAVE loop_start;
		END IF;	
			
		INSERT INTO temp_date (select_date) VALUES (DATE_ADD(CURDATE(), INTERVAL X DAY));
		
		SET x = x + 1;
	END LOOP;
	
END$$

DELIMITER ;

CALL temp_loop();
--------------------------------

-- POPULATE TEMP_TIME TABLE
DROP TABLE IF EXISTS temp_time;
CREATE TEMPORARY TABLE temp_time (
	index_num int AUTO_INCREMENT PRIMARY KEY,
	select_time TIME
);

DELIMITER $$

DROP PROCEDURE IF EXISTS temp_loop;
CREATE PROCEDURE temp_loop()
BEGIN
	DECLARE X INT;
	DECLARE timeslot TIME;
	SET X = 0;
	SET timeslot := CONVERT(STR_TO_DATE('09:00:00', '%T'), TIME);
	
	loop_start: LOOP
		IF X > 15 THEN
			LEAVE loop_start;
		END IF;
				
		INSERT INTO temp_time (select_time) VALUES (timeslot);
		
		SET x = x + 1;
		SET timeslot = ADDTIME(timeslot, "0:30:00");
		
	END LOOP;
END$$

DELIMITER ;

CALL temp_loop();
--------------------------------

-- POPULATE TEMP_APPOINTMENT TABLE
DROP TABLE IF EXISTS temp_appointment;
CREATE TEMPORARY TABLE temp_appointment (
	customerId INT AUTO_INCREMENT PRIMARY KEY,
	vetId INT,
	DESCRIPTION VARCHAR(255) DEFAULT 'Placeholder Description',
	appointmentDate DATE,
	startTime TIME,
	appointmentType VARCHAR(255),
	petType VARCHAR(255),
	totalCost DECIMAL(9,2),
	isPaid BOOLEAN	
);

DELIMITER $$

DROP PROCEDURE IF EXISTS temp_loop;
CREATE PROCEDURE temp_loop()
BEGIN
	DECLARE X INT;
	DECLARE rand_num DECIMAL(9,2);
	DECLARE rand_num2 DECIMAL(9,2);
	SET X = 0;	
	loop_start: LOOP
		IF X > 19 THEN
			LEAVE loop_start;
		END IF;
		
		SET rand_num = RAND();
		SET rand_num2 = RAND();
			
		INSERT INTO temp_appointment 
			(appointmentDate, startTime, appointmentType, petType, totalCost, isPaid)
		SELECT 
				(SELECT select_date FROM temp_date WHERE index_num = FLOOR(rand_num*(7-1)+1)),
				(SELECT select_time FROM temp_time WHERE index_num = FLOOR(rand_num*(16-1)+1)),
				CASE
					WHEN FLOOR(rand_num*(3-1)+1) = 1 THEN 'DENTISTRY'
					WHEN FLOOR(rand_num*(3-1)+1) = 2 THEN 'SURGERY'
					ELSE 'GENERAL'
				END,
				CASE
					WHEN FLOOR(rand_num2*(3-1)+1) < 1 THEN 'CAT'
					WHEN FLOOR(rand_num2*(3-1)+1) < 2 THEN 'BIRD'
					ELSE 'DOG'
				END,
				rand_num*(100-50)+50,
				CASE
					WHEN rand_num2 > 0.50 THEN TRUE
					ELSE FALSE
				END;
		
		SET x = x + 1;
		
	END LOOP;
END$$

DELIMITER ;

CALL temp_loop();

UPDATE temp_appointment
JOIN Vet ON Vet.specializeType = temp_appointment.appointmentType
SET temp_appointment.vetId = Vet.id
WHERE temp_appointment.appointmentType = Vet.specializeType;

SELECT * FROM temp_date;
SELECT * FROM temp_time;
SELECT * FROM temp_appointment;

TRUNCATE TABLE Appointment;

INSERT INTO Appointment 
	(customerId, vetid, DESCRIPTION, appointmentDate, startTime, appointmentType, petType, totalCost, isPaid)
SELECT
	customerId, vetId, DESCRIPTION, appointmentDate, startTime, appointmentType, petType, totalCost, isPaid
FROM temp_appointment;

SELECT * FROM Appointment;

DROP TABLE temp_appointment;
DROP TABLE temp_date;
DROP TABLE temp_time;
