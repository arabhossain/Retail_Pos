-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2016 at 02:08 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `retailsystem`
--
CREATE DATABASE `retailsystem` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `retailsystem`;

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE IF NOT EXISTS `branches` (
  `bID` int(11) NOT NULL AUTO_INCREMENT,
  `bName` varchar(100) NOT NULL,
  `bAdressLine1` varchar(500) NOT NULL,
  `bAdressLine2` varchar(500) NOT NULL,
  `bHeadBranch` int(11) NOT NULL,
  PRIMARY KEY (`bID`),
  UNIQUE KEY `bName` (`bName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`bID`, `bName`, `bAdressLine1`, `bAdressLine2`, `bHeadBranch`) VALUES
(1, 'Jamal Gong', 'Paharpur RoaD', 'Naogaon, Rajshahi', 1),
(2, 'Joypur Hat', 'Bogra Road', 'Joypur GPO, Rajshahi', 0);

-- --------------------------------------------------------

--
-- Table structure for table `breaks`
--

CREATE TABLE IF NOT EXISTS `breaks` (
  `bID` int(11) NOT NULL AUTO_INCREMENT,
  `bName` varchar(100) NOT NULL,
  `bVisibility` int(11) NOT NULL,
  `bNote` varchar(500) NOT NULL,
  `bCreatedDate` datetime NOT NULL,
  PRIMARY KEY (`bID`),
  UNIQUE KEY `bName` (`bName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `breaks`
--

INSERT INTO `breaks` (`bID`, `bName`, `bVisibility`, `bNote`, `bCreatedDate`) VALUES
(3, 'Lunch', 1, 'Lunch Break for 30 Minuts. Stuff should get back before the certain prieoud of time', '2016-01-13 18:51:44');

-- --------------------------------------------------------

--
-- Table structure for table `customerslist`
--

CREATE TABLE IF NOT EXISTS `customerslist` (
  `cSerial` int(11) NOT NULL AUTO_INCREMENT,
  `cID` varchar(200) NOT NULL,
  `cName` varchar(150) NOT NULL,
  `cMobile` varchar(20) NOT NULL,
  `cEmail` varchar(100) NOT NULL,
  `cFax` varchar(100) NOT NULL,
  `cHouse` varchar(100) NOT NULL,
  `cRoad` varchar(100) NOT NULL,
  `cBlock` varchar(100) NOT NULL,
  `cSection` varchar(100) NOT NULL,
  `cArea` varchar(100) NOT NULL,
  `cCity` varchar(100) NOT NULL,
  `cVillageAddress` varchar(500) NOT NULL,
  `cPhotoURL` varchar(150) NOT NULL,
  `cJoinDate` date NOT NULL,
  `cAddUserID` int(11) NOT NULL,
  `cBrancID` int(11) NOT NULL,
  PRIMARY KEY (`cSerial`),
  UNIQUE KEY `cID` (`cID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `customerslist`
--

INSERT INTO `customerslist` (`cSerial`, `cID`, `cName`, `cMobile`, `cEmail`, `cFax`, `cHouse`, `cRoad`, `cBlock`, `cSection`, `cArea`, `cCity`, `cVillageAddress`, `cPhotoURL`, `cJoinDate`, `cAddUserID`, `cBrancID`) VALUES
(2, 'CU211', 'Emon ', '483927489', 'test@test.com', '23424234', '32', '4 ', 'D', '10', 'Mirpur', 'Dhaka', '', './img/customers/Emon Hossain_IMG_20151008_000502.jpg', '2016-01-04', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `leavelist`
--

CREATE TABLE IF NOT EXISTS `leavelist` (
  `lID` int(11) NOT NULL AUTO_INCREMENT,
  `lStuffID` int(11) NOT NULL,
  `lReasion` varchar(1000) NOT NULL,
  `lStartDate` date NOT NULL,
  `lEndDate` date NOT NULL,
  `lRequestStuffID` int(11) NOT NULL,
  `lApproved` int(11) NOT NULL,
  `lRequestSeenAt` datetime NOT NULL,
  `lRequestTime` datetime NOT NULL,
  PRIMARY KEY (`lID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `leavelist`
--

INSERT INTO `leavelist` (`lID`, `lStuffID`, `lReasion`, `lStartDate`, `lEndDate`, `lRequestStuffID`, `lApproved`, `lRequestSeenAt`, `lRequestTime`) VALUES
(1, 1, 'dsfdfsfsfdsfdsf', '2016-01-11', '2016-01-13', 2, 0, '2016-01-08 13:00:21', '2016-01-08 12:46:57'),
(2, 1, 'dsfdfsfsfdsfdsf', '2016-01-11', '2016-01-13', 2, 0, '2016-01-08 00:00:00', '2016-01-08 12:48:25');

-- --------------------------------------------------------

--
-- Table structure for table `pricechangelog`
--

CREATE TABLE IF NOT EXISTS `pricechangelog` (
  `pCLID` int(11) NOT NULL AUTO_INCREMENT,
  `pPID` varchar(200) NOT NULL,
  `pPreviousPrice` double NOT NULL,
  `pChagedPrice` double NOT NULL,
  `pUserID` int(11) NOT NULL,
  `pChangedDate` date NOT NULL,
  PRIMARY KEY (`pCLID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `pricechangelog`
--

INSERT INTO `pricechangelog` (`pCLID`, `pPID`, `pPreviousPrice`, `pChagedPrice`, `pUserID`, `pChangedDate`) VALUES
(3, 'PD1211', 4, 14, 1, '2016-01-13');

-- --------------------------------------------------------

--
-- Table structure for table `productcategories`
--

CREATE TABLE IF NOT EXISTS `productcategories` (
  `catID` int(11) NOT NULL AUTO_INCREMENT,
  `catName` varchar(50) NOT NULL,
  `catPhotoURL` varchar(500) NOT NULL,
  `catVisibile` int(11) NOT NULL,
  PRIMARY KEY (`catID`),
  UNIQUE KEY `catName` (`catName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `productcategories`
--

INSERT INTO `productcategories` (`catID`, `catName`, `catPhotoURL`, `catVisibile`) VALUES
(1, 'Fruite', './img/Categories/Fruite_Penguins.jpg', 1),
(3, 'Others', '/images/cat.png', 1),
(4, 'Battery', '/images/cat.png', 1);

-- --------------------------------------------------------

--
-- Table structure for table `productslist`
--

CREATE TABLE IF NOT EXISTS `productslist` (
  `pListID` int(11) NOT NULL AUTO_INCREMENT,
  `pID` varchar(200) NOT NULL,
  `pBarcode` varchar(500) NOT NULL,
  `pName` varchar(100) NOT NULL,
  `pCatID` int(11) NOT NULL,
  `pTaxID` int(11) NOT NULL,
  `pUnitID` int(11) NOT NULL,
  `pSalePrice` double NOT NULL,
  `pPhotoURL` varchar(500) NOT NULL,
  `pVisible` int(11) NOT NULL,
  `pAddedDate` date NOT NULL,
  `pAdminViewed` int(11) NOT NULL,
  PRIMARY KEY (`pListID`),
  UNIQUE KEY `pID` (`pID`),
  UNIQUE KEY `pBarcode` (`pBarcode`),
  UNIQUE KEY `pName` (`pName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `productslist`
--

INSERT INTO `productslist` (`pListID`, `pID`, `pBarcode`, `pName`, `pCatID`, `pTaxID`, `pUnitID`, `pSalePrice`, `pPhotoURL`, `pVisible`, `pAddedDate`, `pAdminViewed`) VALUES
(11, 'PD1111', 'testBarcodes', 'Mango', 1, 2, 3, 200, './img/products/Mango_Desert.jpg', 1, '2016-01-03', 0),
(12, 'PD1211', 'Banana', 'Banana', 1, 1, 3, 14, '/images/productes.png', 0, '2016-01-03', 0),
(13, 'PD1311', 'testBarcb', 'Valbo 12w', 4, 2, 3, 1200, './img/products/Valbo 12w_battery-80.png', 1, '2016-01-06', 0);

-- --------------------------------------------------------

--
-- Table structure for table `productunits`
--

CREATE TABLE IF NOT EXISTS `productunits` (
  `pUniID` int(11) NOT NULL AUTO_INCREMENT,
  `pUniName` varchar(50) NOT NULL,
  PRIMARY KEY (`pUniID`),
  UNIQUE KEY `pUniName` (`pUniName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `productunits`
--

INSERT INTO `productunits` (`pUniID`, `pUniName`) VALUES
(5, 'Darjon'),
(1, 'Kg'),
(6, 'Litter'),
(4, 'ml'),
(3, 'Pice');

-- --------------------------------------------------------

--
-- Table structure for table `taxes`
--

CREATE TABLE IF NOT EXISTS `taxes` (
  `taxID` int(11) NOT NULL AUTO_INCREMENT,
  `taxName` varchar(50) NOT NULL,
  `taxValue` int(11) NOT NULL,
  PRIMARY KEY (`taxID`),
  UNIQUE KEY `taxName` (`taxName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `taxes`
--

INSERT INTO `taxes` (`taxID`, `taxName`, `taxValue`) VALUES
(1, 'General Tax', 15),
(2, 'No Tax', 0);

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE IF NOT EXISTS `userrole` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `Sales` int(11) NOT NULL,
  `EditSales` int(11) NOT NULL,
  `CustomerPayment` int(11) NOT NULL,
  `Expence` int(11) NOT NULL,
  `CashClose` int(11) NOT NULL,
  `Customers` int(11) NOT NULL,
  `Users` int(11) NOT NULL,
  `Stoke` int(11) NOT NULL,
  `Reports` int(11) NOT NULL,
  `PresenceManage` int(11) NOT NULL,
  `Tools` int(11) NOT NULL,
  `Config` int(11) NOT NULL,
  `Taxes` int(11) NOT NULL,
  `UsersRole` int(11) NOT NULL,
  `RoleName` varchar(100) NOT NULL,
  PRIMARY KEY (`RoleID`),
  UNIQUE KEY `RoleName` (`RoleName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`RoleID`, `Sales`, `EditSales`, `CustomerPayment`, `Expence`, `CashClose`, `Customers`, `Users`, `Stoke`, `Reports`, `PresenceManage`, `Tools`, `Config`, `Taxes`, `UsersRole`, `RoleName`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'Admin'),
(5, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'Guest'),
(6, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `FullName` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Mobile` varchar(30) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `RoleId` int(11) NOT NULL,
  `BranchID` int(11) NOT NULL,
  `Password` varchar(150) NOT NULL,
  `PhotoURL` varchar(200) NOT NULL,
  `LastAcivity` datetime NOT NULL,
  `AccountStatus` int(11) NOT NULL,
  `IsOnline` int(1) NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserId`, `FullName`, `UserName`, `Mobile`, `Address`, `RoleId`, `BranchID`, `Password`, `PhotoURL`, `LastAcivity`, `AccountStatus`, `IsOnline`) VALUES
(1, 'Md. Arab Hossain', 'arab_aka', '01827464330', 'Dhaka, Banlgadesh', 1, 1, 'z0bi7sz0by1c', './img/users/arab_aka_Arab__ (8).JPG', '2016-02-03 14:36:07', 1, 0),
(3, 'Arab', 'arab', '687hjjkjjlkl', 'Dhakakjhkhkjh khkjh kjh', 1, 2, 'z0bi7sz0by1c', './img/users/arab_Koala.jpg', '2015-12-25 07:31:35', 0, 0),
(9, 'Arab Hossain', 'test', 'a44343', 'ssfjlfkjl', 5, 1, 'z0b', '/images/nophoto.png', '2016-01-23 10:48:00', 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
