/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50643
Source Host           : 127.0.0.1:3306
Source Database       : attendance

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-07-05 15:46:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for checkreport
-- ----------------------------
DROP TABLE IF EXISTS `checkreport`;
CREATE TABLE `checkreport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffCode` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `morningBusinessHours` varchar(255) DEFAULT NULL,
  `afternoonBusinessHours` varchar(255) DEFAULT NULL,
  `attendanceSituation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of checkreport
-- ----------------------------
INSERT INTO `checkreport` VALUES ('1', 'CZX', '陈知心', '2019-06-01 08:00', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('3', 'ZS', '张三', '2019-06-01 08:30', '2019-06-01 16:30', '早退');
INSERT INTO `checkreport` VALUES ('5', 'LS', '李四', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('7', 'WEG', '王二狗', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('9', 'ZG', '赵构', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('11', 'CH', '翠花', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('13', 'LY', '刘英', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('15', 'XDJ', '谢大脚', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('17', 'YQ', '永强', '2019-06-01 09:30', '2019-06-01 17:30', '迟到');
INSERT INTO `checkreport` VALUES ('19', 'LN', '刘能', '2019-06-01 08:30', '2019-06-01 17:30', '正常');
INSERT INTO `checkreport` VALUES ('21', 'CZX', '陈知心', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('23', 'ZS', '张三', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('25', 'LS', '李四', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('27', 'WEG', '王二狗', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('29', 'ZG', '赵构', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('31', 'CH', '翠花', '2019-06-02 08:00', '2019-06-02 16:30', '早退');
INSERT INTO `checkreport` VALUES ('33', 'LY', '刘英', '2019-06-02 07:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('35', 'XDJ', '谢大脚', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('37', 'YQ', '永强', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('39', 'LN', '刘能', '2019-06-02 08:00', '2019-06-02 17:30', '正常');
INSERT INTO `checkreport` VALUES ('42', 'CZX', '陈知心', '2019-06-03 17:30', null, '旷工');
INSERT INTO `checkreport` VALUES ('43', 'ZS', '张三', '2019-06-03 08:00', null, '旷工');
INSERT INTO `checkreport` VALUES ('45', 'LS', '李四', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('47', 'WEG', '王二狗', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('49', 'ZG', '赵构', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('51', 'CH', '翠花', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('53', 'LY', '刘英', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('55', 'XDJ', '谢大脚', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('57', 'YQ', '永强', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('59', 'LN', '刘能', '2019-06-03 08:00', '2019-06-03 17:30', '正常');
INSERT INTO `checkreport` VALUES ('61', 'CZX', '陈知心', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('63', 'ZS', '张三', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('66', 'LS', '李四', '2019-06-04 17:30', null, '旷工');
INSERT INTO `checkreport` VALUES ('67', 'WEG', '王二狗', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('69', 'ZG', '赵构', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('71', 'CH', '翠花', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('73', 'LY', '刘英', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('75', 'XDJ', '谢大脚', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('77', 'YQ', '永强', '2019-06-04 08:00', null, '旷工');
INSERT INTO `checkreport` VALUES ('79', 'LN', '刘能', '2019-06-04 08:00', '2019-06-04 17:30', '正常');
INSERT INTO `checkreport` VALUES ('81', 'CZX', '陈知心', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('83', 'ZS', '张三', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('85', 'LS', '李四', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('87', 'WEG', '王二狗', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('89', 'ZG', '赵构', '2019-06-05 08:00', null, '旷工');
INSERT INTO `checkreport` VALUES ('91', 'CH', '翠花', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('93', 'LY', '刘英', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('95', 'XDJ', '谢大脚', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('97', 'YQ', '永强', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('99', 'LN', '刘能', '2019-06-05 08:00', '2019-06-05 17:30', '正常');
INSERT INTO `checkreport` VALUES ('101', 'CZX', '陈知心', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('103', 'ZS', '张三', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('105', 'LS', '李四', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('107', 'WEG', '王二狗', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('109', 'ZG', '赵构', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('111', 'CH', '翠花', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('113', 'LY', '刘英', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('115', 'XDJ', '谢大脚', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('117', 'YQ', '永强', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('119', 'LN', '刘能', '2019-06-06 08:00', '2019-06-06 17:30', '正常');
INSERT INTO `checkreport` VALUES ('121', 'CZX', '陈知心', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('123', 'ZS', '张三', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('125', 'LS', '李四', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('127', 'WEG', '王二狗', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('129', 'ZG', '赵构', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('131', 'CH', '翠花', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('133', 'LY', '刘英', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('135', 'XDJ', '谢大脚', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('137', 'YQ', '永强', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('139', 'LN', '刘能', '2019-06-07 08:00', '2019-06-07 17:30', '正常');
INSERT INTO `checkreport` VALUES ('143', 'LN', '刘能', '2019-06-08 07:30', '2019-06-08 17:30', '正常');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `morningBusinessHours` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `afternoonBusinessHours` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('6', 'ZB', '早班', '08:00', '17:00', null);
INSERT INTO `classes` VALUES ('7', 'WB', '晚班', '12:00', '22:00', null);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentID` int(11) NOT NULL AUTO_INCREMENT,
  `departmentCode` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `departmentName` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `departmentHead` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `departmentResponsibility` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `superiorDepartmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`departmentID`,`departmentCode`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=601 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('100', 'ZCS', '总裁室', '王二狗', '管理公司', null);
INSERT INTO `department` VALUES ('200', 'KFZ', '总裁', '陈知心', '管理开发项目', '200');
INSERT INTO `department` VALUES ('300', 'CWB', '财务部', '谢大脚', '管理公司财务', '100');
INSERT INTO `department` VALUES ('400', 'HR', '人力资源部', '陈知心', '人员招聘', '100');
INSERT INTO `department` VALUES ('500', 'QT', '前台', '翠花', '前台引导', '400');
INSERT INTO `department` VALUES ('600', 'HQ', '后勤', '赵构', '后勤服务', '400');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `staffCode` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `sex` varchar(50) COLLATE utf8_unicode_520_ci DEFAULT '未知',
  `age` int(255) DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `idNumber` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `salary` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `emergencyContact` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `emergencyContactNumber` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `stationId` int(11) DEFAULT NULL,
  `individualDescription` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`emp_id`,`staffCode`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('10001', 'CZX', '陈知心', '男', '25', '汉族', '1', '4000', '18812345678', '小A', '28812345678', '203', '前端开发');
INSERT INTO `employees` VALUES ('10002', 'ZS', '张三', '男', '20', '汉族', '2', '6500', '13012345678', '小B', '23012345678', '202', '前端开发');
INSERT INTO `employees` VALUES ('10003', 'LS', '李四', '男', '31', '汉族', '3', '8000', '13512345678', '小C', '23512345678', '201', '后端开发');
INSERT INTO `employees` VALUES ('10004', 'WEG', '王二狗', '男', '35', '汉族', '4', '12000', '13912345678', '小D', '23912345678', '101', '总经理');
INSERT INTO `employees` VALUES ('10005', 'ZG', '赵构', '男', '22', '汉族', '5', '3500', '17712345678', '小E', '27712345678', '601', '后勤');
INSERT INTO `employees` VALUES ('10006', 'CH', '翠花', '女', '26', '汉族', '6', '4000', '16812345678', '小F', '26812345678', '501', '前台');
INSERT INTO `employees` VALUES ('10007', 'LY', '刘英', '女', '28', '汉族', '7', '6500', '15512345678', '小G', '25512345678', '401', 'HR招聘');
INSERT INTO `employees` VALUES ('10008', 'XDJ', '谢大脚', '女', '31', '汉族', '8', '5500', '13812345678', '小H', '23812345678', '301', '财务');
INSERT INTO `employees` VALUES ('10009', 'YQ', '永强', '男', '24', '汉族', '9', '4000', '15312345678', '小N', '25312345678', '302', '财务');
INSERT INTO `employees` VALUES ('10010', 'LN', '刘能', '男', '26', '汉族', '10', '5000', '17912345678', '小M', '27912345678', '402', 'HR招聘');

-- ----------------------------
-- Table structure for leaves
-- ----------------------------
DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pleaseDummyMan` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `startTime` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `endTime` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `leaveReason` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of leaves
-- ----------------------------
INSERT INTO `leaves` VALUES ('1', '陈知心', '2019-06-03', '2019-06-03', '肚子痛迟到');
INSERT INTO `leaves` VALUES ('2', '张三', '2019-06-03', '2019-06-03', '提前下班接孩子');
INSERT INTO `leaves` VALUES ('3', '李四', '2019-06-04', '2019-06-04', '身体不适');
INSERT INTO `leaves` VALUES ('4', '永强', '2019-06-04', '2019-06-04', '身体不适提前下班');
INSERT INTO `leaves` VALUES ('5', '赵构', '2019-06-05', '2019-06-05', '提前下班参加婚礼');

