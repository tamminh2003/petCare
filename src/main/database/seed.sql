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
	email varchar(255) NOT NULL UNIQUE,
	password varchar(60) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO appPetCare.Customer (firstname, lastname, email, password) VALUES('John', 'Smith', 'johnsmith@mail.com', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, password) VALUES('Jane', 'Doe', 'janedoe@mail.com', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, password) VALUES('Bob', 'Johnson', 'bobjohnson@mail.com', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, password) VALUES('Amy', 'Williams', 'amywilliams@mail.com', '12345');
INSERT INTO appPetCare.Customer (firstname, lastname, email, password) VALUES('Michael', 'Brown', 'michaelbrown@mail.com', '12345');

-- SELECT * FROM Customer c; 

DROP TABLE IF EXISTS Appointment;

CREATE TABLE IF NOT EXISTS Appointment
(
	id int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	vetId int NOT NULL,
	appointmentDate Date NOT NULL,
	startTime Time NOT NULL,
	description VARCHAR(255),
	appointmentType int NOT NULL, -- TODO: link this to appointmentType table
	petType int NOT NULL, -- TODO: link this to petType table
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Vet;

CREATE TABLE IF NOT EXISTS Vet
(
	id int NOT NULL AUTO_INCREMENT,
	firstname varchar(255) NOT NULL,
	lastname varchar(255) NOT NULL,	
	email varchar(255) NOT NULL, -- need TO link this to specializeType TABLE
	specializeType varchar(255) NULL,
	PRIMARY KEY (id)
);

INSERT INTO appPetCare.Vet (firstname, lastname, email, specializeType) VALUES('Emily', 'Davis', 'emilydavis@mail.com', 'surgery');
INSERT INTO appPetCare.Vet (firstname, lastname, email, specializeType) VALUES('Matthew', 'Miller', 'mattmiller@mail.com', 'dermatology');
INSERT INTO appPetCare.Vet (firstname, lastname, email, specializeType) VALUES('Olivia', 'Wilson', 'oliviawilson@mail.com', 'oncology');
INSERT INTO appPetCare.Vet (firstname, lastname, email, specializeType) VALUES('David', 'Anderson', 'davidanderson@mail.com', 'cardiology');
INSERT INTO appPetCare.Vet (firstname, lastname, email, specializeType) VALUES('John', 'Wick', 'johnwick@mail.com', 'orthopedics');
