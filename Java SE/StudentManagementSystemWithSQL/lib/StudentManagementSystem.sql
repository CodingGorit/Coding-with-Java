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

insert  into `classz`(`grade`,`clasz`,`stuId`) values ('大四','物联网4班','20168577'),('大三','软工5班','20173324'),('大二','动画3班','20187794'),('大一','英语4班','20194413');

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

insert  into `student`(`stuId`,`stuName`,`stuAge`,`classz`) values ('20168577','章子怡',22,'大四 物联网4班'),('20173324','徐爱霞',20,'大三 软工5班'),('20187794','华晓慧',19,'大二 动画3班'),('20194413','徐小小',19,'大一 英语4班');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` tinyint(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`) values (1,'aaa','bbb');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
