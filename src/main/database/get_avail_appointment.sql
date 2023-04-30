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
CROSS JOIN temp_time t
ORDER BY select_date ASC, select_time ASC;

-- POPULATE temp_vet
DROP TABLE IF EXISTS temp_vet;
CREATE TEMPORARY TABLE temp_vet (
	index_num int auto_increment PRIMARY KEY,
	vetId int,
    specializeType VARCHAR(255)
);
INSERT INTO temp_vet (vetId, specializeType)
SELECT id, specializeType from Vet where specializeType = pAppointmentType;

-- POPULATE temp_vet_appointment
DROP TABLE IF EXISTS temp_vet_appointment;
CREATE TEMPORARY TABLE temp_vet_appointment (
	index_num int auto_increment primary key,
    vetId int,
    timeslot varchar(255)
);
SET X = 1;
SET @MAX_X := (SELECT MAX(index_num) FROM temp_vet);
WHILE X <= @MAX_X DO
	SET @vetId := (SELECT vetId FROM temp_vet WHERE index_num = X);
	INSERT INTO temp_vet_appointment (vetId, timeslot)
	SELECT 
		@vetId as vetId,
		t1.timeslot as timeslot
	FROM temp_timeslot t1
	LEFT OUTER JOIN (
		SELECT concat(a.appointmentDate, ' ', a.startTime) AS timeslot
		FROM Appointment a
		WHERE a.vetId = @vetId
		AND a.appointmentDate BETWEEN CURDATE() AND ADDDATE(CURDATE(), 7)) AS t2
	ON t1.timeslot = t2.timeslot;
    SET X = X + 1;
END WHILE;

SELECT * FROM temp_vet_appointment;

DROP TABLE IF EXISTS temp_vet;
DROP TABLE IF EXISTS temp_timeslot;
DROP TABLE IF EXISTS temp_date;
DROP TABLE IF EXISTS temp_time;
DROP TABLE IF EXISTS temp_vet_appointment;

END$$

