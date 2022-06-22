/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : ly-db-glxy

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 22/06/2022 15:26:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_user
-- ----------------------------
DROP TABLE IF EXISTS `edu_user`;
CREATE TABLE `edu_user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_user
-- ----------------------------
INSERT INTO `edu_user` VALUES (-2105475070, '张三', '2022-06-22 06:19:04', '2022-06-22 06:19:04', 0);
INSERT INTO `edu_user` VALUES (-1623179263, '张三', '2022-06-22 06:17:03', '2022-06-22 06:17:03', 0);
INSERT INTO `edu_user` VALUES (2, '张三', '2022-06-22 06:15:19', '2022-06-22 06:15:19', 1);
INSERT INTO `edu_user` VALUES (1539495317387411457, '张三', '2022-06-22 06:27:41', '2022-06-22 06:27:41', 0);

SET FOREIGN_KEY_CHECKS = 1;
