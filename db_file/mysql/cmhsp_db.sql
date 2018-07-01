/*
 Navicat Premium Data Transfer

 Source Server         : bobness
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : cmhsp_db

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 07/01/2018 10:58:40 AM
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
INSERT INTO `comb_usersysnews` VALUES ('1', '0', '1', '1'), ('2', '0', '1', '2'), ('3', '0', '1', '3'), ('4', '1', '1', '4'), ('5', '0', '2', '1'), ('6', '0', '2', '2'), ('7', '0', '2', '3'), ('8', '1', '2', '4'), ('9', '0', '3', '1'), ('10', '0', '3', '2'), ('11', '0', '3', '3'), ('12', '1', '3', '4'), ('13', '0', '4', '1'), ('14', '0', '4', '2'), ('15', '0', '4', '3'), ('16', '1', '4', '4'), ('17', '0', '5', '1'), ('18', '0', '5', '2'), ('19', '0', '5', '3'), ('20', '1', '5', '4');
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
INSERT INTO `systemnews` VALUES ('1', 'app版本更新', '2018-07-01 09:00'), ('2', '您的测试分析出炉', '2018-07-01 09:00'), ('3', '增加抑郁症测试题', '2018-07-01 09:00'), ('4', '亲，每天要早睡早起哦', '2018-06-11 09:00'), ('5', '社区评论功能开放', '2018-06-01 09:00');
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
  `test_time` varchar(255) COLLATE utf8_bin NOT NULL,
  `test_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `testresult`
-- ----------------------------
BEGIN;
INSERT INTO `testresult` VALUES ('1', '3', '1', '80', null, '2018-06-01 19:29', '1', '3'), ('2', '3', '2', '50', null, '2018-06-02 19:29', '2', '3'), ('3', '3', '3', '70', null, '2018-06-03 19:29', '2', '3'), ('4', '3', '3', '75', null, '2018-06-04 19:29', '2', '3'), ('5', '3', '1', '85', null, '2018-06-05 19:29', '1', '3'), ('6', '3', '1', '85', null, '2018-06-06 19:29', '1', '4'), ('7', '3', '3', '75', null, '2018-06-07 19:29', '2', '4'), ('8', '3', '3', '75', null, '2018-06-08 19:29', '2', '1'), ('9', '3', '1', '75', null, '2018-06-11 19:29', '1', '1'), ('10', '5', '1', '46', '有较严重抑郁', '2018-06-12 19:29', null, '4'), ('11', '3', '3', '63', '你的焦虑有点发烧。', '2018-06-15 19:29', null, '4'), ('12', '1', '1', '5', '没有抑郁症', '2018-06-16 19:29', null, '4'), ('13', '6', '1', '57', '有严重抑郁', '2018-06-21 19:29', null, '4'), ('14', '1', '1', '0', '没有抑郁症', '2018-06-22 19:29', null, '3'), ('15', '2', '2', '47', '轻微焦虑', '2018-06-26 12:29', null, '2'), ('16', '6', '1', '63', '有严重抑郁', '2018-06-29 19:26', null, '4'), ('17', '1', '1', '2', '没有抑郁症', '2018-06-30 19:29', null, '4');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'imgs/touxiangman.png', '', '', '', '', 'liuchangwei', '', '123'), ('2', 'imgs/touxiangman.png', 'sssqsss', '男', 'sas', '', 'haomiao', '大梦迷离藏小剑', '1234'), ('3', 'imgs/touxiangman.png', '', '', '', '', 'xuyechen', '', '123'), ('4', 'imgs/touxiangman.png', '山西运城市', '男', '从心开始', '', 'xueyangbo', '', '123'), ('5', 'imgs/default_userImage.png', '', '', '', '', 'ceshi1', '', '123'), ('6', 'imgs/default_userImage.png', '', '', '', '', 'ceshi2', '', '123'), ('7', 'imgs/default_userImage.png', '', '', '从心开始', '', 'hehe', 'hehe', '123'), ('8', 'imgs/default_userImage.png', '', '', '从心开始', '', 'hehehehe', 'hehehehe', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
