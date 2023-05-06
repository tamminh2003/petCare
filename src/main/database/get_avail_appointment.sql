DROP PROCEDURE IF EXISTS get_avail_appointment;
DELIMITER $$
CREATE PROCEDURE get_avail_appointment(IN pAppointmentType varchar(255))
BEGIN
DECLARE timeslot TIME;
DECLARE X INT;

-- POPULATE TEMP_DATE TABLE
DROP TABLE IF EXISTS temp_date;
CREATE TEMPORARY TABLE temp_date (
	index_num int AUTO_INCREMENT PRIMARY key,
	select_date Date
);
SET X = 0;
WHILE X < 7 DO
	INSERT INTO temp_date (select_date) VALUES (DATE_ADD(CURDATE(), INTERVAL X DAY));
	SET X = X + 1;
END WHILE;

-- POPULATE TEMP_TIME TABLE
DROP TABLE IF EXISTS temp_time;
CREATE TEMPORARY TABLE temp_time (
	index_num int AUTO_INCREMENT PRIMARY KEY,
	select_time TIME
);
SET X = 0;
SET timeslot := CONVERT(STR_TO_DATE('09:00:00', '%T'), TIME);
WHILE X < 16 DO
	INSERT INTO temp_time (select_time) VALUES (timeslot);
	SET X = X + 1;
	SET timeslot = ADDTIME(timeslot, "0:30:00");
END WHILE;

-- POPULATE temp_timeslot
DROP TABLE IF EXISTS temp_timeslot;
CREATE TEMPORARY TABLE temp_timeslot(
	index_num int auto_increment primary key,
    timeslot varchar(255)
);
INSERT INTO temp_timeslot (timeslot)
SELECT CONCAT(select_date, ' ', select_time) as timeslot
FROM temp_date d
CROSS JOIN temp_time t;

-- SELECT * FROM temp_timeslot;

-- TODO: lay phan available 
-- POPULATE temp_vet
DROP TABLE IF EXISTS temp_vet;
CREATE TEMPORARY TABLE temp_vet (
	index_num int auto_increment PRIMARY KEY,
	vetId int,
    specializeType VARCHAR(255)
);
INSERT INTO temp_vet (vetId, specializeType)
SELECT id, specializeType from Vet where specializeType = pAppointmentType;

-- SELECT * FROM temp_vet;


    
SELECT all_timeslot.vetId, all_timeslot.timeslot, CONCAT(v.firstname, ' ', v.lastname) AS vetName FROM (
	SELECT temp_vet.vetId, temp_timeslot.timeslot
	FROM temp_vet
	CROSS JOIN temp_timeslot) AS all_timeslot
LEFT JOIN Appointment a ON (all_timeslot.timeslot = CONCAT(appointmentDate, ' ', startTime))
JOIN Vet v on all_timeslot.vetId = v.id 
WHERE appointmentDate IS NULL
ORDER BY all_timeslot.timeslot;

DROP TABLE IF EXISTS temp_vet;
DROP TABLE IF EXISTS temp_timeslot;
DROP TABLE IF EXISTS temp_date;
DROP TABLE IF EXISTS temp_time;
DROP TABLE IF EXISTS temp_vet_appointment;
END$$

