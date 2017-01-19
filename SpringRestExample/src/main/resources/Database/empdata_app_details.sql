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
-- Table structure for table `app_details`
--

DROP TABLE IF EXISTS `app_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_details` (
  `app_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `app_desc` varchar(35) DEFAULT NULL,
  `portfolio_id` bigint(50) NOT NULL,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_details`
--

LOCK TABLES `app_details` WRITE;
/*!40000 ALTER TABLE `app_details` DISABLE KEYS */;
INSERT INTO `app_details` VALUES (1,'MSC',1),(2,'MED',1),(3,'Speciality - Pega',1),(4,'SAM Pega',1),(5,'Home Delivery',1),(6,'PLB',1),(7,'Application Security',1),(8,'Midrange',1),(9,'Claims OASIS',1),(10,'Mobile POC',1),(11,'Pega Clinical Services',1),(12,'ACN PMO ',1),(13,'B2C -PSO',2),(14,'CDH - PSO',2),(15,'CRD - PSO',2),(16,'eSD  - PSO',2),(17,'Corp Systems',2),(18,'MBM',2),(19,'Admin',2),(20,'ATK',2),(21,'Retail Network - Phoenix',3),(22,'CBT AO',4),(23,'WIMS',4);
/*!40000 ALTER TABLE `app_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-19 12:47:52
