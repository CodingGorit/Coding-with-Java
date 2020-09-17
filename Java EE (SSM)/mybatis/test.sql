/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2020-09-17 11:50:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('1', '班级1');
INSERT INTO `clazz` VALUES ('2', '班级2');
INSERT INTO `clazz` VALUES ('3', '班级3');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` tinyint(5) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `age` tinyint(3) NOT NULL,
  `cno` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_ibfk_1` (`cno`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`cno`) REFERENCES `clazz` (`cno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张', '女', '10', '1');
INSERT INTO `student` VALUES ('2', 'coco', '女', '10', '2');
INSERT INTO `student` VALUES ('6', '小张同学', '女', '18', '3');
INSERT INTO `student` VALUES ('7', '小李', '女', '23', '1');
INSERT INTO `student` VALUES ('8', '小T', '男', '19', '2');
