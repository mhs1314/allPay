/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : id_key

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-18 22:55:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `id_segment`
-- ----------------------------
DROP TABLE IF EXISTS `id_segment`;
CREATE TABLE `id_segment` (
  `biz_tag` varchar(50) DEFAULT NULL COMMENT '业务标识',
  `max_id` bigint(20) DEFAULT NULL COMMENT '分配的id号段的最大值',
  `p_step` bigint(20) DEFAULT NULL COMMENT '步长',
  `last_update_time` datetime DEFAULT NULL,
  `current_update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='号段存储表';

-- ----------------------------
-- Records of id_segment
-- ----------------------------
INSERT INTO `id_segment` VALUES ('order', '440', '20', '2018-11-18 21:45:44', '2018-11-18 22:11:09');

-- ----------------------------
-- Table structure for `worker_node`
-- ----------------------------
DROP TABLE IF EXISTS `worker_node`;
CREATE TABLE `worker_node` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
  `HOST_NAME` varchar(64) NOT NULL COMMENT 'host name',
  `PORT` varchar(64) NOT NULL COMMENT 'port',
  `TYPE` int(11) NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
  `LAUNCH_DATE` date NOT NULL COMMENT 'launch date',
  `MODIFIED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'modified time',
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'created time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='DB WorkerID Assigner for UID Generator';

-- ----------------------------
-- Records of worker_node
-- ----------------------------
INSERT INTO `worker_node` VALUES ('1', '172.17.133.209', '1542539218577-5644', '2', '2018-11-18', '2018-11-18 19:06:58', '2018-11-18 19:06:58');
INSERT INTO `worker_node` VALUES ('2', '172.17.133.209', '1542539218664-53930', '2', '2018-11-18', '2018-11-18 19:06:58', '2018-11-18 19:06:58');
INSERT INTO `worker_node` VALUES ('3', '172.17.133.209', '1542539300360-78139', '2', '2018-11-18', '2018-11-18 19:08:20', '2018-11-18 19:08:20');
INSERT INTO `worker_node` VALUES ('4', '172.17.133.209', '1542539300425-57816', '2', '2018-11-18', '2018-11-18 19:08:20', '2018-11-18 19:08:20');
INSERT INTO `worker_node` VALUES ('5', '172.17.133.209', '1542540795844-9439', '2', '2018-11-18', '2018-11-18 19:33:15', '2018-11-18 19:33:15');
INSERT INTO `worker_node` VALUES ('6', '172.17.133.209', '1542540795910-39569', '2', '2018-11-18', '2018-11-18 19:33:15', '2018-11-18 19:33:15');
INSERT INTO `worker_node` VALUES ('7', '172.17.133.209', '1542540917164-83891', '2', '2018-11-18', '2018-11-18 19:35:17', '2018-11-18 19:35:17');
INSERT INTO `worker_node` VALUES ('8', '172.17.133.209', '1542540917243-43853', '2', '2018-11-18', '2018-11-18 19:35:17', '2018-11-18 19:35:17');
INSERT INTO `worker_node` VALUES ('9', '172.17.133.209', '1542540943062-29046', '2', '2018-11-18', '2018-11-18 19:35:43', '2018-11-18 19:35:43');
INSERT INTO `worker_node` VALUES ('10', '172.17.133.209', '1542540943136-10821', '2', '2018-11-18', '2018-11-18 19:35:43', '2018-11-18 19:35:43');
INSERT INTO `worker_node` VALUES ('11', '172.17.133.209', '1542540954634-52065', '2', '2018-11-18', '2018-11-18 19:35:54', '2018-11-18 19:35:54');
INSERT INTO `worker_node` VALUES ('12', '172.17.133.209', '1542540954710-8819', '2', '2018-11-18', '2018-11-18 19:35:54', '2018-11-18 19:35:54');
INSERT INTO `worker_node` VALUES ('13', '172.17.133.209', '1542540964221-47328', '2', '2018-11-18', '2018-11-18 19:36:04', '2018-11-18 19:36:04');
INSERT INTO `worker_node` VALUES ('14', '172.17.133.209', '1542540964302-85389', '2', '2018-11-18', '2018-11-18 19:36:04', '2018-11-18 19:36:04');
INSERT INTO `worker_node` VALUES ('15', '172.17.133.209', '1542541020008-1185', '2', '2018-11-18', '2018-11-18 19:37:00', '2018-11-18 19:37:00');
INSERT INTO `worker_node` VALUES ('16', '172.17.133.209', '1542541020070-15721', '2', '2018-11-18', '2018-11-18 19:37:00', '2018-11-18 19:37:00');
INSERT INTO `worker_node` VALUES ('17', '172.17.133.209', '1542541272714-38197', '2', '2018-11-18', '2018-11-18 19:41:12', '2018-11-18 19:41:12');
INSERT INTO `worker_node` VALUES ('18', '172.17.133.209', '1542541272787-47038', '2', '2018-11-18', '2018-11-18 19:41:12', '2018-11-18 19:41:12');
INSERT INTO `worker_node` VALUES ('19', '172.17.133.209', '1542541444634-843', '2', '2018-11-18', '2018-11-18 19:44:04', '2018-11-18 19:44:04');
INSERT INTO `worker_node` VALUES ('20', '172.17.133.209', '1542541444713-66186', '2', '2018-11-18', '2018-11-18 19:44:04', '2018-11-18 19:44:04');
INSERT INTO `worker_node` VALUES ('21', '172.17.133.209', '1542541582452-36884', '2', '2018-11-18', '2018-11-18 19:46:22', '2018-11-18 19:46:22');
INSERT INTO `worker_node` VALUES ('22', '172.17.133.209', '1542541582537-91356', '2', '2018-11-18', '2018-11-18 19:46:22', '2018-11-18 19:46:22');
INSERT INTO `worker_node` VALUES ('23', '172.17.133.209', '1542541590265-29805', '2', '2018-11-18', '2018-11-18 19:46:30', '2018-11-18 19:46:30');
INSERT INTO `worker_node` VALUES ('24', '172.17.133.209', '1542541590338-3229', '2', '2018-11-18', '2018-11-18 19:46:30', '2018-11-18 19:46:30');
INSERT INTO `worker_node` VALUES ('25', '172.17.133.209', '1542541802933-67878', '2', '2018-11-18', '2018-11-18 19:50:02', '2018-11-18 19:50:02');
INSERT INTO `worker_node` VALUES ('26', '172.17.133.209', '1542541803007-27465', '2', '2018-11-18', '2018-11-18 19:50:03', '2018-11-18 19:50:03');
INSERT INTO `worker_node` VALUES ('27', '172.17.133.209', '1542541853945-64708', '2', '2018-11-18', '2018-11-18 19:50:53', '2018-11-18 19:50:53');
INSERT INTO `worker_node` VALUES ('28', '172.17.133.209', '1542541854008-33780', '2', '2018-11-18', '2018-11-18 19:50:54', '2018-11-18 19:50:54');
INSERT INTO `worker_node` VALUES ('29', '172.17.133.209', '1542541962865-38712', '2', '2018-11-18', '2018-11-18 19:52:42', '2018-11-18 19:52:42');
INSERT INTO `worker_node` VALUES ('30', '172.17.133.209', '1542541962944-38536', '2', '2018-11-18', '2018-11-18 19:52:42', '2018-11-18 19:52:42');
INSERT INTO `worker_node` VALUES ('31', '172.17.133.209', '1542541993567-67807', '2', '2018-11-18', '2018-11-18 19:53:13', '2018-11-18 19:53:13');
INSERT INTO `worker_node` VALUES ('32', '172.17.133.209', '1542541993627-91470', '2', '2018-11-18', '2018-11-18 19:53:13', '2018-11-18 19:53:13');
INSERT INTO `worker_node` VALUES ('33', '172.17.133.209', '1542542416229-28497', '2', '2018-11-18', '2018-11-18 20:00:16', '2018-11-18 20:00:16');
INSERT INTO `worker_node` VALUES ('34', '172.17.133.209', '1542542416285-52117', '2', '2018-11-18', '2018-11-18 20:00:16', '2018-11-18 20:00:16');
INSERT INTO `worker_node` VALUES ('35', '172.17.133.209', '1542542633096-65909', '2', '2018-11-18', '2018-11-18 20:03:53', '2018-11-18 20:03:53');
INSERT INTO `worker_node` VALUES ('36', '172.17.133.209', '1542542633152-17554', '2', '2018-11-18', '2018-11-18 20:03:53', '2018-11-18 20:03:53');
INSERT INTO `worker_node` VALUES ('37', '172.17.133.209', '1542548720671-65773', '2', '2018-11-18', '2018-11-18 21:45:20', '2018-11-18 21:45:20');
INSERT INTO `worker_node` VALUES ('38', '172.17.133.209', '1542548720720-98913', '2', '2018-11-18', '2018-11-18 21:45:20', '2018-11-18 21:45:20');
INSERT INTO `worker_node` VALUES ('39', '172.17.133.209', '1542548743968-52884', '2', '2018-11-18', '2018-11-18 21:45:43', '2018-11-18 21:45:43');
INSERT INTO `worker_node` VALUES ('40', '172.17.133.209', '1542548744029-92636', '2', '2018-11-18', '2018-11-18 21:45:44', '2018-11-18 21:45:44');
INSERT INTO `worker_node` VALUES ('41', '172.17.133.209', '1542550269122-67941', '2', '2018-11-18', '2018-11-18 22:11:09', '2018-11-18 22:11:09');
INSERT INTO `worker_node` VALUES ('42', '172.17.133.209', '1542550269180-59343', '2', '2018-11-18', '2018-11-18 22:11:09', '2018-11-18 22:11:09');
