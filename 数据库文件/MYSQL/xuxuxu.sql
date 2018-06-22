/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : xuxuxu

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 06/22/2018 13:01:56 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `comb_usersysnews`
-- ----------------------------
DROP TABLE IF EXISTS `comb_usersysnews`;
CREATE TABLE `comb_usersysnews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL,
  `sys_id` bigint(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `comb_usersysnews`
-- ----------------------------
BEGIN;
INSERT INTO `comb_usersysnews` VALUES ('1', '0', '1', '1'), ('2', '0', '1', '2'), ('3', '0', '1', '3'), ('4', '0', '1', '4'), ('5', '0', '2', '1'), ('6', '0', '2', '2'), ('7', '0', '2', '3'), ('8', '0', '2', '4'), ('9', '0', '3', '1'), ('10', '0', '3', '2'), ('11', '0', '3', '3'), ('12', '0', '3', '4'), ('13', '0', '4', '1'), ('14', '0', '4', '2'), ('15', '0', '4', '3'), ('16', '0', '4', '4'), ('17', '0', '5', '1'), ('18', '0', '5', '2'), ('19', '0', '5', '3'), ('20', '0', '5', '4');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `sys_user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `roles_id` varchar(255) COLLATE utf8_bin NOT NULL,
  KEY `FKd0ut7sloes191bygyf7a3pk52` (`sys_user_id`),
  KEY `FKdpvc6d7xqpqr43dfuk1s27cqh` (`roles_id`),
  CONSTRAINT `FKd0ut7sloes191bygyf7a3pk52` FOREIGN KEY (`sys_user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKdpvc6d7xqpqr43dfuk1s27cqh` FOREIGN KEY (`roles_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `systemnews`
-- ----------------------------
DROP TABLE IF EXISTS `systemnews`;
CREATE TABLE `systemnews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `systemnews`
-- ----------------------------
BEGIN;
INSERT INTO `systemnews` VALUES ('1', '这是第一条系统消息。', 'Thu Jun 21 20:25:28 CST 2018'), ('2', '这是第二条系统消息。', 'Thu Jun 21 20:25:34 CST 2018'), ('3', '这是第三条系统消息。', 'Thu Jun 21 20:25:38 CST 2018'), ('4', '这是第四条系统消息。', 'Thu Jun 21 20:25:42 CST 2018'), ('5', '这是第五条系统消息。', 'Thu Jun 21 20:25:49 CST 2018');
COMMIT;

-- ----------------------------
--  Table structure for `testresult`
-- ----------------------------
DROP TABLE IF EXISTS `testresult`;
CREATE TABLE `testresult` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `examination_conclusion_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `examination_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `examination_score` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `summary` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `test_time` bigint(20) NOT NULL,
  `test_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `testresult`
-- ----------------------------
BEGIN;
INSERT INTO `testresult` VALUES ('1', '3', '1', '80', null, '12222222', '1', '3'), ('2', '3', '2', '50', null, '12222222', '2', '3'), ('3', '3', '3', '70', null, '12222222', '2', '3'), ('4', '3', '3', '75', null, '12222222', '2', '3'), ('5', '3', '1', '85', null, '12222222', '1', '3'), ('6', '3', '1', '85', null, '12222222', '1', '4'), ('7', '3', '3', '75', null, '12222222', '2', '4'), ('8', '3', '3', '75', null, '12222222', '2', '1'), ('9', '3', '1', '75', null, '12222222', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_addre` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `region` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signature` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_reg_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `usernickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userpwd` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '', '', '', '', '', 'liuchangwei', '', '123'), ('2', 'dd', 'sssqsss', '男', 'sas', '', 'haomiao', '大梦迷离藏小剑', '1234'), ('3', '', '', '', '', '', 'xuyechen', '', '123'), ('4', '', '', '', '', '', 'xueyangbo', '', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
