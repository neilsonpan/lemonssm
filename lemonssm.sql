/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.17 : Database - crmspmvc
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crmspmvc` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `crmspmvc`;

/*Table structure for table `lemon_customer` */

DROP TABLE IF EXISTS `lemon_customer`;

CREATE TABLE `lemon_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id 主键自增长ID',
  `customer_name` varchar(30) NOT NULL DEFAULT '' COMMENT '客户名字',
  `mobile` varchar(20) NOT NULL DEFAULT '0' COMMENT '手机账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别：0：未知， 1 ：男， 2：女',
  `effective` tinyint(1) NOT NULL DEFAULT '0' COMMENT '客户有效性：0：未验证， 1 ：验证无效， 2：验证有效',
  `region` tinyint(1) NOT NULL DEFAULT '0' COMMENT '组区域：0：未知， 1 ：上海， 2：北京',
  `bank_card` varchar(30) NOT NULL DEFAULT '' COMMENT '银行卡',
  `idcard_num` varchar(30) NOT NULL DEFAULT '' COMMENT '身份证',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `deleted_at` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除，0否，大于0是删除（大于0是存的删除的时间戳）',
  `belong_user_id` int(11) DEFAULT NULL COMMENT '归属id',
  `group_id` int(11) DEFAULT NULL COMMENT '归属组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户表';

/*Data for the table `lemon_customer` */

insert  into `lemon_customer`(`id`,`customer_name`,`mobile`,`password`,`sex`,`effective`,`region`,`bank_card`,`idcard_num`,`remark`,`deleted_at`,`belong_user_id`,`group_id`) values (1,'pcz','18221531111','111111',1,2,1,'888888','888888','',0,NULL,NULL);

/*Table structure for table `lemon_group` */

DROP TABLE IF EXISTS `lemon_group`;

CREATE TABLE `lemon_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lemon_group` */

/*Table structure for table `lemon_group_user` */

DROP TABLE IF EXISTS `lemon_group_user`;

CREATE TABLE `lemon_group_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `leve` tinyint(1) DEFAULT NULL COMMENT '等级 0组长 1组员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lemon_group_user` */

/*Table structure for table `lemon_seat_info` */

DROP TABLE IF EXISTS `lemon_seat_info`;

CREATE TABLE `lemon_seat_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seat_num` int(11) DEFAULT NULL COMMENT '坐席号',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 0未使用 1使用 3废弃',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lemon_seat_info` */

/*Table structure for table `lemon_user` */

DROP TABLE IF EXISTS `lemon_user`;

CREATE TABLE `lemon_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seat_num` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lemon_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
