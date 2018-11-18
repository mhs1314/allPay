CREATE DATABASE id_key DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
Use id_key;
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : id_key

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-11-18 22:41:00
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
  `CREATED` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'created time',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='DB WorkerID Assigner for UID Generator';

-- ----------------------------
-- Records of worker_node
-- ----------------------------
INSERT INTO `worker_node` VALUES ('42', '172.17.133.209', '1542550269180-59343', '2', '2018-11-18', '2018-11-18 22:11:09', '2018-11-18 22:11:09');
