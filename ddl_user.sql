/*
 Navicat Premium Data Transfer

 Source Server         : bmatch
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : rm-bp1s8wez9j4hw42oemo.mysql.rds.aliyuncs.com:3306
 Source Schema         : dizi-03

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 28/02/2019 13:11:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for haungyiling_user
-- ----------------------------
DROP TABLE IF EXISTS `haungyiling_user`;
CREATE TABLE `haungyiling_user`  (
  `user_tel` int(11) DEFAULT NULL COMMENT '用户注册手机号码',
  `user_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户注册邮箱',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
  `user_sex` int(11) DEFAULT NULL COMMENT '用户性别，0为女，1为男'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
