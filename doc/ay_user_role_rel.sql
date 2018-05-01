/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : springmvc-mybatis-book

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-01 18:11:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ay_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `ay_user_role_rel`;
CREATE TABLE `ay_user_role_rel` (
  `id` bigint(32) NOT NULL,
  `user_id` bigint(32) DEFAULT NULL,
  `role_id` bigint(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
