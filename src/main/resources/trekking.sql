use trakking;

drop table  if exists coeficient;
drop table  if exists deflection_history;
Drop table  if exists food_history;
Drop table  if exists clients;
Drop table  if exists food;

CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` enum('C','D') NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` enum('M','F') NOT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `lifestyle` enum('M','L','A','H','E') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


INSERT INTO clients VALUES
	(NULL, 'Pasha', '11111', 'C', '/img/avatars/pasha.png', '1999-1-28', 'M', 165.9, 66.6, 'A'),
	(NULL, 'Anna', '22222', 'C', '/img/avatars/sasha.png', '1999-12-23', 'W', 168.9, 50.6, 'L'),
	(NULL, 'Lidia', '33333', 'C', '/img/avatars/lidia.jpg', '2000-9-12', 'W', 180.0, 68.8, 'E'),
	(NULL, 'Max', '44444', 'C', '/img/avatars/max.jpg', '2000-9-21', 'M', 185.5, 64.3, 'M');

INSERT INTO clients(name, password, role) VALUES
	('Dr.House', '55555', 'D');
    
CREATE TABLE `coeficient` (
  `value` tinyint(4) NOT NULL,
  `men` double NOT NULL,
  `women` double DEFAULT NULL,
  PRIMARY KEY (`value`)
) ;

INSERT INTO `coeficient`
	VALUES(0, 88.3962, 447.593), 
          (1, 13.397,  9.247),    
          (2, 4.799,   3.098),    
          (3,    5.677,   4.330); 


CREATE TABLE `deflection_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `calories` float NOT NULL,
  `proteins` float NOT NULL,
  `fats` float NOT NULL,
  `carbohydrates` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `deflection_history_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ;

CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `number` int(11) NOT NULL,
  `calories` int(11) NOT NULL,
  `proteins` float NOT NULL,
  `fats` float NOT NULL,
  `carbohydrates` float NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO food VALUES
 (NULL, 'mocarella', 100, 264, 21.2, 20.7, 0.7),
 (NULL, 'apple', 100, 45, 0.4, 0.4, 11.8),
 (NULL, 'pasta', 100, 210, 12.7, 10.7, 0,8),
(NULL, 'red wine', 100, 120, 12.7, 10.7, 0.9),
(NULL, 'dark chocolate', 100, 97, 12.7, 10.7, 0,3),
(NULL, 'oats', 100, 60, 12.7, 10.7, 1,6),
(NULL, 'popcorn', 100, 30, 12.7, 10.7, 0.8),
(NULL, 'meat pie', 100, 400, 12.7, 10.7, 0,9),
(NULL, 'olive oil', 100, 40, 12.7, 6.5, 0.7),
(NULL, 'greek yogurt', 100, 52, 12.7, 10.7, 0.5),
(NULL, 'white bread', 100, 234, 12.7, 8.8, 0,9),
(NULL, 'banana', 100, 82, 12.7, 10.3, 0,4),
(NULL, 'potato chips', 100, 580, 2.7, 10.7, 0,4),
(NULL, 'potato fries', 100, 600, 3.7, 10.7, 0,6);

CREATE TABLE `food_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`history_id`),
  KEY `client_id` (`client_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `food_history_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `food_history_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`)
);
