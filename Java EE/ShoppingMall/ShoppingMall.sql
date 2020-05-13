/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.62 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;


/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` float DEFAULT NULL,
  `introduce` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

insert  into `product`(`pid`,`product_name`,`price`,`introduce`,`address`) values (1,'冰箱',2400,'海尔牌冰箱','杭州'),(2,'小米手机',2199,'小米牌手机，性价比之王','武汉'),(3,'MAC 口红',399,'MAC 最新上市','美国 加利福尼亚'),(4,'旺仔牛奶',40,'旺仔牛奶，你的最爱','北京'),(5,'辣条',5,'最爱辣条','江苏 南京'),(6,'牛奶',39.9,'蒙牛牛奶','新疆'),(7,'tedt',20,'test','你猜'),(8,'华为手机',3999,'华为 mate40 pro','武汉');

/*Table structure for table `shopcart` */

DROP TABLE IF EXISTS `shopcart`;

CREATE TABLE `shopcart` (
  `shop_no` tinyint(5) NOT NULL AUTO_INCREMENT,
  `pid` int(5) DEFAULT NULL,
  `uid` int(5) DEFAULT NULL,
  `num` tinyint(5) DEFAULT NULL,
  PRIMARY KEY (`shop_no`),
  KEY `shop_pid` (`pid`),
  KEY `shop_uid` (`uid`),
  CONSTRAINT `shop_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `shop_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `shopcart` */

insert  into `shopcart`(`shop_no`,`pid`,`uid`,`num`) values (1,1,1,9),(3,4,1,10),(4,5,1,17),(9,8,1,1),(10,2,1,1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` tinyint(5) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sage` tinyint(3) DEFAULT NULL,
  `sgender` enum('男','女') COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`sname`,`sage`,`sgender`) values (1,'张三',18,'男'),(2,'李四',18,'女'),(3,'李畅',19,'男'),(4,'蔡江',20,'女'),(5,'徐丽丽',18,'女'),(6,'王四',12,'男'),(7,'李洋',20,'男'),(8,'蓉蓉',18,'女'),(9,'小小',19,'男'),(10,'张小龙',20,'男');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'aaaaaa','bbbbbb');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