-- ----------------------------
-- Table structure for paysalary
-- ----------------------------
DROP TABLE IF EXISTS `paysalary`;
CREATE TABLE `paysalary` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `SalariedMan` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `salary` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `calculateStartDate` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `CalculateEndDate` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `PaidTime` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of paysalary
-- ----------------------------
INSERT INTO `paysalary` VALUES ('10001', '陈知心', null, '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10002', '张三', '6500', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10003', '李四', '8000', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10004', '王二狗', '12000', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10005', '赵构', '3500', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10006', '翠花', '4000', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10007', '刘英', '6500', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10008', '谢大脚', '5500', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10009', '永强', '4000', '2019-06-01', '2019-06-30', '2019-07-01');
INSERT INTO `paysalary` VALUES ('10010', '刘能', '5000', '2019-06-01', '2019-06-30', '2019-07-01');

-- ----------------------------
-- Table structure for punchcard
-- ----------------------------
DROP TABLE IF EXISTS `punchcard`;
CREATE TABLE `punchcard` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `punchCardMan` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL COMMENT '只读,默认为当前系统登录者',
  `punchCardDate` varchar(255) COLLATE utf8_unicode_520_ci NOT NULL,
  `Remark` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of punchcard
-- ----------------------------
INSERT INTO `punchcard` VALUES ('1', '陈知心', '2019-06-01 08:00', null);
INSERT INTO `punchcard` VALUES ('2', '陈知心', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('3', '张三', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('4', '张三', '2019-06-01 16:30', null);
INSERT INTO `punchcard` VALUES ('5', '李四', '2019-06-01 08:30', '');
INSERT INTO `punchcard` VALUES ('7', '王二狗', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('8', '王二狗', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('9', '赵构', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('10', '赵构', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('11', '翠花', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('12', '翠花', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('14', '刘英', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('15', '谢大脚', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('16', '谢大脚', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('17', '永强', '2019-06-01 09:30', null);
INSERT INTO `punchcard` VALUES ('18', '永强', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('19', '刘能', '2019-06-01 08:30', null);
INSERT INTO `punchcard` VALUES ('20', '刘能', '2019-06-01 17:30', null);
INSERT INTO `punchcard` VALUES ('22', '陈知心', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('23', '张三', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('24', '张三', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('25', '李四', '2019-06-02 08:00', '');
INSERT INTO `punchcard` VALUES ('26', '李四', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('27', '王二狗', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('28', '王二狗', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('29', '赵构', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('30', '赵构', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('31', '翠花', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('32', '翠花', '2019-06-02 16:30', null);
INSERT INTO `punchcard` VALUES ('33', '刘英', '2019-06-02 07:00', null);
INSERT INTO `punchcard` VALUES ('34', '刘英', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('35', '谢大脚', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('36', '谢大脚', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('37', '永强', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('38', '永强', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('39', '刘能', '2019-06-02 08:00', null);
INSERT INTO `punchcard` VALUES ('40', '刘能', '2019-06-02 17:30', null);
INSERT INTO `punchcard` VALUES ('42', '陈知心', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('43', '张三', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('45', '李四', '2019-06-03 08:00', '');
INSERT INTO `punchcard` VALUES ('46', '李四', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('47', '王二狗', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('48', '王二狗', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('49', '赵构', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('50', '赵构', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('51', '翠花', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('53', '刘英', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('54', '刘英', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('55', '谢大脚', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('56', '谢大脚', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('57', '永强', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('58', '永强', '2019-06-03 17:30', null);
INSERT INTO `punchcard` VALUES ('59', '刘能', '2019-06-03 08:00', null);
INSERT INTO `punchcard` VALUES ('61', '陈知心', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('62', '陈知心', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('63', '张三', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('64', '张三', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('66', '李四', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('67', '王二狗', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('68', '王二狗', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('69', '赵构', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('70', '赵构', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('72', '翠花', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('73', '刘英', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('74', '刘英', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('75', '谢大脚', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('76', '谢大脚', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('77', '永强', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('79', '刘能', '2019-06-04 08:00', null);
INSERT INTO `punchcard` VALUES ('80', '刘能', '2019-06-04 17:30', null);
INSERT INTO `punchcard` VALUES ('81', '陈知心', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('82', '陈知心', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('83', '张三', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('84', '张三', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('85', '李四', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('86', '李四', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('87', '王二狗', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('88', '王二狗', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('89', '赵构', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('91', '翠花', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('92', '翠花', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('93', '刘英', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('94', '刘英', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('95', '谢大脚', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('96', '谢大脚', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('97', '永强', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('98', '永强', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('99', '刘能', '2019-06-05 08:00', null);
INSERT INTO `punchcard` VALUES ('100', '刘能', '2019-06-05 17:30', null);
INSERT INTO `punchcard` VALUES ('101', '陈知心', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('102', '陈知心', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('103', '张三', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('104', '张三', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('105', '李四', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('106', '李四', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('107', '王二狗', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('108', '王二狗', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('109', '赵构', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('110', '赵构', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('111', '翠花', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('112', '翠花', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('113', '刘英', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('114', '刘英', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('115', '谢大脚', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('116', '谢大脚', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('117', '永强', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('118', '永强', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('119', '刘能', '2019-06-06 08:00', null);
INSERT INTO `punchcard` VALUES ('120', '刘能', '2019-06-06 17:30', null);
INSERT INTO `punchcard` VALUES ('121', '陈知心', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('122', '陈知心', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('123', '张三', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('124', '张三', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('125', '李四', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('126', '李四', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('127', '王二狗', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('128', '王二狗', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('129', '赵构', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('130', '赵构', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('131', '翠花', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('132', '翠花', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('133', '刘英', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('134', '刘英', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('135', '谢大脚', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('136', '谢大脚', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('137', '永强', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('138', '永强', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('139', '刘能', '2019-06-07 08:00', null);
INSERT INTO `punchcard` VALUES ('140', '刘能', '2019-06-07 17:30', null);
INSERT INTO `punchcard` VALUES ('143', '刘能', '2019-06-08 07:30', null);
INSERT INTO `punchcard` VALUES ('144', '刘能', '2019-06-08 17:30', null);

-- ----------------------------
-- Table structure for repaircrad
-- ----------------------------
DROP TABLE IF EXISTS `repaircrad`;
CREATE TABLE `repaircrad` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `repairCradMan` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `repairCradDate` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `repairCradReason` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of repaircrad
-- ----------------------------
INSERT INTO `repaircrad` VALUES ('6', '李四', '2019-06-01 17:30', '忘记打卡');
INSERT INTO `repaircrad` VALUES ('13', '刘英', '2019-06-01 08:30', '忘记');
INSERT INTO `repaircrad` VALUES ('21', '陈知心', '2019-06-02 08:00', '来太早忘记');
INSERT INTO `repaircrad` VALUES ('52', '翠花', '2019-06-03 17:30', '忘记打卡');
INSERT INTO `repaircrad` VALUES ('60', '刘能', '2019-06-03 17:30', '忘记打卡');
INSERT INTO `repaircrad` VALUES ('71', '翠花', '2019-06-04 08:00', '忘记了');
INSERT INTO `repaircrad` VALUES ('86', '李四', '2019-06-05 17:30', '下班急着回家忘记打卡');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station` (
  `stationId` int(11) NOT NULL AUTO_INCREMENT,
  `stationCode` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `stationName` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `department` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `immediateSuperior` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `stationCategory` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `stationDescription` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`stationId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES ('101', 'ZC', '总裁', '总裁室', null, '管理类', '管理公司');
INSERT INTO `station` VALUES ('201', 'HDKF', '后端开发', 'ZCS', '101', '技术类', '管理开发项目');
INSERT INTO `station` VALUES ('202', 'QDKF', '前端开发', 'ZCS', '101', '技术类', '前端开发');
INSERT INTO `station` VALUES ('301', 'CWRY', '财务人员', 'ZCS', '101', '文职类', '管理财务');
INSERT INTO `station` VALUES ('401', 'HRRY', 'HR人员', 'ZCS', '101', '管理类', '人员招聘');
INSERT INTO `station` VALUES ('501', 'QTRY', '前台人员', 'ZCS', '101', '文职类', '前台引导');

-- ----------------------------
-- Table structure for tlogin
-- ----------------------------
DROP TABLE IF EXISTS `tlogin`;
CREATE TABLE `tlogin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  `PassWord` varchar(255) COLLATE utf8_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10017 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_520_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tlogin
-- ----------------------------
INSERT INTO `tlogin` VALUES ('10016', 'Admin', '1');
