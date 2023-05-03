-- new petCare generation script.
DROP SCHEMA IF EXISTS appPetCare;

CREATE SCHEMA appPetCare;

USE appPetCare;

DROP TABLE IF EXISTS Customer;

CREATE TABLE IF NOT EXISTS Customer
(
	id int NOT NULL AUTO_INCREMENT,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	phoneNumber varchar(255) NOT NULL,
	password varchar(60) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO appPetCare.Customer (firstname, lastname, email, phoneNumber, password) VALUES('John', 'Smith', 'johnsmith@mail.com', '+61 412 345 678', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, phoneNumber, password) VALUES('Jane', 'Doe', 'janedoe@mail.com', '0491 570 156', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, phoneNumber ,password) VALUES('Bob', 'Johnson', 'bobjohnson@mail.com', '0491 570 157', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, phoneNumber, password) VALUES('Amy', 'Williams', 'amywilliams@mail.com', '0491 570 158', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, phoneNumber, password) VALUES('Michael', 'Brown', 'michaelbrown@mail.com', '0491 570 159', '12345');

-- SELECT * FROM Customer c; 

DROP TABLE IF EXISTS Appointment;

CREATE TABLE IF NOT EXISTS Appointment
(
	id int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	vetId int NOT NULL,
	appointmentDate Date NOT NULL,
	startTime time NOT NULL,
	description VARCHAR(255),
	appointmentType VARCHAR(255) NOT NULL, -- TODO: link this to appointmentType table
	petType VARCHAR(255) NOT NULL, -- TODO: link this to petType table
	totalCost decimal(9,2) DEFAULT 0.0,
	isPaid boolean DEFAULT False,
	PRIMARY KEY (id),
	UNIQUE KEY 'Appointment_unique' (appointmentDate, startTime)
);

DROP TABLE IF EXISTS Vet;

CREATE TABLE IF NOT EXISTS Vet
(
	id int NOT NULL AUTO_INCREMENT,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,	
	email varchar(255) NOT NULL UNIQUE, -- need TO link this to specializeType TABLE
	phoneNumber varchar(255) NOT NULL,
	specializeType varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('Emily', 'Davis', 'emilydavis@mail.com', '(03) 5333 5422','SURGERY');
INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('Matthew', 'Miller', 'mattmiller@mail.com', '(02) 9588 7887', 'GENERAL');
INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('Olivia', 'Wilson', 'oliviawilson@mail.com', '(02) 9905 6202', 'GENERAL');
INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('David', 'Anderson', 'davidanderson@mail.com', '(03) 9786 5666', 'SURGERY');
INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('John', 'Wick', 'johnwick@mail.com', '(02) 8396 9800', 'DENTISTRY');
INSERT INTO appPetCare.Vet (firstname, lastname, email, phoneNumber, specializeType) VALUES('Joseph', 'Francesco', 'josephfrancesco@mail.com', '(02) 8396 9823', 'DENTISTRY');

