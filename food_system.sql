-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: food_system
-- ------------------------------------------------------
-- Server version	8.0.31
create database food_system;
use food_system;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES gbk */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `materialNo` char(5) NOT NULL,
  `materialName` varchar(10) NOT NULL,
  `materialUnitPrice` double NOT NULL DEFAULT '0',
  `materialNumber` smallint NOT NULL DEFAULT '0',
  `materialDate` date NOT NULL DEFAULT '0000-00-00',
  `materialType` varchar(4) NOT NULL,
  PRIMARY KEY (`materialNo`),
  UNIQUE KEY `materialNo` (`materialNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES ('10001','酱油',24,32,'2022-02-01','调味料'),('10002','盐',2,32,'2022-02-01','调味料'),('10004','食用油',49.99,3,'2023-12-08','调味料'),('10005','x',1,2,'2023-12-09','xx'),('10006','aa',1,2,'2023-11-29','xx'),('20003','番茄',3,48,'2022-02-02','蔬菜类'),('40003','鸡蛋',1,48,'2022-02-11','蛋类');
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menuNo` char(6) NOT NULL,
  `menuName` varchar(10) NOT NULL,
  `menuPrice` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`menuNo`),
  UNIQUE KEY `menuNo` (`menuNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('000001','番茄炒鸡蛋',19.989999771118164),('000002','青椒肉丝',24.989999771118164),('000003','北京烤鸭',59.9900016784668),('000004','白切鸡',39.99);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderNo` char(5) NOT NULL,
  `orderContent` varchar(30) NOT NULL,
  `orderPrice` double NOT NULL,
  `orderDate` date NOT NULL,
  PRIMARY KEY (`orderNo`),
  UNIQUE KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('00001','番茄炒鸡蛋*2',39.98,'2022-03-01'),('00002','番茄炒鸡蛋*1青椒肉丝*1',44.98,'2022-03-02'),('2','2',1,'2023-12-06');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewNo` char(6) NOT NULL,
  `orderNo` char(5) NOT NULL,
  `reviewContent` varchar(30) NOT NULL,
  `orderDate` date NOT NULL,
  PRIMARY KEY (`reviewNo`),
  UNIQUE KEY `reviewNo` (`reviewNo`),
  KEY `orderNo` (`orderNo`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`orderNo`) REFERENCES `order` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES ('000001','00001','烤鸭太咸了','2022-03-01'),('000002','00002','青椒肉丝没几条肉丝','2022-03-09');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` varchar(7) NOT NULL,
  `userName` varchar(10) NOT NULL,
  `userPassword` varchar(12) NOT NULL,
  `userAuthority` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0','test0','0',0),('0001','小明','123456',0),('0002','小航','abc123',1),('1','test1','1',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-10 13:12:19
