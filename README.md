# Apache Shiro

This application illustrates and demonstrates use of the Apache Shiro JDBC Realm with MySQL Database and Java web application(JSF2.2) 

<br>
**Exemplified topics**

* Authentication
* Authorization
* JDBC Realm
* RememberMe functionality

<br>
**SQL Schema**
--
<pre>

CREATE DATABASE `shiro`;

USE `shiro`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

CREATE TABLE `userroles` (
  `userID` int(11) NOT NULL,
  `role` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;


</pre>

<br>
**A screenshot of the application**
--
<img src="http://i59.tinypic.com/2mxio37.png"/>