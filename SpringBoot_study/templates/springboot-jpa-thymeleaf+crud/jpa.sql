/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 8.0.17 : Database - jpa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jpa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `jpa`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`author`,`book_name`,`price`) values (1,'鲁迅','呐喊',99),(2,'(意) 翁贝托·埃科 (Umberto Eco) ','布拉格公墓',88.5),(3,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','游戏的终结',45),(4,'啊啊啊','Java 权威指南',85),(5,'Gorit','Python 案例驱动学习',88),(6,'罗贯中','三国演义',35),(7,'曹雪芹','红楼梦',30),(8,'吴承恩','西游记',29),(9,'施耐庵','水浒传',29),(10,'钱忠书','宋诗选注',18),(11,'鲁迅','故事新编',22),(13,'rush13213','海底两万里',98),(14,'鲁迅','匆匆',88.5),(16,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','汇率',45),(18,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','汇率',45),(19,'阿达瓦大','汇率',45),(20,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','汇率呀',100),(21,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','汇率1',45),(22,'(意) 翁贝托·埃科 (Umberto Eco) 根廷] 胡里奥·科塔萨尔 ','汇率111',100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
