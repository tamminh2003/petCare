use appPetCare;
-- POPULATE TEMP_DATE TABLE
DROP TABLE IF EXISTS temp_date;
CREATE TEMPORARY TABLE temp_date (
	index_num int AUTO_INCREMENT PRIMARY key,
	select_date Date
);

DROP PROCEDURE IF EXISTS temp_loop;
DELIMITER $$
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

-- POPULATE TEMP_TIME TABLE
DROP TABLE IF EXISTS temp_time;
CREATE TEMPORARY TABLE temp_time (
	index_num int AUTO_INCREMENT PRIMARY KEY,
	select_time TIME
);

DROP PROCEDURE IF EXISTS temp_loop;
DELIMITER $$
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

DROP PROCEDURE IF EXISTS temp_loop;
DELIMITER $$
CREATE PROCEDURE temp_loop()
BEGIN
	DECLARE X INT;
	SET X = 0;	
	loop_start: LOOP
		IF X > 29 THEN
			LEAVE loop_start;
		END IF;
        
        SET @rand_num := rand();
			
		INSERT INTO temp_appointment 
			(appointmentDate, startTime, appointmentType, petType, totalCost, isPaid)
		SELECT 
				(SELECT select_date FROM temp_date order by rand() limit 1),
				(SELECT select_time FROM temp_time order by rand() limit 1),
				CASE
					WHEN FLOOR(rand()*3+1) = 1 THEN 'DENTISTRY'
					WHEN FLOOR(rand()*3+1) = 2 THEN 'SURGERY'
					ELSE 'GENERAL'
				END,
				CASE
					WHEN (FLOOR(rand()*3)+1) < 1 THEN 'CAT'
					WHEN (FLOOR(rand()*3)+1) < 2 THEN 'BIRD'
					ELSE 'DOG'
				END,
				rand()*(100-50+1)+50,
				CASE
					WHEN rand() > 0.50 THEN TRUE
					ELSE FALSE
				END;
		
		SET x = x + 1;
		
	END LOOP;
END$$
DELIMITER ;
CALL temp_loop();

UPDATE temp_appointment
JOIN Vet ON Vet.specializeType = temp_appointment.appointmentType
SET temp_appointment.vetId = 
	CASE
		WHEN temp_appointment.appointmentType = 'GENERAL' THEN (SELECT id FROM Vet WHERE specializeType = 'GENERAL' ORDER BY rand() LIMIT 1)
        WHEN temp_appointment.appointmentType = 'SURGERY' THEN (SELECT id FROM Vet WHERE specializeType = 'SURGERY' ORDER BY rand() LIMIT 1)
        WHEN temp_appointment.appointmentType = 'DENTISTRY' THEN (SELECT id FROM Vet WHERE specializeType = 'DENTISTRY' ORDER BY rand() LIMIT 1) 
	END
WHERE temp_appointment.appointmentType = Vet.specializeType;

UPDATE temp_appointment
JOIN Vet on Vet.id = temp_appointment.vetId
SET temp_appointment.description = CONCAT('Dr.', Vet.Lastname, ' ', temp_appointment.petType, ' ', temp_appointment.appointmentType)
WHERE temp_appointment.vetId = Vet.id;

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
DROP PROCEDURE temp_loop;
