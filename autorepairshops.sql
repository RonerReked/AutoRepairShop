-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2015 at 08:58 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `autorepairshops`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `contactdetails` text COLLATE utf8_unicode_ci NOT NULL,
  `gender` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `address`, `contactdetails`, `gender`, `age`) VALUES
(1, 'Customer 1', 'Address 1', 'Description 1', 'Male', 20),
(2, 'Customer 2', 'Address 2', 'Description 2', 'Female', 22),
(3, 'Customer 3', 'Address 3', 'Description 3', 'Male', 25);

-- --------------------------------------------------------

--
-- Table structure for table `mechanic`
--

CREATE TABLE IF NOT EXISTS `mechanic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` (`id`, `name`) VALUES
(1, 'Mechanic 1'),
(2, 'Mechanic 2'),
(3, 'Mechanic 3');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createdate` date NOT NULL,
  `vehiclesid` int(11) NOT NULL,
  `customersid` int(11) NOT NULL,
  `mechanicid` int(11) NOT NULL,
  `details` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mechanicid` (`mechanicid`),
  KEY `customersid` (`customersid`),
  KEY `vehiclesid` (`vehiclesid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `createdate`, `vehiclesid`, `customersid`, `mechanicid`, `details`) VALUES
(1, '2015-10-10', 1, 1, 1, 'Description');

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE IF NOT EXISTS `vehicles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registrationnumber` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `make` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `modelyear` int(11) NOT NULL,
  `funds` decimal(10,0) NOT NULL,
  `miles` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`id`, `registrationnumber`, `make`, `model`, `modelyear`, `funds`, `miles`) VALUES
(1, 'N01', 'Make 1', 'Model 1', 2015, '1000', 9000),
(2, 'aaa11', 'Make 1', 'Model 1', 2015, '55', 56);

-- --------------------------------------------------------

--
-- Table structure for table `vehicles_customer`
--

CREATE TABLE IF NOT EXISTS `vehicles_customer` (
  `vehiclesid` int(11) NOT NULL,
  `customersid` int(11) NOT NULL,
  PRIMARY KEY (`vehiclesid`,`customersid`),
  KEY `vehiclesid` (`vehiclesid`),
  KEY `customersid` (`customersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vehicles_customer`
--

INSERT INTO `vehicles_customer` (`vehiclesid`, `customersid`) VALUES
(2, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `services_ibfk_1` FOREIGN KEY (`vehiclesid`) REFERENCES `vehicles` (`id`),
  ADD CONSTRAINT `services_ibfk_2` FOREIGN KEY (`customersid`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `services_ibfk_3` FOREIGN KEY (`mechanicid`) REFERENCES `mechanic` (`id`);

--
-- Constraints for table `vehicles_customer`
--
ALTER TABLE `vehicles_customer`
  ADD CONSTRAINT `vehicles_customer_ibfk_1` FOREIGN KEY (`vehiclesid`) REFERENCES `vehicles` (`id`),
  ADD CONSTRAINT `vehicles_customer_ibfk_2` FOREIGN KEY (`customersid`) REFERENCES `customers` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
