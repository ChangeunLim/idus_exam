DROP DATABASE  IF EXISTS `web`;
CREATE DATABASE  IF NOT EXISTS `web` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `web`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 10.10.10.100    Database: web
-- ------------------------------------------------------
-- Server version	5.5.5-10.6.18-MariaDB-0ubuntu0.22.04.1-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `a`
--

DROP TABLE IF EXISTS `a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a`
(
    `idx`   bigint(20) NOT NULL AUTO_INCREMENT,
    `value` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a`
--

LOCK
TABLES `a` WRITE;
/*!40000 ALTER TABLE `a` DISABLE KEYS */;
INSERT INTO `a`
VALUES (1, 'a 01'),
       (2, 'a 02'),
       (3, 'a 03'),
       (4, 'a 04');
/*!40000 ALTER TABLE `a` ENABLE KEYS */;
UNLOCK
TABLES;


--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member`
(
    `enabled`   bit(1) NOT NULL,
    `idx`       bigint(20) NOT NULL AUTO_INCREMENT,
    `email`     varchar(255) DEFAULT NULL,
    `nick_name` varchar(255) DEFAULT NULL,
    `password`  varchar(255) DEFAULT NULL,
    `role`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK
TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK
TABLES;



--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course`
(
    `price`       int(11) NOT NULL,
    `idx`         bigint(20) NOT NULL AUTO_INCREMENT,
    `member_idx`  bigint(20) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `detail`      varchar(255) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`),
    KEY           `FK42n8kd84yhu6m5wtmafpikiti` (`member_idx`),
    CONSTRAINT `FK42n8kd84yhu6m5wtmafpikiti` FOREIGN KEY (`member_idx`) REFERENCES `member` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK
TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `email_verify`
--

DROP TABLE IF EXISTS `email_verify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_verify`
(
    `idx`        bigint(20) NOT NULL AUTO_INCREMENT,
    `member_idx` bigint(20) DEFAULT NULL,
    `uuid`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`),
    KEY          `FKp8avtnemq9n8xbm9pbb6vq69u` (`member_idx`),
    CONSTRAINT `FKp8avtnemq9n8xbm9pbb6vq69u` FOREIGN KEY (`member_idx`) REFERENCES `member` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_verify`
--

LOCK
TABLES `email_verify` WRITE;
/*!40000 ALTER TABLE `email_verify` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_verify` ENABLE KEYS */;
UNLOCK
TABLES;


--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section`
(
    `course_idx` bigint(20) DEFAULT NULL,
    `idx`        bigint(20) NOT NULL AUTO_INCREMENT,
    `name`       varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`),
    KEY          `FKrnev105yvkxxkwyoaurde1ek5` (`course_idx`),
    CONSTRAINT `FKrnev105yvkxxkwyoaurde1ek5` FOREIGN KEY (`course_idx`) REFERENCES `course` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK
TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture`
(
    `seconds`     int(11) NOT NULL,
    `idx`         bigint(20) NOT NULL AUTO_INCREMENT,
    `section_idx` bigint(20) DEFAULT NULL,
    `name`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`idx`),
    KEY           `FKpul38wdjubvexf8stxsvcx3el` (`section_idx`),
    CONSTRAINT `FKpul38wdjubvexf8stxsvcx3el` FOREIGN KEY (`section_idx`) REFERENCES `section` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK
TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK
TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-12 11:11:27

INSERT INTO `web`.`member`
(`enabled`,`idx`,`email`,`nick_name`,`password`,`role`)
VALUES
    (true, 1, 'test01@test.com', 'test01', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER'),
    (true, 2, 'test02@test.com', 'test02', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER'),
    (true, 3, 'test03@test.com', 'test03', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER'),
    (true, 4, 'test04@test.com', 'test04', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER'),
    (true, 5, 'test05@test.com', 'test05', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER'),
    (true, 6, 'test06@test.com', 'test06', '$2a$10$6K6Yw2tYCwoXBTP4VbiHruDIrystrRH0MNr/rxDoumhKGbTFIT9Be', 'USER');


INSERT INTO `web`.`course`
(`description`,`detail`,`name`,`price`,`member_idx`)
VALUES
    ('강의 설명 01', '강의 상세 내용 01', '강의 01', 1000, 1),
    ('강의 설명 01', '강의 상세 내용 02', '강의 02', 2000, 1),
    ('강의 설명 02', '강의 상세 내용 03', '강의 03', 3000, 1),
    ('강의 설명 03', '강의 상세 내용 04', '강의 04', 4000, 2),
    ('강의 설명 04', '강의 상세 내용 05', '강의 05', 5000, 2),
    ('강의 설명 05', '강의 상세 내용 06', '강의 06', 6000, 3);