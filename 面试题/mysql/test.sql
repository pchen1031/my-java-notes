/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 06/04/2025 14:22:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods_innodb
-- ----------------------------
DROP TABLE IF EXISTS `goods_innodb`;
CREATE TABLE `goods_innodb`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `version` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods_innodb
-- ----------------------------
INSERT INTO `goods_innodb` VALUES (1, '小米', NULL);
INSERT INTO `goods_innodb` VALUES (2, '荣耀', NULL);
INSERT INTO `goods_innodb` VALUES (7, 'opp', NULL);
INSERT INTO `goods_innodb` VALUES (8, 'vivo', 1);

-- ----------------------------
-- Table structure for tb_seller
-- ----------------------------
DROP TABLE IF EXISTS `tb_seller`;
CREATE TABLE `tb_seller`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sellerid` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
  `status` char(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '状态',
  `address` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '地址',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name_st_address`(`name` ASC, `status` ASC, `address` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_seller
-- ----------------------------
INSERT INTO `tb_seller` VALUES (1, 'oppo', '张三', '1', '成都市金牛区', '2023-10-17 11:11:12', 2);
INSERT INTO `tb_seller` VALUES (2, 'vivo', '李四', '0', '北京昌平区', '2023-10-11 11:11:12', 1);
INSERT INTO `tb_seller` VALUES (3, '华为', '李四', '1', '成都郫都区', '2023-10-11 11:11:12', 6);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
  `age` int NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '张三', 22);
INSERT INTO `tb_user` VALUES (2, '李四', 33);

SET FOREIGN_KEY_CHECKS = 1;
