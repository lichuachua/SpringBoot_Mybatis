/*
Navicat MySQL Data Transfer

Source Server         : liyuhao
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : my_springboot_blog

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2020-01-08 11:06:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bg_article
-- ----------------------------
DROP TABLE IF EXISTS `bg_article`;
CREATE TABLE `bg_article` (
  `article_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photos` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bg_article
-- ----------------------------
INSERT INTO `bg_article` VALUES ('4028b8816891f726016891f90b850000', '4028b881688f9fe101688fa0556f0000', '我他妈的', '我李歘歘不相信爱情', '1', '2019-01-28 09:00:44', '2019-01-28 09:01:04', null);
INSERT INTO `bg_article` VALUES ('4028b8816891f726016891fadf1d0001', '4028b881688f9fe101688fa0556f0000', '我他妈的', '我李歘歘不相信爱情', '0', '2019-01-28 09:02:43', '2019-01-28 09:02:54', null);
INSERT INTO `bg_article` VALUES ('4028b8816896f7d6016896f94c400000', '4028b881688f9fe101688fa0556f0000', '查询', '李歘歘', '0', '2019-01-29 08:19:06', '2019-01-29 08:19:06', '下水线');
INSERT INTO `bg_article` VALUES ('4028b881689877e801689879595a0001', '4028b881689877e80168987868140000', 'DA', 'DAQSW', '1', '2019-01-29 15:18:36', '2019-01-29 15:18:55', 'DA');
INSERT INTO `bg_article` VALUES ('4028b88168e4b6c70168e4b84ea60000', '4028b88168e0be700168e0bfe1ad0000', 's', 'cs', '0', '2019-02-13 10:38:30', '2019-02-13 10:38:30', 'csc');
INSERT INTO `bg_article` VALUES ('4028b88168ebf3850168ebf4a6500000', '4028b88168e0be700168e0bfe1ad0000', '董小姐和莉莉安', '李宇豪', '0', '2019-02-14 20:21:45', '2019-02-14 20:21:45', null);
INSERT INTO `bg_article` VALUES ('4028b88168ebf3850168ebf4b1a40001', '4028b88168e0be700168e0bfe1ad0000', '董小姐和莉莉安', '李宇豪', '0', '2019-02-14 20:21:48', '2019-02-14 20:21:48', null);
INSERT INTO `bg_article` VALUES ('4028b8816ae4f7ba016ae4f827640000', '4028b881689877e80168987868140000', '1', '1', '0', '2019-05-23 21:53:49', '2019-05-23 21:53:49', '1');

-- ----------------------------
-- Table structure for bg_user
-- ----------------------------
DROP TABLE IF EXISTS `bg_user`;
CREATE TABLE `bg_user` (
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `mobile` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(50) COLLATE utf8_bin NOT NULL,
  `nick_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_avatar` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `status` int(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bg_user
-- ----------------------------
INSERT INTO `bg_user` VALUES ('4028b881688f9fe101688fa0556f0000', '15534446431', '1', 'LCC-BLOG-7u9m0X', null, '0', '2019-01-27 22:04:36', '2019-01-27 22:04:36');
INSERT INTO `bg_user` VALUES ('4028b881689877e80168987868140000', '1', '1', 'LCC-BLOG-Y6uTaN', null, '1', '2019-01-29 15:17:34', '2019-01-29 15:26:08');
INSERT INTO `bg_user` VALUES ('4028b881689883e901689885ccf20000', '2', '2', 'LCC-BLOG-RD3kMZ', null, '1', '2019-01-29 15:32:12', '2019-01-29 15:33:05');
INSERT INTO `bg_user` VALUES ('4028b88168988a580168988b08d70000', '3', '3', 'LCC-BLOG-MnO3Bc', null, '0', '2019-01-29 15:37:55', '2019-01-29 15:37:55');
INSERT INTO `bg_user` VALUES ('4028b88168e0b9510168e0bcf25e0000', '4', '4', 'LCC-BLOG-fPLXlu', null, '1', '2019-02-12 16:05:05', '2019-02-12 16:05:43');
INSERT INTO `bg_user` VALUES ('4028b88168e0be700168e0bfe1ad0000', '5', '5', 'LCC-BLOG-s695cf', null, '0', '2019-02-12 16:08:18', '2019-02-12 16:08:18');
INSERT INTO `bg_user` VALUES ('4028b88169b4fc300169b4fcb2840000', '8', '8', 'LCC-BLOG-ipQLmh', null, '0', '2019-03-25 21:14:13', '2019-03-25 21:14:13');
INSERT INTO `bg_user` VALUES ('4028b88169b519b00169b51a82870000', 'C', 'C', 'MP-qWUOTQ', null, '0', '2019-03-25 21:46:47', '2019-03-25 21:46:47');
