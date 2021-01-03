-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2021 at 02:01 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tenantportal`
--

-- --------------------------------------------------------

--
-- Table structure for table `flat`
--

CREATE TABLE `flat` (
  `flatId` int(6) NOT NULL,
  `roadId` int(6) NOT NULL,
  `houseNo` int(3) NOT NULL,
  `flatNo` int(3) NOT NULL,
  `floorNo` int(2) NOT NULL,
  `size` int(5) NOT NULL,
  `noBedRoom` int(2) NOT NULL,
  `noBathRoom` int(2) NOT NULL,
  `price` int(10) NOT NULL,
  `flatPic` varchar(50) NOT NULL,
  `facing` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `ownerId` int(6) NOT NULL,
  `nid` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ownerpost`
--

CREATE TABLE `ownerpost` (
  `postId` int(6) NOT NULL,
  `ownerId` int(6) NOT NULL,
  `flatId` int(6) NOT NULL,
  `postText` varchar(500) NOT NULL,
  `postDate` date NOT NULL,
  `postTime` time NOT NULL,
  `lat` float NOT NULL,
  `lang` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `renter`
--

CREATE TABLE `renter` (
  `renterId` int(6) NOT NULL,
  `userId` varchar(17) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `road`
--

CREATE TABLE `road` (
  `roadId` int(6) NOT NULL,
  `roadNo` int(3) NOT NULL,
  `blockNo` varchar(3) NOT NULL,
  `areaName` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nid` varchar(17) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contactNo` varchar(11) NOT NULL,
  `address` varchar(80) NOT NULL,
  `activeStatus` int(1) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flat`
--
ALTER TABLE `flat`
  ADD PRIMARY KEY (`flatId`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`ownerId`);

--
-- Indexes for table `ownerpost`
--
ALTER TABLE `ownerpost`
  ADD PRIMARY KEY (`postId`);

--
-- Indexes for table `renter`
--
ALTER TABLE `renter`
  ADD PRIMARY KEY (`renterId`);

--
-- Indexes for table `road`
--
ALTER TABLE `road`
  ADD PRIMARY KEY (`roadId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `flat`
--
ALTER TABLE `flat`
  MODIFY `flatId` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `ownerId` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ownerpost`
--
ALTER TABLE `ownerpost`
  MODIFY `postId` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `renter`
--
ALTER TABLE `renter`
  MODIFY `renterId` int(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `road`
--
ALTER TABLE `road`
  MODIFY `roadId` int(6) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
