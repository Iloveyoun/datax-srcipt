/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.39 : Database - datax_script
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`datax_script` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `datax_script`;

/*Table structure for table `t_pub_etl_jobs` */

DROP TABLE IF EXISTS `t_pub_etl_jobs`;

CREATE TABLE `t_pub_etl_jobs` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_seq` int(11) DEFAULT NULL COMMENT 'job顺序号',
  `job_type` char(1) DEFAULT NULL COMMENT 'job类型',
  `reader_type` varchar(30) DEFAULT 'mysqlreader' COMMENT 'reader类型',
  `writer_type` varchar(30) DEFAULT 'mysqlwriter' COMMENT 'writer类型',
  `src_system_id` varchar(32) DEFAULT NULL COMMENT '源系统Schema',
  `des_system_id` varchar(32) DEFAULT NULL COMMENT '目标系统Schema',
  `src_object_name` varchar(64) DEFAULT NULL COMMENT '源系统对象名称',
  `des_object_name` varchar(64) DEFAULT NULL COMMENT '目标系统对象名称',
  `src_object_desc` varchar(1000) DEFAULT NULL COMMENT '源对象描述',
  `split_pk` varchar(50) DEFAULT NULL COMMENT '切分键',
  `where` varchar(5000) DEFAULT '1=1' COMMENT 'where条件',
  `cols` varchar(10000) DEFAULT '*' COMMENT '加载列',
  `frequency` tinyint(4) DEFAULT NULL COMMENT '加载频率',
  `valid_flag` char(1) DEFAULT '1' COMMENT 'job是否有效标志',
  `last_update` varchar(24) DEFAULT NULL COMMENT '最近更新时刻',
  `job_name` varchar(64) DEFAULT NULL COMMENT 'job名称',
  `module_type` varchar(64) DEFAULT NULL COMMENT 'job模块类型',
  `job_script_template_name` varchar(64) DEFAULT NULL COMMENT '生成json文件的模板名称',
  `job_script_run_name` varchar(64) DEFAULT NULL COMMENT '要执行的json文件名称',
  `is_create_script` char(1) DEFAULT '0' COMMENT '是否自动生成脚本::0:每次自动生成，1：job_script_run_name为空时生成',
  `ddl_auto_sync` char(1) DEFAULT '0' COMMENT '是否自动更新cols,0:不更新，1:当cols列为空或*时更新',
  `ddl_specific` varchar(1024) DEFAULT NULL COMMENT 'ddl修饰',
  `cols_cal_def` varchar(1024) DEFAULT NULL COMMENT '计算/转换列定义',
  `cols_cal_exp` varchar(1024) DEFAULT NULL COMMENT '计算/转换列表达式',
  `core_byte` int(11) DEFAULT NULL COMMENT 'core_byte限速(单channel字节)',
  `job_byte` int(11) DEFAULT NULL COMMENT 'job_byte限速(全局字节)',
  `core_record` int(11) DEFAULT NULL COMMENT 'core_record限速(单channel条数)',
  `job_record` int(11) DEFAULT NULL COMMENT 'job_record限速(全局channel条数)',
  `job_channel` int(11) DEFAULT NULL COMMENT '全局并发',
  `job_jvm_xms` int(11) DEFAULT NULL COMMENT 'JVM堆内存初始大小(G)',
  `job_jvm_xmx` int(11) DEFAULT NULL COMMENT 'JVM堆内存最大大小(G)',
  PRIMARY KEY (`job_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_pub_etl_jobs` */

LOCK TABLES `t_pub_etl_jobs` WRITE;

insert  into `t_pub_etl_jobs`(`job_id`,`job_seq`,`job_type`,`reader_type`,`writer_type`,`src_system_id`,`des_system_id`,`src_object_name`,`des_object_name`,`src_object_desc`,`split_pk`,`where`,`cols`,`frequency`,`valid_flag`,`last_update`,`job_name`,`module_type`,`job_script_template_name`,`job_script_run_name`,`is_create_script`,`ddl_auto_sync`,`ddl_specific`,`cols_cal_def`,`cols_cal_exp`,`core_byte`,`job_byte`,`core_record`,`job_record`,`job_channel`,`job_jvm_xms`,`job_jvm_xmx`)
values (1,1,'0','test','test',NULL,NULL,'test_1','test_1','测试',NULL,'1=1','*',NULL,'1','','','ZZ1','job.ftl','','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,2)
,(2,2,'0','mysqlreader','mysqlwriter',NULL,NULL,'student_1','student_1','学生测试表',NULL,'1=1','*',NULL,'0','','','ZZ1','mysqlTomysql.ftl','','0','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,2);

UNLOCK TABLES;

/*Table structure for table `t_pub_etl_logs` */

DROP TABLE IF EXISTS `t_pub_etl_logs`;

CREATE TABLE `t_pub_etl_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `job_name` varchar(50) DEFAULT NULL COMMENT 'JOB名称',
  `src_object_name` varchar(64) DEFAULT NULL COMMENT '源系统名称',
  `des_object_name` varchar(64) DEFAULT NULL COMMENT '目标系统名称',
  `datax_script_name` varchar(300) DEFAULT NULL COMMENT '执行的datax命令',
  `datax_start_time` varchar(25) DEFAULT NULL COMMENT 'datax任务启动时刻',
  `datax_end_time` varchar(25) DEFAULT NULL COMMENT 'datax任务结束时刻',
  `datax_elapsed` varchar(20) DEFAULT NULL COMMENT 'datax任务总计耗时',
  `datax_avg_flowrate` varchar(20) DEFAULT NULL COMMENT 'datax任务平均流量',
  `datax_input_speed` varchar(30) DEFAULT NULL COMMENT 'datax记录写入速度',
  `datax_output_num` varchar(31) DEFAULT NULL COMMENT 'datax读出记录总数',
  `datax_fail_num` varchar(31) DEFAULT NULL COMMENT 'datax读写失败总数',
  `start_time` varchar(24) DEFAULT NULL COMMENT '开始时间戳',
  `end_time` varchar(24) DEFAULT NULL COMMENT '结束时间戳',
  `elapsed` varchar(32) DEFAULT NULL COMMENT '消耗时间(秒)',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `status_desc` varchar(16) DEFAULT NULL COMMENT '状态说明',
  `is_successful` varchar(1) DEFAULT NULL COMMENT '是否成功',
  `param_info` varchar(500) DEFAULT NULL COMMENT '参数信息',
  `error_1` varchar(5000) DEFAULT NULL COMMENT '错误信息_1',
  `error_2` varchar(5000) DEFAULT NULL COMMENT '错误信息_2',
  `error_3` varchar(5000) DEFAULT NULL COMMENT '错误信息_3',
  `rec_create_time` varchar(24) DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_pub_etl_logs` */

LOCK TABLES `t_pub_etl_logs` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
