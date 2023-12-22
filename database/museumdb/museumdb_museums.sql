-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: museumdb
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `museums`
--

DROP TABLE IF EXISTS `museums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `museums` (
  `museum_id` bigint NOT NULL AUTO_INCREMENT,
  `museum_name` varchar(500) DEFAULT NULL,
  `city` varchar(500) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `working_hours` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `website` varchar(500) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`museum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `museums`
--

LOCK TABLES `museums` WRITE;
/*!40000 ALTER TABLE `museums` DISABLE KEYS */;
INSERT INTO `museums` VALUES (93,'Contemporary Art Museum of Macedonia','Skopje','Самоилова','msu-info@msuskopje.org.mk','Tu-Sa 10:00-15:00; Su 09:00-13:00','+389 2 3117734','https://msu.mk/home/',NULL),(94,'Museum of Macedonia','Skopje','Прохор Пчински',NULL,NULL,NULL,NULL,NULL),(95,'Museum of the Macedonian struggle','Skopje','11 Март','mmb@mmb.org.mk','Tu-Su 10:00-18:00','+389 2 3256 667','http://mmb.org.mk/w/',NULL),(96,'Museum of the City of Skopje','Skopje',NULL,NULL,NULL,'+389 2 3114742','http://www.mgs.org.mk/',NULL),(97,'Memorial House of Mother Teresa','Skopje','Македонија','info@memorialhouseofmotherteresa.org','Mo-Fr 09:00-20:00, Sa-Su 09:00-14:00','+389 2 3290674','http://www.memorialhouseofmotherteresa.org/',NULL),(98,'Daut Pasha Hamam National Gallery','Skopje',NULL,'contact@nationalgallery.mk','Tu-Su 10:00-18:00','+389 2 3133102','https://nationalgallery.mk/',NULL),(99,'Куршумли-ан','Skopje',NULL,NULL,NULL,NULL,NULL,NULL),(100,'Holocaust Memorial Center for the Jews of Macedonia','Skopje','Самоилова','info@holocaustfund.org.mk',NULL,'+389 2 3122697','https://www.holocaustfund.org/',NULL),(101,'Macedonian Museum of Natural History',NULL,NULL,NULL,'Tu-Su 09:00-16:00',NULL,NULL,NULL),(102,'Museum',NULL,'Александар Македонски',NULL,NULL,NULL,'https://www.muzejprilep.org.mk',NULL),(103,'Museum of the Ilinden Uprising and the Republic of Krushevo',NULL,'Димитар Бербероски - Таќа Бербер',NULL,NULL,'+38970619597;+38970356621',NULL,NULL),(104,'Македониум',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(105,'Музеј Штип',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(106,'People\'s hero Kuzman Josifoski-Pitu Memorial museum',NULL,'Мара Јосифоска-Ѓурѓа',NULL,NULL,NULL,NULL,NULL),(107,'Archaeological Museum of Macedonia','Skopje',NULL,NULL,'Tu-Su 10:00-18:00',NULL,NULL,NULL),(108,'Museum of illusions',NULL,'Максим Горки',NULL,NULL,NULL,NULL,NULL),(109,'Auto and etno museum \"Filip\"',NULL,NULL,NULL,NULL,NULL,'http://www.muzejkrklino.mk/en/',NULL),(110,'Muzeu \"Dëshmorët e kombit\"',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(111,'Безистен Штип',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(112,'Blazhe Koneski Memorial House',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(113,'Tatarchev House',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(114,'Museum of Bitola',NULL,'Св. Климент Охридски',NULL,NULL,NULL,NULL,NULL),(115,'Museum Teracotta',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(116,'City Museum',NULL,'Sveti Joakim Osogovski',NULL,NULL,NULL,NULL,NULL),(117,'Muzej Galerija Kavadarci',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,'Memorial house - Strasho Pindjur',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,'Goce Delchev Memorial House',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(120,'Magaza gallery',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(121,'Kosturnica Memorial',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(122,'October the 11th, 1941',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(123,'Ethnographic museum',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(124,'Museum Strumica',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(125,'Museum of Galichnik\'s cultural heritage',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(126,'House of Lambeski',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(127,'Robev Family House',NULL,'Цар Самоил',NULL,'Tu-Su 09:00-14:00',NULL,'http://muzejohrid.mk/en/house-of-robev-family',NULL),(128,'Народен Музеј',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(129,'Gallery RA',NULL,'Војвода Васил Чакаларов','galerija.ra@gmail.com','Mo-Sa 10:00-20:00','+389075435402',NULL,NULL),(130,'Музеј на НОВ',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(131,'Foundry',NULL,'Тома Никлев',NULL,NULL,'+38970356621;+38975202123',NULL,NULL),(132,'Berovo Town Museum',NULL,NULL,NULL,NULL,NULL,'http://www.berovo.gov.mk/index.php?option=com_content&view=article&id=76&Itemid=117',NULL),(133,'Museum of Wine',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(134,'Mémorial de Bitola',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(135,'Ловен Дом',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(136,'Музеј на Дојран',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(137,'1 Бригада',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(138,'Bay of Bones',NULL,NULL,NULL,'Tu-Su 09:00-16:15',NULL,NULL,NULL);
/*!40000 ALTER TABLE `museums` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-22 21:40:25
