/*
SQLyog Community Edition- MySQL GUI v6.03
Host - 5.0.22-community-nt : Database - college_management
*********************************************************************
Server version : 5.0.22-community-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `college_management`;

USE `college_management`;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `assign` */

CREATE TABLE `assign` (
  `sender` varchar(20) default NULL,
  `reciever` varchar(20) default NULL,
  `sender_id` varchar(25) default NULL,
  `date` date default NULL,
  `message` text,
  `upfile` mediumblob,
  `aid` int(11) NOT NULL auto_increment,
  `sender_name` varchar(20) default NULL,
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `complain` */

CREATE TABLE `complain` (
  `sender` varchar(50) default NULL,
  `reciever` varchar(50) default NULL,
  `message` text,
  `reply` text,
  `complain_id` int(11) NOT NULL auto_increment,
  `complain_date` date default NULL,
  `reply_date` date default NULL,
  `category` varchar(20) default NULL,
  PRIMARY KEY  (`complain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `management` */

CREATE TABLE `management` (
  `management_ID` varchar(20) NOT NULL,
  `name` varchar(40) default NULL,
  `contact` varchar(14) default NULL,
  `password` varchar(20) default NULL,
  `gender` varchar(10) default NULL,
  `aadhar_no` varchar(12) default NULL,
  `blood_group` varchar(3) default NULL,
  `department` varchar(50) default NULL,
  `qualification` varchar(60) default NULL,
  `experience` int(11) default NULL,
  `joining_year` int(11) default NULL,
  `designation` varchar(50) default NULL,
  `address` varchar(80) default NULL,
  `dob` date default NULL,
  `category` varchar(10) default NULL,
  `mail_id` varchar(50) default NULL,
  `sno` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`management_ID`),
  UNIQUE KEY `sno` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `notice` */

CREATE TABLE `notice` (
  `reciever` varchar(10) default NULL,
  `sender` varchar(10) default NULL,
  `sender_id` varchar(15) default NULL,
  `date` date default NULL,
  `message` text,
  `nid` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `student` */

CREATE TABLE `student` (
  `enrollment` varchar(20) NOT NULL,
  `name` varchar(40) default NULL,
  `father_name` varchar(40) default NULL,
  `password` varchar(20) default NULL,
  `gender` varchar(10) default NULL,
  `aadhar_no` varchar(12) default NULL,
  `blood_group` varchar(3) default NULL,
  `branch` varchar(60) default NULL,
  `admission_year` int(11) default NULL,
  `mail_id` varchar(80) default NULL,
  `contact` varchar(14) default NULL,
  `address` varchar(200) default NULL,
  `dob` date default NULL,
  `sno` int(11) NOT NULL auto_increment,
  `category` varchar(20) default NULL,
  PRIMARY KEY  (`enrollment`),
  UNIQUE KEY `sno` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;