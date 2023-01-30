-- use default schema sys
use sys;
# CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
# GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';
# drop user 'user'@'localhost';
-- create schema for PetCare
drop schema if exists `pet_care`;
create schema `pet_care`;
use pet_care;

SET GLOBAL time_zone = '+00:00';
SET SESSION time_zone = '+00:00';
SELECT @@GLOBAL.time_zone, @@SESSION.time_zone;

-- CREATE TABLE CUSTOMER
CREATE TABLE `pet_care`.`customer`
(
    `ID`              INT          NOT NULL,
    `NAME`            VARCHAR(100) NOT NULL,
    `EMAIL`           VARCHAR(100) NOT NULL,
    `PHONENUMBER`     VARCHAR(15)  NOT NULL,
    `POSTCODE`        VARCHAR(5)   NULL,
    `REGISTEREDAT`    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `CURRENTPASSWORD` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`ID`),
    UNIQUE INDEX `CUSTOMER_EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- CREATE TABLE PET
CREATE TABLE `pet_care`.`pet`
(
    `ID`                        INT                                   NOT NULL,
    `OWNERID`                   INT                                   NULL,
    `DATEOFBIRTH`               DATE                                  NOT NULL,
    `SPECIES`                   ENUM ('DOG', 'CAT', 'BIRD', 'RABBIT') NOT NULL,
    `NAME`                      VARCHAR(45)                           NOT NULL,
    `GENDER`                    ENUM ('MALE', 'FEMALE')               NOT NULL,
    `DESEXED`                   BOOLEAN                               NOT NULL,
    `REGISTEREDAT`              DATETIME                              NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `COUNCILREGISTRATIONNUMBER` VARCHAR(45)                           NULL,
    `ISDECEASED`                BOOLEAN                               NOT NULL,
    `ISSTRAY`                   BOOLEAN                               NOT NULL,
    PRIMARY KEY (`ID`),
    INDEX `FK_CUSTOMER_OWNER_IDX` (`OWNERID` ASC) VISIBLE,
    CONSTRAINT `FK_CUSTOMER_OWNER_ID`
        FOREIGN KEY (`OWNERID`)
            REFERENCES `customer` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- CREATE TABLE VET
CREATE TABLE `pet_care`.`vet`
(
    `ID`              INT          NOT NULL,
    `FIRSTNAME`       VARCHAR(50)  NOT NULL,
    `LASTNAME`        VARCHAR(50)  NOT NULL,
    `MIDDLENAME`      VARCHAR(50)  NULL,
    `EMAIL`           VARCHAR(100) NOT NULL,
    `PHONENUMBER`     VARCHAR(15)  NOT NULL,
    `ISSPECIALIST`    BOOLEAN      NOT NULL,
    `SPECIALISTFIELD` VARCHAR(50)  NULL,
    PRIMARY KEY (`ID`),
    UNIQUE INDEX `VET_EMAIL_UNIQUE` (`EMAIL` ASC) VISIBLE
)
    ENGINE = InnoDB;

-- CREATE TABLE LABTESTRESULT
CREATE TABLE `pet_care`.`labtestresult`
(
    `ID`         INT          NOT NULL,
    `ORDEREDAT`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `RESULT`     VARCHAR(500) NOT NULL,
    `RELEASEDAT` DATETIME     NULL,
    PRIMARY KEY (`ID`)
)
    ENGINE = InnoDB;


-- CREATE TABLE TIMESPOT
CREATE TABLE `pet_care`.`timespot`
(
    `ID`        INT  NOT NULL,
    `STARTTIME` TIME NOT NULL,
    `ENDTIME`   TIME NOT NULL,
    PRIMARY KEY (`ID`)
)
    ENGINE = InnoDB;

-- CREATE TABLE LAB
CREATE TABLE `pet_care`.`lab`
(
    `ID`             INT         NOT NULL,
    `NAME`           VARCHAR(45) NOT NULL,
    `LOCATION`       VARCHAR(45) NOT NULL,
    `SUPPORTCONTACT` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`ID`)
)
    ENGINE = InnoDB;

-- CREATE TABLE MEDICALSERVICE
CREATE TABLE `pet_care`.`medicalservice`
(
    `ID`                      INT            NOT NULL,
    `MEDICALSERVICECODE`      VARCHAR(45)    NOT NULL,
    `DESCRIPTION`             VARCHAR(100)   NOT NULL,
    `COSTVALIDFROM`           DATETIME       NOT NULL,
    `COST`                    DECIMAL(10, 2) NOT NULL,
    `REQUIRESSPECIALIST`      BOOLEAN        NOT NULL,
    `REQUIRESSPECIALISTFIELD` VARCHAR(45)    NOT NULL,
    `LABID`                   INT            NULL,
    `NEEDSBOOKINGBYVET`       BOOLEAN        NOT NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `FK_LAB_ID`
        FOREIGN KEY (`LABID`)
            REFERENCES `lab` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- CREATE TABLE VETASSIGNMENT
CREATE TABLE `pet_care`.`vetassignment`
(
    `ID`     INT  NOT NULL,
    `VETID`  INT  NOT NULL,
    `SPOTID` INT  NOT NULL,
    `DATE`   DATE NOT NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `FK_VET_ID`
        FOREIGN KEY (`VETID`)
            REFERENCES `vet` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `FK_SPOT_ID`
        FOREIGN KEY (`SPOTID`)
            REFERENCES `timespot` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- CREATE TABLE APPOINTMENT
CREATE TABLE `pet_care`.`appointment`
(
    `ID`                   INT                                   NOT NULL AUTO_INCREMENT,
    `CUSTOMERID`           INT                                   NULL,
    `PETID`                INT                                   NULL,
    `VETASSIGNMENTID`      INT                                   NOT NULL,
    `CONFIRMEDAT`          DATETIME                              NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `CUSTOMERPHONENUMBER`  VARCHAR(15)                           NOT NULL,
    `CUSTOMERNAME`         VARCHAR(100)                          NOT NULL,
    `SPECIES`              ENUM ('DOG', 'CAT', 'BIRD', 'RABBIT') NOT NULL,
    `PURPOSEDESCRIPTION`   VARCHAR(300)                          NOT NULL,
    `VETNOTES`             VARCHAR(800)                          NULL,
    `TOTALPRICE`           DECIMAL(10, 2)                        NOT NULL,
    `MEDICATIONPRESCRIBED` VARCHAR(500)                          NULL,
    `ISPAID`               BOOLEAN                               NOT NULL,
    `PAIDAT`               DATETIME                              NULL,
    `PAYMENTMETHOD`        ENUM ('CASH', 'CARD')                 NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `FK_CUSTOMER_ID`
        FOREIGN KEY (`CUSTOMERID`)
            REFERENCES `customer` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `FK_PET_ID`
        FOREIGN KEY (`PETID`)
            REFERENCES `pet` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `FK_VET_ASSIGNMENT_ID`
        FOREIGN KEY (`VETASSIGNMENTID`)
            REFERENCES `vetassignment` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- CREATE TABLE MEDICALSERVICEBOOKED
CREATE TABLE `pet_care`.`medicalserviceboooked`
(
    `APPOINTMENTID`       INT            NOT NULL,
    `SERVICEID`           INT            NOT NULL,
    `RESULTID`            INT            NULL,
    `COSTATCONFIRMEDTIME` DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (`APPOINTMENTID`, `SERVICEID`),
    CONSTRAINT `FK_APPOINTMENT_ID`
        FOREIGN KEY (`APPOINTMENTID`)
            REFERENCES `appointment` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `FK_SERVICE_ID`
        FOREIGN KEY (`SERVICEID`)
            REFERENCES `medicalservice` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `FK_TEST_RESULT_ID`
        FOREIGN KEY (`RESULTID`)
            REFERENCES `labtestresult` (`ID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
