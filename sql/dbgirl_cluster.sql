/*
 Navicat Premium Data Transfer

 Source Server         : 科海健康
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : rm-bp1e5wj1225x3b702o.mysql.rds.aliyuncs.com
 Source Database       : dbgirl_cluster

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 11/20/2017 15:06:20 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `city`
-- ----------------------------
BEGIN;
INSERT INTO `city` VALUES ('1', '1', '温岭市', 'BYSocket 的家在温岭。');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
