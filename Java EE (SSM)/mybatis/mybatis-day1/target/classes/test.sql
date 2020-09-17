/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2020-09-15 11:59:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` tinyint(5) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `age` tinyint(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张', '女', '10');
INSERT INTO `student` VALUES ('2', 'coco', '女', '10');
INSERT INTO `student` VALUES ('6', '小张同学', '女', '18');
