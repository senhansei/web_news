/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : zykkk

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/12/2022 18:42:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item_user
-- ----------------------------
DROP TABLE IF EXISTS `item_user`;
CREATE TABLE `item_user`  (
  `item_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `item_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(11) NULL DEFAULT 1 COMMENT '1：启用 0：禁用',
  PRIMARY KEY (`item_user_id`) USING BTREE,
  INDEX `FK_Reference_2`(`user_id`) USING BTREE,
  INDEX `FK_Reference_3`(`item_id`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`item_id`) REFERENCES `new_item` (`item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item_user
-- ----------------------------
INSERT INTO `item_user` VALUES (1, 1, 2, '2020-11-23 11:24:16', '2020-11-25 10:27:54', 1);
INSERT INTO `item_user` VALUES (2, 2, 4, NULL, '2020-11-25 09:38:17', 1);
INSERT INTO `item_user` VALUES (3, 1, 1, '2020-11-24 09:19:58', '2020-11-25 09:38:21', 1);
INSERT INTO `item_user` VALUES (5, 1, 18, NULL, '2020-11-25 09:44:16', 1);
INSERT INTO `item_user` VALUES (6, 1, 27, '2020-11-25 11:11:35', '2020-11-25 11:11:35', 1);
INSERT INTO `item_user` VALUES (7, 1, 28, '2020-11-25 11:17:59', '2020-11-25 11:17:59', 1);
INSERT INTO `item_user` VALUES (8, 1, 29, '2020-11-25 11:29:14', '2020-11-25 11:29:14', 1);
INSERT INTO `item_user` VALUES (9, 1, 30, '2020-11-25 11:30:54', '2020-11-25 11:30:54', 1);
INSERT INTO `item_user` VALUES (10, 1, 31, '2020-11-25 11:36:51', '2020-11-25 11:36:51', 1);
INSERT INTO `item_user` VALUES (11, 1, 32, '2020-11-25 16:26:23', '2020-11-25 16:26:23', 1);
INSERT INTO `item_user` VALUES (12, 1, 33, '2020-11-25 16:26:37', '2020-11-25 16:26:37', 1);
INSERT INTO `item_user` VALUES (13, 1, 34, '2020-11-26 10:01:29', '2020-11-26 10:01:29', 1);
INSERT INTO `item_user` VALUES (14, 1, 35, '2020-11-26 10:28:53', '2020-11-26 10:28:53', 1);
INSERT INTO `item_user` VALUES (15, 103, 36, '2022-12-27 16:27:20', '2022-12-27 16:27:20', 1);
INSERT INTO `item_user` VALUES (16, 103, 37, '2022-12-27 16:27:31', '2022-12-27 16:27:31', 1);

-- ----------------------------
-- Table structure for logs_info
-- ----------------------------
DROP TABLE IF EXISTS `logs_info`;
CREATE TABLE `logs_info`  (
  `logs_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `logs_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`logs_id`) USING BTREE,
  INDEX `FK_Reference_1`(`user_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of logs_info
-- ----------------------------
INSERT INTO `logs_info` VALUES (1, 1, NULL, NULL, '2020-11-24 09:27:05');
INSERT INTO `logs_info` VALUES (2, 2, NULL, NULL, '2020-11-24 09:27:12');
INSERT INTO `logs_info` VALUES (3, 4, NULL, NULL, '2020-11-23 11:29:06');
INSERT INTO `logs_info` VALUES (14, 1, 'woshishenren', '2020-11-24 09:24:52', '2020-11-24 09:24:52');
INSERT INTO `logs_info` VALUES (15, 1, 'woshishenren', '2020-11-24 09:25:58', '2020-11-24 09:25:58');

-- ----------------------------
-- Table structure for new_item
-- ----------------------------
DROP TABLE IF EXISTS `new_item`;
CREATE TABLE `new_item`  (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(11) NULL DEFAULT 1 COMMENT '1：启用 0：禁用',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of new_item
-- ----------------------------
INSERT INTO `new_item` VALUES (1, '呵呵哒', '2020-11-24 15:47:00', '2020-11-26 10:28:39', 1);
INSERT INTO `new_item` VALUES (2, '党支部', '2020-11-24 15:47:03', '2020-11-25 14:44:31', 0);
INSERT INTO `new_item` VALUES (3, '分团委', '2020-11-24 15:47:05', '2020-11-25 14:43:54', 1);
INSERT INTO `new_item` VALUES (4, '院团委', '2020-11-24 15:47:08', '2020-11-25 14:44:38', 1);
INSERT INTO `new_item` VALUES (5, '111', '2020-11-23 15:22:54', '2020-11-25 14:45:55', 1);
INSERT INTO `new_item` VALUES (6, '学生会', '2020-11-24 09:27:36', '2020-11-25 14:46:01', 1);
INSERT INTO `new_item` VALUES (8, '党支部', '2020-11-24 13:51:13', '2020-11-25 14:46:07', 1);
INSERT INTO `new_item` VALUES (18, '党支部', '2020-11-25 09:11:51', '2020-11-25 15:49:06', 1);
INSERT INTO `new_item` VALUES (19, '院团委', '2020-11-25 10:42:54', '2020-11-25 14:46:16', 1);
INSERT INTO `new_item` VALUES (20, '111', '2020-11-25 10:54:12', '2020-11-25 14:46:19', 1);
INSERT INTO `new_item` VALUES (21, '学生会', '2020-11-25 10:56:21', '2020-11-25 14:46:35', 1);
INSERT INTO `new_item` VALUES (22, '党支部', '2020-11-25 10:57:35', '2020-11-25 14:46:43', 1);
INSERT INTO `new_item` VALUES (23, '分团委', '2020-11-25 11:00:20', '2020-11-25 14:46:48', 1);
INSERT INTO `new_item` VALUES (24, '院团委', '2020-11-25 11:00:47', '2020-11-25 14:46:55', 1);
INSERT INTO `new_item` VALUES (25, 'qweqwe', '2020-11-25 11:01:37', '2020-11-25 11:01:37', 1);
INSERT INTO `new_item` VALUES (26, 'eqweqweqwe', '2020-11-25 11:01:53', '2020-11-25 11:01:53', 1);
INSERT INTO `new_item` VALUES (27, '分团委', '2020-11-25 11:11:35', '2020-11-25 15:49:18', 1);
INSERT INTO `new_item` VALUES (28, 'sadsads', '2020-11-25 11:17:59', '2020-11-25 11:18:40', 0);
INSERT INTO `new_item` VALUES (29, '院团委', '2020-11-25 11:29:13', '2020-11-25 15:49:25', 1);
INSERT INTO `new_item` VALUES (30, '789', '2020-11-25 11:30:54', '2020-11-25 11:37:19', 0);
INSERT INTO `new_item` VALUES (31, 'zyk', '2020-11-25 11:36:51', '2020-11-25 11:37:19', 0);
INSERT INTO `new_item` VALUES (32, '委员会', '2020-11-25 16:26:23', '2020-11-26 08:37:48', 0);
INSERT INTO `new_item` VALUES (33, '委员会~~~', '2020-11-25 16:26:37', '2020-11-26 10:01:40', 1);
INSERT INTO `new_item` VALUES (34, '演示~', '2020-11-26 10:01:29', '2020-11-26 10:01:33', 0);
INSERT INTO `new_item` VALUES (35, '筑基修士！！！', '2020-11-26 10:28:53', '2020-11-26 10:29:14', 1);
INSERT INTO `new_item` VALUES (36, '', '2022-12-27 16:27:20', '2022-12-27 16:27:20', 1);
INSERT INTO `new_item` VALUES (37, '222', '2022-12-27 16:27:31', '2022-12-27 16:27:31', 1);

-- ----------------------------
-- Table structure for news_info
-- ----------------------------
DROP TABLE IF EXISTS `news_info`;
CREATE TABLE `news_info`  (
  `new_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NULL DEFAULT NULL,
  `news_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `news_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL DEFAULT NULL,
  `news_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`new_id`) USING BTREE,
  INDEX `FK_Reference_4`(`item_id`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`item_id`) REFERENCES `new_item` (`item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_info
-- ----------------------------
INSERT INTO `news_info` VALUES (1, 2, '蓝桥杯比赛', NULL, NULL, NULL, '2020-11-23 09:27:39');
INSERT INTO `news_info` VALUES (2, 3, '新学期学费', NULL, NULL, NULL, '2020-11-23 09:28:10');
INSERT INTO `news_info` VALUES (3, 1, '拔河比赛', NULL, '拔河比赛要使劲！！！', '2020-11-25 14:57:28', '2020-11-25 14:57:32');
INSERT INTO `news_info` VALUES (4, 18, '街舞比赛', NULL, '一起摇摆~', '2020-11-25 15:54:09', '2020-11-25 15:54:11');
INSERT INTO `news_info` VALUES (10, 27, '数学建模', NULL, '一起加油！', '2020-11-25 16:10:02', '2020-11-25 22:17:19');
INSERT INTO `news_info` VALUES (11, 29, '班班唱', NULL, '《走向复兴》', '2020-11-25 16:12:23', '2020-11-25 16:12:23');
INSERT INTO `news_info` VALUES (12, 1, '篮球比赛', NULL, '冲冲冲~', '2020-11-25 16:13:04', '2020-11-25 16:13:04');
INSERT INTO `news_info` VALUES (13, 1, 'NECCS', NULL, '冲呀~', '2020-11-25 16:27:22', '2020-11-26 08:38:03');
INSERT INTO `news_info` VALUES (14, 18, '卓见杯', NULL, '啦啦啦~', '2020-11-25 17:41:32', '2020-11-25 22:17:56');
INSERT INTO `news_info` VALUES (15, 33, '动则升阳', NULL, '年轻不养生，年老养医生！', '2020-11-26 00:12:42', '2020-11-26 00:12:42');
INSERT INTO `news_info` VALUES (16, 33, '11月26日', NULL, '筑基修士', '2020-11-26 10:02:20', '2020-11-26 10:02:20');
INSERT INTO `news_info` VALUES (17, 35, '大家好', NULL, '333', '2020-11-26 10:29:35', '2020-11-26 10:29:35');
INSERT INTO `news_info` VALUES (18, 35, '大家好！！！', NULL, '333', '2020-11-26 10:29:45', '2020-11-26 10:29:45');
INSERT INTO `news_info` VALUES (19, 37, '3333', NULL, '4444', '2022-12-27 16:27:42', '2022-12-27 16:27:42');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `user_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(11) NULL DEFAULT 1 COMMENT '1:启用 0：禁用',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_hungarian_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '宋书航', '1', '2020-11-23 09:30:16', '2020-11-25 22:16:25', 1);
INSERT INTO `user_info` VALUES (2, '雨柔子', '1', '2020-11-23 11:25:41', '2020-11-25 22:16:25', 1);
INSERT INTO `user_info` VALUES (4, '王五', '1', '2020-11-23 11:25:58', '2020-11-25 22:16:26', 0);
INSERT INTO `user_info` VALUES (5, '赵柳', '1', '2020-11-23 11:26:12', '2020-11-25 22:16:26', 0);
INSERT INTO `user_info` VALUES (8, '田七', '1', '2020-11-23 11:26:29', '2020-11-25 22:16:27', 0);
INSERT INTO `user_info` VALUES (9, '田七', '1', '2020-11-23 15:03:23', '2020-11-25 22:16:28', 0);
INSERT INTO `user_info` VALUES (10, '田七', '1', '2020-11-23 15:03:43', '2020-11-25 22:16:28', 0);
INSERT INTO `user_info` VALUES (11, '戴沐白', '1', '2020-11-24 10:45:06', '2020-11-25 22:16:29', 1);
INSERT INTO `user_info` VALUES (12, '张小凡', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:29', 1);
INSERT INTO `user_info` VALUES (13, 'userName2', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:30', 0);
INSERT INTO `user_info` VALUES (15, '碧瑶', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:31', 1);
INSERT INTO `user_info` VALUES (16, '赵恋凡', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:31', 1);
INSERT INTO `user_info` VALUES (17, '李长寿', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:32', 1);
INSERT INTO `user_info` VALUES (18, '蓝梦娥', '1', '2020-11-24 10:45:29', '2020-11-25 22:16:33', 1);
INSERT INTO `user_info` VALUES (22, '路明非', '123456', '2020-11-24 10:45:29', '2020-11-25 17:44:31', 1);
INSERT INTO `user_info` VALUES (23, '楚子航', '123456', '2020-11-24 10:45:29', '2020-11-25 22:14:26', 1);
INSERT INTO `user_info` VALUES (33, '乔微尼', '123456', '2020-11-24 10:45:29', '2020-11-25 23:05:48', 1);
INSERT INTO `user_info` VALUES (97, 'userName86', '123456', '2020-11-24 10:45:32', '2020-11-24 10:45:32', 1);
INSERT INTO `user_info` VALUES (98, 'userName87', '123456', '2020-11-24 10:45:32', '2020-11-24 10:45:32', 1);
INSERT INTO `user_info` VALUES (99, 'userName88', '123456', '2020-11-24 10:45:32', '2020-11-24 10:45:32', 1);
INSERT INTO `user_info` VALUES (100, 'userName89', '123456', '2020-11-24 10:45:32', '2020-11-24 10:45:32', 1);
INSERT INTO `user_info` VALUES (101, '2020年好运来~', '123456', '2020-11-24 10:45:32', '2020-11-26 10:01:06', 1);
INSERT INTO `user_info` VALUES (102, '333', '123456', '2020-11-24 10:45:32', '2020-11-26 10:28:14', 1);
INSERT INTO `user_info` VALUES (103, '666', '888', '2020-11-24 10:45:32', '2020-11-26 10:28:26', 1);
INSERT INTO `user_info` VALUES (104, 'userName93', '123456', '2020-11-24 10:45:32', '2020-11-26 10:00:54', 0);
INSERT INTO `user_info` VALUES (105, 'userName94', '123456', '2020-11-24 10:45:32', '2020-11-26 10:00:47', 0);
INSERT INTO `user_info` VALUES (106, 'userName95', '123456', '2020-11-24 10:45:32', '2020-11-26 10:00:47', 0);
INSERT INTO `user_info` VALUES (107, 'userName96', '123456', '2020-11-24 10:45:32', '2020-11-26 10:00:47', 0);
INSERT INTO `user_info` VALUES (108, 'userName97', '123456', '2020-11-24 10:45:32', '2020-11-26 10:00:47', 0);
INSERT INTO `user_info` VALUES (109, 'userName98', '123456', '2020-11-24 10:45:32', '2020-11-25 10:12:58', 0);
INSERT INTO `user_info` VALUES (110, 'userName99', '123456', '2020-11-24 10:45:32', '2020-11-25 10:12:58', 0);
INSERT INTO `user_info` VALUES (111, 'userName100', '123456', '2020-11-24 10:45:33', '2020-11-25 10:12:58', 0);
INSERT INTO `user_info` VALUES (115, '萧潜', '1', '2020-11-25 23:00:16', '2020-11-25 23:00:16', 1);
INSERT INTO `user_info` VALUES (116, '演示视频', 'haha', '2020-11-26 10:00:33', '2020-11-26 10:27:37', 0);
INSERT INTO `user_info` VALUES (117, '啦啦啦', '1', '2020-11-26 10:27:14', '2020-11-26 10:27:37', 0);
INSERT INTO `user_info` VALUES (118, '演示视频', '222', '2020-11-26 10:27:23', '2020-11-26 10:27:37', 0);
INSERT INTO `user_info` VALUES (119, '实训小组hyy', '111', '2020-11-26 14:37:14', '2020-11-26 14:37:14', 1);

SET FOREIGN_KEY_CHECKS = 1;
