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
-- Table structure for table `navriti_details`
--

DROP TABLE IF EXISTS `navriti_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navriti_details` (
  `idea_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `emp_user_id` bigint(50) NOT NULL,
  `idea_stage` varchar(30) DEFAULT NULL,
  `stage_outcome` varchar(30) DEFAULT NULL,
  `submission_date` date DEFAULT NULL,
  `portfolio` varchar(30) DEFAULT NULL,
  `application_name` varchar(30) DEFAULT NULL,
  `submitted_by` varchar(30) DEFAULT NULL,
  `idea_classification` varchar(30) DEFAULT NULL,
  `problem_statement` varchar(30) DEFAULT NULL,
  `solution_description` varchar(30) DEFAULT NULL,
  `ideation_date` date DEFAULT NULL,
  `per_hour_dollar_rate` int(11) DEFAULT NULL,
  `annual_effort_savings` bigint(50) DEFAULT NULL,
  `sme_review_date` date DEFAULT NULL,
  `council_review_date` date DEFAULT NULL,
  `client_review_date` date DEFAULT NULL,
  `implementation_date` date DEFAULT NULL,
  `savings` bigint(50) DEFAULT NULL,
  `elapsed_time` int(11) DEFAULT NULL,
  `client` varchar(20) DEFAULT NULL,
  `technology` varchar(20) DEFAULT NULL,
  `comments` text,
  PRIMARY KEY (`idea_id`),
  KEY `navritiEmpFk_idx` (`emp_user_id`),
  CONSTRAINT `navritiEmpFk` FOREIGN KEY (`emp_user_id`) REFERENCES `employee_details` (`emp_user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navriti_details`
--

LOCK TABLES `navriti_details` WRITE;
/*!40000 ALTER TABLE `navriti_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `navriti_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 12:47:54
