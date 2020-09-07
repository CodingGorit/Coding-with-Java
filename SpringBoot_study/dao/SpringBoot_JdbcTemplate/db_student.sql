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

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` tinyint(5) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sage` tinyint(3) DEFAULT NULL,
  `sgender` varchar(20) COLLATE utf8_unicode_ci DEFAULT '男',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`sname`,`sage`,`sgender`) values (1,'张三',18,'男'),(2,'李四',18,'女'),(3,'李畅',19,'男'),(4,'蔡江',20,'女'),(5,'徐丽丽',18,'女'),(6,'王四',12,'男'),(7,'李洋',20,'男'),(8,'蓉蓉',18,'女'),(9,'小小',19,'男'),(10,'张小龙',20,'男'),(13,'ccc',16,'女'),(14,'小爱同学',3,'女'),(16,'小爱同学',16,'女');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
