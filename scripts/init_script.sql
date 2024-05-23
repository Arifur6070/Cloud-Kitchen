CREATE DATABASE IF NOT EXISTS cloud_kitchen;
CREATE USER IF NOT EXISTS 'chef'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON cloud_kitchen.* TO 'chef'@'%';
FLUSH PRIVILEGES;


USE cloud_kitchen;


-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: cloud_kitchen
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `address_id` bigint NOT NULL AUTO_INCREMENT,
  `address_type` enum('BILLING_ADDRESS','PERMANENT_ADDRESS') DEFAULT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `country_name` varchar(255) DEFAULT NULL,
  `house_number` int NOT NULL,
  `postal_code` int NOT NULL,
  `road_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK1fa36y2oqhao3wgg2rw1pi459` (`user_id`),
  CONSTRAINT `FK1fa36y2oqhao3wgg2rw1pi459` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (2,'PERMANENT_ADDRESS','Bamberg','Germany',5,96052,'Josef-Kindshoven-str',3);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_orders`
--

DROP TABLE IF EXISTS `customer_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `is_delivered` bit(1) NOT NULL,
  `is_dispatched` bit(1) NOT NULL,
  `order_date_time` datetime(6) DEFAULT NULL,
  `total_price` double NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `drinks_order_items` varbinary(1024) DEFAULT NULL,
  `food_order_items` varbinary(1024) DEFAULT NULL,
  `customer_order_id` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_orders`
--

LOCK TABLES `customer_orders` WRITE;
/*!40000 ALTER TABLE `customer_orders` DISABLE KEYS */;
INSERT INTO `customer_orders` VALUES (1,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(2,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(3,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(4,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(5,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(6,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(7,_binary '\0',_binary '\0','2024-05-18 12:00:00.000000',50.5,'3',NULL,NULL,''),(8,_binary '\0',_binary '\0','2024-05-21 17:23:01.476909',50.5,'3',NULL,NULL,''),(9,_binary '\0',_binary '\0','2024-05-21 21:11:41.061253',50.5,'3',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0\'com.cloud.kitchen.model.DrinksOrderItemt~ù3?\Z/\0J\0drinkOrderItemIdI\0quantityL\0drinkt\0 Lcom/cloud/kitchen/model/Drinks;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0\0sr\0com.cloud.kitchen.model.Drinks_»¥Ò\ÖK\0J\0drinkIdD\0\ndrinkPriceI\0stockL\0	drinkNameq\0~\0L\0	imagePathq\0~\0xp\0\0\0\0\0\0\0@\0\0\0\0\0\0\0\0\0at\0Coke Normalt\0\'/images/20240518_181550_Coke_Normal.pngt\0$c5157e54-2b16-4f71-b1ee-e758153d231bsq\0~\0\0\0\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0\0\0\0\r@\0\0\0\0\0\0\0\0\0ct\0\nCoke Lightt\0/images/orange_juice.jpgt\0$c5157e54-2b16-4f71-b1ee-e758153d231bx',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0%com.cloud.kitchen.model.FoodOrderItem3 \rù;G\r\0J\0foodOrderItemIdI\0quantityL\0foodItemt\0Lcom/cloud/kitchen/model/Item;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0%\0\0\0sr\0com.cloud.kitchen.model.ItemóŠµ\ZØn\0J\0itemIdD\0priceD\0ratingL\0	imagePathq\0~\0L\0mealTypet\0\"Lcom/cloud/kitchen/model/enm/Menu;L\0nameq\0~\0xp\0\0\0\0\0\0\0@%\0\0\0\0\0\0@\0\0\0\0\0\0t\0)/images/20240518_184137_Beef_Biriyani.jpg~r\0 com.cloud.kitchen.model.enm.Menu\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0LUNCHt\0\rBeef Biriyanit\0$c5157e54-2b16-4f71-b1ee-e758153d231bsq\0~\0\0\0\0\0\0\0\0&\0\0\0sq\0~\0\0\0\0\0\0\0\0@\'\0\0\0\0\0\0@\0\0\0\0\0\0t\0,/images/20240518_184118_Mutton_Biriyani.jpg q\0~\0t\0Mutton Biriyanit\0$c5157e54-2b16-4f71-b1ee-e758153d231bx','c5157e54-2b16-4f71-b1ee-e758153d231b'),(10,_binary '\0',_binary '\0','2024-05-21 21:41:56.366352',50.5,'3',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0\'com.cloud.kitchen.model.DrinksOrderItemt~ù3?\Z/\0J\0drinkOrderItemIdI\0quantityL\0drinkt\0 Lcom/cloud/kitchen/model/Drinks;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0\0sr\0com.cloud.kitchen.model.Drinks_»¥Ò\ÖK\0J\0drinkIdD\0\ndrinkPriceI\0stockL\0	drinkNameq\0~\0L\0	imagePathq\0~\0xp\0\0\0\0\0\0\0@\0\0\0\0\0\0\0\0\0dt\0Coke Normalt\0\'/images/20240518_181550_Coke_Normal.pngt\0$f8091f5c-04a2-4dad-9c21-28ffa1796b33sq\0~\0\0\0\0\0\0\0\0 \0\0\0sq\0~\0\0\0\0\0\0\0\0\r@\0\0\0\0\0\0\0\0\0dt\0\nCoke Lightt\0/images/orange_juice.jpgt\0$f8091f5c-04a2-4dad-9c21-28ffa1796b33x',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0%com.cloud.kitchen.model.FoodOrderItem3 \rù;G\r\0J\0foodOrderItemIdI\0quantityL\0foodItemt\0Lcom/cloud/kitchen/model/Item;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\'\0\0\0sr\0com.cloud.kitchen.model.ItemóŠµ\ZØn\0J\0itemIdD\0priceD\0ratingL\0	imagePathq\0~\0L\0mealTypet\0\"Lcom/cloud/kitchen/model/enm/Menu;L\0nameq\0~\0xp\0\0\0\0\0\0\0@%\0\0\0\0\0\0@\0\0\0\0\0\0t\0)/images/20240518_184137_Beef_Biriyani.jpg~r\0 com.cloud.kitchen.model.enm.Menu\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0LUNCHt\0\rBeef Biriyanit\0$f8091f5c-04a2-4dad-9c21-28ffa1796b33sq\0~\0\0\0\0\0\0\0\0(\0\0\0sq\0~\0\0\0\0\0\0\0\0@\'\0\0\0\0\0\0@\0\0\0\0\0\0t\0,/images/20240518_184118_Mutton_Biriyani.jpg q\0~\0t\0Mutton Biriyanit\0$f8091f5c-04a2-4dad-9c21-28ffa1796b33x','f8091f5c-04a2-4dad-9c21-28ffa1796b33'),(11,_binary '\0',_binary '\0','2024-05-21 21:42:22.503522',50.5,'3',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0\'com.cloud.kitchen.model.DrinksOrderItemt~ù3?\Z/\0J\0drinkOrderItemIdI\0quantityL\0drinkt\0 Lcom/cloud/kitchen/model/Drinks;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0!\0\0\0sr\0com.cloud.kitchen.model.Drinks_»¥Ò\ÖK\0J\0drinkIdD\0\ndrinkPriceI\0stockL\0	drinkNameq\0~\0L\0	imagePathq\0~\0xp\0\0\0\0\0\0\0@\0\0\0\0\0\0\0\0\0dt\0Coke Normalt\0\'/images/20240518_181550_Coke_Normal.pngt\0$058aca58-b3ae-453b-8fbf-886711a3c73bsq\0~\0\0\0\0\0\0\0\0\"\0\0\0sq\0~\0\0\0\0\0\0\0\0\r@\0\0\0\0\0\0\0\0\0dt\0\nCoke Lightt\0/images/orange_juice.jpgt\0$058aca58-b3ae-453b-8fbf-886711a3c73bx',_binary '¬\í\0sr\0java.util.ArrayListx\Ò\Ça\0I\0sizexp\0\0\0w\0\0\0sr\0%com.cloud.kitchen.model.FoodOrderItem3 \rù;G\r\0J\0foodOrderItemIdI\0quantityL\0foodItemt\0Lcom/cloud/kitchen/model/Item;L\0orderIdt\0Ljava/lang/String;xp\0\0\0\0\0\0\0)\0\0\0sr\0com.cloud.kitchen.model.ItemóŠµ\ZØn\0J\0itemIdD\0priceD\0ratingL\0	imagePathq\0~\0L\0mealTypet\0\"Lcom/cloud/kitchen/model/enm/Menu;L\0nameq\0~\0xp\0\0\0\0\0\0\0@%\0\0\0\0\0\0@\0\0\0\0\0\0t\0)/images/20240518_184137_Beef_Biriyani.jpg~r\0 com.cloud.kitchen.model.enm.Menu\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0LUNCHt\0\rBeef Biriyanit\0$058aca58-b3ae-453b-8fbf-886711a3c73bsq\0~\0\0\0\0\0\0\0\0*\0\0\0sq\0~\0\0\0\0\0\0\0\0@\'\0\0\0\0\0\0@\0\0\0\0\0\0t\0,/images/20240518_184118_Mutton_Biriyani.jpg q\0~\0t\0Mutton Biriyanit\0$058aca58-b3ae-453b-8fbf-886711a3c73bx','058aca58-b3ae-453b-8fbf-886711a3c73b');
/*!40000 ALTER TABLE `customer_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drinks`
--

DROP TABLE IF EXISTS `drinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drinks` (
  `drink_id` bigint NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(255) DEFAULT NULL,
  `drink_price` double NOT NULL,
  `stock` int NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`drink_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drinks`
--

LOCK TABLES `drinks` WRITE;
/*!40000 ALTER TABLE `drinks` DISABLE KEYS */;
INSERT INTO `drinks` VALUES (6,'Mango Lassi',8.5,100,NULL),(7,'Lassi',7.5,100,'src/main/resources/images/drinks/Lassi.jpg'),(8,'Fanta',5.5,100,'src/main/resources/static/images/drinks/20240516_014611_fanta.jpeg'),(9,'Fanta',5.5,100,'src/main/resources/static/images/20240516_021216_fanta.jpeg'),(10,'Fanta',5.5,100,'/images/20240516_021652_fanta.jpeg'),(11,'Pepsi Can',3.5,100,'/images/20240518_181409_pepsi_can.png'),(12,'Pepsi Bottle',4.5,100,'/images/20240518_181504_Pepsi_bottle.jpeg'),(13,'Coke Light',4.5,97,'/images/orange_juice.jpg'),(14,'Coke Normal',4.5,91,'/images/20240518_181550_Coke_Normal.png');
/*!40000 ALTER TABLE `drinks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drinks_order_item`
--

DROP TABLE IF EXISTS `drinks_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drinks_order_item` (
  `drink_order_item_id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `drink_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `customer_order_id` varchar(255) NOT NULL,
  PRIMARY KEY (`drink_order_item_id`),
  KEY `FK55yy8uq4sikmxxyqn1xy6ytt4` (`drink_id`),
  KEY `FKhs4cl7o794ir4jf9y1aqekcwe` (`order_id`),
  CONSTRAINT `FK55yy8uq4sikmxxyqn1xy6ytt4` FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`drink_id`),
  CONSTRAINT `FKhs4cl7o794ir4jf9y1aqekcwe` FOREIGN KEY (`order_id`) REFERENCES `customer_orders` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drinks_order_item`
