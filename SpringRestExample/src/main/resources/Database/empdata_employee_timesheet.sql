-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: empdata
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee_timesheet`
--

DROP TABLE IF EXISTS `employee_timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_timesheet` (
  `time_sheet_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `emp_user_id` bigint(50) NOT NULL,
  `Category_id` bigint(50) NOT NULL,
  `app_id` bigint(50) NOT NULL,
  `area` varchar(35) DEFAULT NULL,
  `td_date` date NOT NULL,
  `ticket_id` varchar(35) DEFAULT NULL,
  `task_desc` varchar(35) DEFAULT NULL,
  `td_hours` bigint(50) DEFAULT NULL,
  `updated_timestamp` datetime DEFAULT NULL,
  `created_timestamp` datetime DEFAULT NULL,
  `Area_id` bigint(50) NOT NULL,
  PRIMARY KEY (`time_sheet_id`),
  KEY `areaId_idx` (`Area_id`),
  KEY `emp_user_id_idx` (`emp_user_id`,`Area_id`),
  KEY `appFK_idx` (`app_id`),
  KEY `categoryFK_idx` (`Category_id`),
  CONSTRAINT `appFK` FOREIGN KEY (`app_id`) REFERENCES `app_details` (`app_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `areaFK` FOREIGN KEY (`Area_id`) REFERENCES `area_details` (`area_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `categoryFk` FOREIGN KEY (`Category_id`) REFERENCES `category_details` (`Category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employeeFk` FOREIGN KEY (`emp_user_id`) REFERENCES `employee_details` (`emp_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_timesheet`
--

LOCK TABLES `employee_timesheet` WRITE;
/*!40000 ALTER TABLE `employee_timesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_timesheet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 12:47:53
