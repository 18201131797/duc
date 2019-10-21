/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50506
 Source Host           : localhost:3306
 Source Schema         : duc

 Target Server Type    : MySQL
 Target Server Version : 50506
 File Encoding         : 65001

 Date: 21/10/2019 14:14:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_menu`;
CREATE TABLE `ms_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '目录表id',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '目录名称',
  `menu_sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父id',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `create_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) NULL DEFAULT 0 COMMENT '更新人id',
  `update_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者姓名',
  `delete_flag` int(2) NULL DEFAULT 1 COMMENT '删除标记: 0删除|1未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '目录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ms_menu
-- ----------------------------
INSERT INTO `ms_menu` VALUES (1, 'test', NULL, NULL, NULL, NULL, NULL, NULL, 0, '', NULL, 0, '', 1);

-- ----------------------------
-- Table structure for ms_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_role`;
CREATE TABLE `ms_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表id',
  `platform` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'P01' COMMENT '平台标识码',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '角色描述',
  `role_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色代码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `create_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) NULL DEFAULT 0 COMMENT '更新人id',
  `update_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者姓名',
  `delete_flag` int(2) NULL DEFAULT 1 COMMENT '删除标记: 0删除|1未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ms_role
-- ----------------------------
INSERT INTO `ms_role` VALUES (1, 'P01', 'admin', '', 'ROLE_ADMIN', NULL, NULL, NULL, 0, '', NULL, 0, '', 1);

-- ----------------------------
-- Table structure for ms_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_role_menu`;
CREATE TABLE `ms_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单权限表id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '权限id',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `create_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) NULL DEFAULT 0 COMMENT '更新人id',
  `update_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者姓名',
  `delete_flag` int(2) NULL DEFAULT 1 COMMENT '删除标记: 0删除|1未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ms_role_menu
-- ----------------------------
INSERT INTO `ms_role_menu` VALUES (1, 1, 1, NULL, NULL, NULL, 0, '', NULL, 0, '', 1);

-- ----------------------------
-- Table structure for ms_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ms_user_info`;
CREATE TABLE `ms_user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理系统用户信息表id',
  `user_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户姓名',
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '员工编号',
  `platform` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'P01' COMMENT '平台标识码',
  `flag` int(2) NULL DEFAULT 1 COMMENT '启用状态；1启用 2停用',
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '身份证号',
  `sex` int(6) NULL DEFAULT 2 COMMENT '性别 1：男 2：女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号码',
  `pic_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户头像',
  `page_css` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'default' COMMENT '后台页面css样式',
  `remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `create_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) NULL DEFAULT 0 COMMENT '更新人id',
  `update_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者姓名',
  `delete_flag` int(2) NULL DEFAULT 1 COMMENT '删除标记: 0删除|1未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理系统用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ms_user_info
-- ----------------------------
INSERT INTO `ms_user_info` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '', 'P01', 1, '', 2, NULL, NULL, NULL, NULL, '', 'default', NULL, NULL, NULL, 0, '', NULL, 0, '', 1);

-- ----------------------------
-- Table structure for ms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_user_role`;
CREATE TABLE `ms_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色表id',
  `ms_user_id` int(11) NULL DEFAULT NULL COMMENT 'ms_user_info 表 主键',
  `ms_role_id` int(11) NULL DEFAULT NULL COMMENT 'ms_role表主键',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `company_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user_id` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `create_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_user_id` int(11) NULL DEFAULT 0 COMMENT '更新人id',
  `update_user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者姓名',
  `delete_flag` int(2) NULL DEFAULT 1 COMMENT '删除标记: 0删除|1未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ms_user_role
-- ----------------------------
INSERT INTO `ms_user_role` VALUES (1, 1, 1, NULL, NULL, NULL, 0, '', NULL, 0, '', 1);

SET FOREIGN_KEY_CHECKS = 1;
