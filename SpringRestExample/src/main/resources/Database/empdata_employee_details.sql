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
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_details` (
  `emp_user_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `emp_sap_id` varchar(35) DEFAULT NULL,
  `emp_name` varchar(35) DEFAULT NULL,
  `accenture_email_id` varchar(35) DEFAULT NULL,
  `personal_email_id` varchar(35) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `project_name` varchar(35) DEFAULT NULL,
  `technology_name` varchar(35) DEFAULT NULL,
  `mobile_number` bigint(50) DEFAULT NULL,
  `aboutMe` varchar(50) DEFAULT NULL,
  `hobbies` varchar(35) DEFAULT NULL,
  `emp_sex` varchar(35) DEFAULT NULL,
  `user_login_id` bigint(50) NOT NULL,
  `app_id` bigint(50) NOT NULL,
  `employee_detailscol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emp_user_id`),
  KEY `user_login_id_idx` (`user_login_id`),
  KEY `app_emp_FK_idx` (`app_id`),
  CONSTRAINT `app_emp_FK` FOREIGN KEY (`app_id`) REFERENCES `app_details` (`app_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userloginFK` FOREIGN KEY (`user_login_id`) REFERENCES `user_login` (`user_login_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
INSERT INTO `employee_details` VALUES (151,'1234','prakash','prakash.koganti@gmail.com','prakash.koganti@gmail.com',NULL,NULL,NULL,9876543210,'prakash','prakash.koganti@gmail.com','male',46,11,NULL),(152,'1234','prakash','prakash.koganti@gmail.com','prakash.koganti@gmail.com','1971-04-06',NULL,NULL,9876543210,'prakash','prakash.koganti@gmail.com','male',47,11,NULL);
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 12:47:57
