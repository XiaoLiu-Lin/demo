/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test_database

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-06-14 19:42:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `test_login`
-- ----------------------------
DROP TABLE IF EXISTS `test_login`;
CREATE TABLE `test_login` (
  `id` int(15) NOT NULL AUTO_INCREMENT COMMENT 'User id',
  `name` varchar(20) NOT NULL COMMENT '用户昵称',
  `userName` varchar(20) NOT NULL COMMENT '用户账号昵称',
  `Password` varchar(20) NOT NULL COMMENT 'User‘s Password',
  `phone` varchar(20) DEFAULT NULL COMMENT 'User''s Phone Number ',
  `email` varchar(30) DEFAULT NULL,
  `gender` int(5) NOT NULL COMMENT '1for man 2 for woman 0 neutrol',
  `age` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_login
-- ----------------------------
INSERT INTO `test_login` VALUES ('1', '管理员', 'admin', '123456', '18211904978', 'xiaolin@163.com', '0', '25');
INSERT INTO `test_login` VALUES ('2', '超级管理员', 'root', 'root', '15136300082', 'linxiao@163.com', '0', '36');

-- ----------------------------
-- Table structure for `test_user_table`
-- ----------------------------
DROP TABLE IF EXISTS `test_user_table`;
CREATE TABLE `test_user_table` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'Test user id data ',
  `name` varchar(20) NOT NULL COMMENT 'Test user name data',
  `age` int(20) NOT NULL COMMENT 'Test user age data',
  `gender` int(10) NOT NULL COMMENT 'Test user age data 1 for men , 2 for Women',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of test_user_table
-- ----------------------------
INSERT INTO `test_user_table` VALUES ('1', '迪丽热巴2', '21', '2');
INSERT INTO `test_user_table` VALUES ('2', '小芳', '20', '2');
INSERT INTO `test_user_table` VALUES ('3', '大黑', '45', '1');
INSERT INTO `test_user_table` VALUES ('4', '迪丽热巴3', '21', '2');
INSERT INTO `test_user_table` VALUES ('5', '迪丽热巴3', '21', '2');
INSERT INTO `test_user_table` VALUES ('6', '大壮', '21', '2');
INSERT INTO `test_user_table` VALUES ('7', '迪丽热巴', '21', '1');
