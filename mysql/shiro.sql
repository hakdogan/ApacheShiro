CREATE USER 'shiro_user'@'%' IDENTIFIED BY 'shiro';
GRANT ALL PRIVILEGES ON shiro.* TO 'shiro_user'@'%' WITH GRANT OPTION;

CREATE DATABASE  IF NOT EXISTS `shiro`
/*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci */;

USE `shiro`;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
                        `password` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hakdogan','$shiro1$SHA-256$500000$WQ0P4lVCYUqBXp7QWe5W8A==$l5f4v+0PGNIpqxRUb77Sn0IxNWIjreb7Fn1bqYFoSUo='),(2,'guest','$shiro1$SHA-256$500000$TGn64LGntH7bcZkyqdQacg==$8l+lHwug0PSwPYoLDEwCeFQrxh2vgZiT96b17UUqabA=');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
                             `userID` int(11) NOT NULL,
                             `role` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
                             PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,'admin'),(2,'guest');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;