--

LOCK TABLES `drinks_order_item` WRITE;
/*!40000 ALTER TABLE `drinks_order_item` DISABLE KEYS */;
INSERT INTO `drinks_order_item` VALUES (1,3,14,NULL,''),(2,1,13,NULL,''),(3,3,14,NULL,''),(4,1,13,NULL,''),(5,3,14,NULL,''),(6,1,13,NULL,''),(7,3,14,NULL,''),(8,1,13,NULL,''),(9,3,14,NULL,''),(10,1,13,NULL,''),(11,3,14,NULL,''),(12,1,13,NULL,''),(13,3,14,NULL,''),(14,1,13,NULL,''),(15,3,14,NULL,''),(16,1,13,NULL,''),(17,3,14,NULL,''),(18,1,13,NULL,''),(19,3,14,NULL,'761dc977-2395-47a3-b233-1fb7773c9b65'),(20,1,13,NULL,'761dc977-2395-47a3-b233-1fb7773c9b65'),(21,3,14,NULL,'ac434448-b834-455a-8355-32702553d7b7'),(22,1,13,NULL,'ac434448-b834-455a-8355-32702553d7b7'),(23,3,14,NULL,'3ea80409-5d0b-4dcf-a421-e6b86c33f257'),(24,1,13,NULL,'3ea80409-5d0b-4dcf-a421-e6b86c33f257'),(25,3,14,NULL,'38ff7197-639e-464d-901f-3c3ed310db51'),(26,1,13,NULL,'38ff7197-639e-464d-901f-3c3ed310db51'),(27,3,14,NULL,'992c64ae-7cce-4f41-9c02-8ec98feb4835'),(28,1,13,NULL,'992c64ae-7cce-4f41-9c02-8ec98feb4835'),(29,3,14,NULL,'c5157e54-2b16-4f71-b1ee-e758153d231b'),(30,1,13,NULL,'c5157e54-2b16-4f71-b1ee-e758153d231b'),(31,3,14,NULL,'f8091f5c-04a2-4dad-9c21-28ffa1796b33'),(32,1,13,NULL,'f8091f5c-04a2-4dad-9c21-28ffa1796b33'),(33,3,14,NULL,'058aca58-b3ae-453b-8fbf-886711a3c73b'),(34,1,13,NULL,'058aca58-b3ae-453b-8fbf-886711a3c73b');
/*!40000 ALTER TABLE `drinks_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_order_item`
--

DROP TABLE IF EXISTS `food_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_order_item` (
  `food_order_item_id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `food_item_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `customer_order_id` varchar(255) NOT NULL,
  PRIMARY KEY (`food_order_item_id`),
  KEY `FK2c6jeqnsi01bg5wfwkjj0i7fc` (`food_item_id`),
  KEY `FKho2glxb9a40gl9qorlduqv8t1` (`order_id`),
  CONSTRAINT `FK2c6jeqnsi01bg5wfwkjj0i7fc` FOREIGN KEY (`food_item_id`) REFERENCES `items` (`item_id`),
  CONSTRAINT `FKho2glxb9a40gl9qorlduqv8t1` FOREIGN KEY (`order_id`) REFERENCES `customer_orders` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_order_item`
--

LOCK TABLES `food_order_item` WRITE;
/*!40000 ALTER TABLE `food_order_item` DISABLE KEYS */;
INSERT INTO `food_order_item` VALUES (1,2,6,NULL,''),(2,1,5,NULL,''),(3,2,6,NULL,''),(4,1,5,NULL,''),(5,2,6,NULL,''),(6,1,5,NULL,''),(7,2,6,NULL,''),(8,1,5,NULL,''),(9,2,6,NULL,''),(10,1,5,NULL,''),(11,2,6,NULL,''),(12,1,5,NULL,''),(13,2,6,NULL,''),(14,1,5,NULL,''),(15,2,6,NULL,''),(16,1,5,NULL,''),(17,2,6,NULL,'d60ebf8d-ea6d-40f6-9221-1dc5ee6fd813'),(18,1,5,NULL,'d60ebf8d-ea6d-40f6-9221-1dc5ee6fd813'),(19,2,6,NULL,'f264da7f-e525-4732-99d5-1487963eefd0'),(20,1,5,NULL,'f264da7f-e525-4732-99d5-1487963eefd0'),(21,2,6,NULL,'ca263193-7d9d-40fc-b2a2-41c38c5e26f1'),(22,1,5,NULL,'ca263193-7d9d-40fc-b2a2-41c38c5e26f1'),(23,2,6,NULL,'49105e16-f82c-4228-a3fc-190effa31896'),(24,1,5,NULL,'49105e16-f82c-4228-a3fc-190effa31896'),(25,2,6,NULL,'c3b6f964-fcdd-47f3-8f22-70c0f49ddcdf'),(26,1,5,NULL,'c3b6f964-fcdd-47f3-8f22-70c0f49ddcdf'),(27,2,6,NULL,'761dc977-2395-47a3-b233-1fb7773c9b65'),(28,1,5,NULL,'761dc977-2395-47a3-b233-1fb7773c9b65'),(29,2,6,NULL,'ac434448-b834-455a-8355-32702553d7b7'),(30,1,5,NULL,'ac434448-b834-455a-8355-32702553d7b7'),(31,2,6,NULL,'3ea80409-5d0b-4dcf-a421-e6b86c33f257'),(32,1,5,NULL,'3ea80409-5d0b-4dcf-a421-e6b86c33f257'),(33,2,6,NULL,'38ff7197-639e-464d-901f-3c3ed310db51'),(34,1,5,NULL,'38ff7197-639e-464d-901f-3c3ed310db51'),(35,2,6,NULL,'992c64ae-7cce-4f41-9c02-8ec98feb4835'),(36,1,5,NULL,'992c64ae-7cce-4f41-9c02-8ec98feb4835'),(37,2,6,NULL,'c5157e54-2b16-4f71-b1ee-e758153d231b'),(38,1,5,NULL,'c5157e54-2b16-4f71-b1ee-e758153d231b'),(39,2,6,NULL,'f8091f5c-04a2-4dad-9c21-28ffa1796b33'),(40,1,5,NULL,'f8091f5c-04a2-4dad-9c21-28ffa1796b33'),(41,2,6,NULL,'058aca58-b3ae-453b-8fbf-886711a3c73b'),(42,1,5,NULL,'058aca58-b3ae-453b-8fbf-886711a3c73b');
/*!40000 ALTER TABLE `food_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `meal_type` enum('BREAKFAST','LUNCH','DINNER') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `rating` double NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'/images/20240518_183811_quick-queso-pasta-recipe.jpg','DINNER','Pasta',8,4.6),(2,'/images/20240518_183859_Fish-with-rice.jpg','DINNER','Rice With fish',12,4.7),(3,'/images/20240518_183930_Fish-with-rice.jpg','DINNER','Rice With fish',12,4.7),(4,'/images/20240518_184045_Easy-Chicken-Stir-Fry-1.jpg','DINNER','Fried rice with chicken',10,4.5),(5,'/images/20240518_184118_Mutton_Biriyani.jpg','LUNCH','Mutton Biriyani',11.5,4.5),(6,'/images/20240518_184137_Beef_Biriyani.jpg','LUNCH','Beef Biriyani',10.5,4.5),(7,'/images/20240518_184150_beef_gulash.jpg','LUNCH','Beef Gulash',10.5,4.5),(8,'/images/20240518_184221_veg-sand.jpg','BREAKFAST','Veg Sandwitches',3.5,4.5),(9,'/images/20240518_184334_potato_soup_toast.jpeg','BREAKFAST','Garlic toast with soup',7.5,4.5),(10,'/images/20240518_184404_lentil-dahl-with-naan-bread.jpg','BREAKFAST','Naan Bread with Daal',5.5,4.5);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'jhon.doe@example.com','Jhon',NULL,'Doe','$2a$10$RP26PXXUQ3UaidHFg3x3POg74sFMBJaip7EqF4f9Oa46csKFk9eau');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23  4:16:39



