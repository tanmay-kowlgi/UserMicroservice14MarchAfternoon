drop schema userdb;
CREATE DATABASE `userdb` ;

USE `userdb`;



CREATE TABLE `buyer` (
  
`BUYERID` int(11) NOT NULL auto_increment,
  
`NAME` varchar(45) NOT NULL,
  
`EMAIL` varchar(45) NOT NULL,
  
`PHONENUMBER` varchar(45) NOT NULL ,
  
`PASSWORD` varchar(45) NOT NULL,
  
`ISPRIVILEGED` tinyint(1) DEFAULT NULL,
  
`REWARDPOINTS` int(11) DEFAULT NULL,
  
`ISACTIVE` tinyint(1) DEFAULT NULL,
 
 PRIMARY KEY (`BUYERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `buyer` AUTO_INCREMENT=1;



CREATE TABLE `cart` (
  
`BUYERID` int(11) NOT NULL,
  
`PRODID` int(11) NOT NULL,
  
`QUANTITY` int(11) NOT NULL,
  
PRIMARY KEY (`BUYERID`,`PRODID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `seller` (
  
`SELLERID` int(11) NOT NULL auto_increment,
  
`NAME` varchar(45) NOT NULL,
  
`EMAIL` varchar(45) NOT NULL,
  
`PHONENUMBER` varchar(45) NOT NULL ,
  
`PASSWORD` varchar(45) NOT NULL,
  
`ISACTIVE` tinyint(1) DEFAULT NULL,
  
PRIMARY KEY (`SELLERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `seller` AUTO_INCREMENT=1;


CREATE TABLE `wishlist` (
  
`BUYERID` int(11) NOT NULL,
  
`PRODID` int(11) NOT NULL,
  
PRIMARY KEY (`BUYERID`,`PRODID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



show tables;
select * from buyer;
select * from seller;
select * from cart;
select * from wishlist;