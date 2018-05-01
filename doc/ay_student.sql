/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springmvc-mybatis-book

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-01 15:16:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ay_student
-- ----------------------------
DROP TABLE IF EXISTS `ay_student`;
CREATE TABLE `ay_student` (
  `id` bigint(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `school_id` bigint(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
