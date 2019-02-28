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

 Date: 28/02/2019 13:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for huangyiling_wacai
-- ----------------------------
DROP TABLE IF EXISTS `huangyiling_wacai`;
CREATE TABLE `huangyiling_wacai`  (
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '记账类别(收入/支出)',
  `category` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '记账科目',
  `amount` double(10, 2) DEFAULT NULL COMMENT '金额',
  `create_time` datetime(0) DEFAULT NULL COMMENT '发生时间',
  `account_balance` double(10, 2) DEFAULT NULL COMMENT '本月余额',
  `remarks` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
