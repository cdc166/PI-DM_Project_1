CREATE DATABASE IF NOT EXISTS `cs336project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cs336project`;

-- Table structure for table `User`
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `UserType` enum('buyer','seller','admin','staff') NOT NULL,
  `PhoneNumber` bigint DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `User`
LOCK TABLES `User` WRITE;
INSERT INTO `User` VALUES (1,'Test User','testuser','yourpassword','test@example.com','buyer',2018882232);
UNLOCK TABLES;

-- Table structure for table `Items`
DROP TABLE IF EXISTS `Items`;
CREATE TABLE `Items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  `starting_bid` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Inserting data into table `Items`
INSERT INTO `Items` (Name, Description, StartingBid) VALUES
('Antique Vase', 'A beautiful antique vase from the 19th century.', 50.00),
('Vintage Watch', 'A rare vintage watch in excellent condition.', 75.00),
('Painting', 'An original painting by a renowned artist.', 200.00);

