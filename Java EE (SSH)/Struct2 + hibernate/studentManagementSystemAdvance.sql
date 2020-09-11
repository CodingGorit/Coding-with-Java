/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.62 : Database - studentmanagementsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentmanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `studentmanagementsystem`;

/*Table structure for table `classz` */

DROP TABLE IF EXISTS `classz`;

CREATE TABLE `classz` (
  `grade` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clasz` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stuId` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stuId`),
  CONSTRAINT `classz_ibfk_1` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `classz` */

insert  into `classz`(`grade`,`clasz`,`stuId`) values ('大三','新闻3班','20172345'),(NULL,NULL,'20181121'),('大二','计科4班','20181122'),('大二','计科中软2班','20183349'),('大二','通信4班','20184429'),('大二','动画3班','20187794'),('大一','电信4班','20193319'),('大一','汉语言3班','20194411');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stuId` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `stuName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `stuAge` tinyint(3) DEFAULT NULL,
  `classz` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `student` */

insert  into `student`(`stuId`,`stuName`,`stuAge`,`classz`) values ('20172345','张冲',22,'大三 新闻3班'),('20181121','多多',20,'大二 电信4班'),('20181122','江夏',20,'大二 计科4班'),('20183349','小张',20,'大二 计科中软2班'),('20184429','徐家多',20,'大二 通信4班'),('20187794','华晓慧',19,'大二 动画3班'),('20193319','长小白',18,'大一 电信4班'),('20194411','小菊',18,'大一 汉语言3班');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` tinyint(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`) values (1,'Administrator','123456'),(2,'bbbccc','123321');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
