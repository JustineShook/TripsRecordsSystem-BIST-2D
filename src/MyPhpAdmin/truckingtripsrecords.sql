-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2026 at 10:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `truckingtripsrecords`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_driver`
--

CREATE TABLE `tbl_driver` (
  `driver_id` int(20) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `license_number` varchar(50) NOT NULL,
  `contact_number` varchar(12) NOT NULL,
  `driver_image` varchar(50) NOT NULL,
  `driver_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_driver`
--

INSERT INTO `tbl_driver` (`driver_id`, `full_name`, `license_number`, `contact_number`, `driver_image`, `driver_status`) VALUES
(1002, 'Kawi Dora', '09278635733', 'A0-33-253978', '', 'ACTIVE'),
(1018, 'Ashley Palicte', 'A0-55-789456', '09244238091', 'src/driverimage/T.png', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_trip`
--

CREATE TABLE `tbl_trip` (
  `trip_id` int(11) NOT NULL,
  `driver_id` int(11) NOT NULL,
  `truck_id` int(11) NOT NULL,
  `u_id` int(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `weight` varchar(50) NOT NULL,
  `start_location` varchar(50) NOT NULL,
  `end_location` varchar(50) NOT NULL,
  `departure_date` varchar(50) NOT NULL,
  `arrival_date` varchar(50) NOT NULL,
  `distance` varchar(12) NOT NULL,
  `status` varchar(50) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_trip`
--

INSERT INTO `tbl_trip` (`trip_id`, `driver_id`, `truck_id`, `u_id`, `description`, `weight`, `start_location`, `end_location`, `departure_date`, `arrival_date`, `distance`, `status`, `timestamp`) VALUES
(1, 1002, 1001, 80, '', '3,000kg', 'Bulacao, Talisay City, Cebu', 'Inayagan, City of Naga, Cebu', '2025-05-09', '2025-05-09', 'basta layo', 'SUCCESSFUL', '2025-05-30 09:17:05'),
(5, 0, 0, 0, 'adad', 'ad', 'dad', 'adad', 'ada', 'da', 'dada', 'SUCCESSFUL', '2025-05-30 09:17:05'),
(6, 1018, 1002, 80, 'dad', 'adada', 'ada', 'dada', 'dad', 'ada', 'dada', 'SUCCESSFUL', '2025-05-30 09:17:05'),
(7, 1002, 1002, 80, 'sdadas', 'das', 'asd', 'asdasd', 'dasd', 'asdasd', 'asdasd', 'SUCCESSFUL', '2025-05-30 09:17:05'),
(8, 1018, 1002, 80, 'dad', 'adada', 'ada', 'dada', '08-03-2026 14:30', '08-03-2026 14:30', 'dada', 'SUCCESSFUL', '2026-03-09 08:58:08'),
(9, 1018, 1002, 80, 'dad', 'adada', 'ada', 'dada', '08-03-2026 14:30', '08-03-2026 23:30', 'dada', 'SUCCESSFUL', '2026-03-09 08:58:46');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_truck`
--

CREATE TABLE `tbl_truck` (
  `truck_id` int(20) NOT NULL,
  `plate_number` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `capacity` varchar(12) NOT NULL,
  `truck_image` varchar(50) NOT NULL,
  `truck_status` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_truck`
--

INSERT INTO `tbl_truck` (`truck_id`, `plate_number`, `model`, `capacity`, `truck_image`, `truck_status`) VALUES
(1001, 'GDN 9052', 'ELF', '8,000 kg', 'src/truckimage/666.jpg', 'ACTIVE'),
(1002, 'GAM 1780', 'ELF', '4,800 kg', '', 'ACTIVE'),
(1003, 'GAM 8080', 'FORWARD', '10,500 kg', 'src/truckimage/55.jpg', 'ACTIVE'),
(1006, 'GAM 1231', 'L300', '1,000 kg', 'src/truckimage/123123.jpg', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_number` varchar(12) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(150) NOT NULL,
  `u_image` varchar(255) DEFAULT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_type` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_name`, `u_email`, `u_number`, `u_username`, `u_password`, `u_image`, `u_status`, `u_type`) VALUES
(80, 'justinejustine', 'koki@gmail.com', '09224238091', 'justinejustine', 'epqTqT5POCS3vo+azUOJT3ayd25MM7u16xzxukvqrwE=', 'src/userimages/choy ng ako.jpg', 'ACTIVE', 'USER'),
(85, 'adadadsadasd', 'adsddw@gmail.com', '09123456788', 'Marivic143', 'epqTqT5POCS3vo+azUOJT3ayd25MM7u16xzxukvqrwE=', 'src/userimages/shane3.jpg', 'ACTIVE', 'ADMIN'),
(87, 'Shane Plaicte Libios', 'asdasda@gmail.com', '09224238091', 'cheche', 'epqTqT5POCS3vo+azUOJT3ayd25MM7u16xzxukvqrwE=', 'src/userimages/memo.jpg', 'ACTIVE', 'ADMIN'),
(88, 'shok', 'justine@gmail.com', '09224238091', 'shok', 'epqTqT5POCS3vo+azUOJT3ayd25MM7u16xzxukvqrwE=', 'src/userimages/a52bc2a5b800d9a2032f3fabb4d3a02b.jpg', 'ACTIVE', 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `user_action_logs`
--

CREATE TABLE `user_action_logs` (
  `log_id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT current_timestamp(),
  `u_id` int(100) NOT NULL,
  `user_fullname` varchar(100) NOT NULL,
  `action` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_action_logs`
--

INSERT INTO `user_action_logs` (`log_id`, `timestamp`, `u_id`, `user_fullname`, `action`) VALUES
(1, '2025-05-24 16:27:19', 80, 'justinejustine', 'Added a new driver: Cheche Libios'),
(2, '2025-05-24 18:05:11', 80, 'justinejustine', 'Updated driver: Jerry Gwapo'),
(3, '2025-05-24 18:07:34', 80, 'justinejustine', 'Updated driver: Jerry Gwapo'),
(4, '2025-05-25 10:57:01', 80, 'justinejustine', 'Added a new driver: Ashley Palicte'),
(6, '2025-05-25 11:03:00', 80, 'justinejustine', 'Deleted driver: Jerry Gwapo (ID: 1013)'),
(7, '2025-05-25 11:10:59', 80, 'justinejustine', 'Added a new driver: Ako Gaprogram'),
(8, '2025-05-25 11:11:35', 80, 'justinejustine', 'Updated driver: Ako Gaprogram'),
(9, '2025-05-25 11:12:14', 80, 'justinejustine', 'Updated driver: Ashley Palictes'),
(10, '2025-05-25 11:13:55', 80, 'justinejustine', 'Deleted driver: Ako Gaprogram (ID: 1019)'),
(11, '2025-05-25 11:30:43', 80, 'justinejustine', 'Admin Deleted a User Account successfully'),
(12, '2025-05-25 11:31:24', 80, 'justinejustine', 'Admin Deleted a User Account successfully'),
(13, '2025-05-25 11:32:47', 80, 'justinejustine', 'Added a new User: adawdawda'),
(14, '2025-05-25 11:34:28', 80, 'justinejustine', 'Added a new User: adawdasswww'),
(15, '2025-05-25 11:35:22', 80, 'justinejustine', 'Updated User: adawdasswww'),
(16, '2025-05-25 11:35:37', 80, 'justinejustine', 'Admin Deleted a User Account successfully'),
(17, '2025-05-25 11:37:46', 80, 'justinejustine', 'Admin Deleted a User Account successfully'),
(18, '2025-05-25 12:02:51', 80, 'justinejustine', 'Updated Truck: GDN 9056'),
(19, '2025-05-25 12:08:14', 80, 'justinejustine', 'Updated Truck: GDN 9056'),
(20, '2025-05-25 12:11:32', 80, 'justinejustine', 'Updated Truck: GAM 8080'),
(21, '2025-05-25 12:21:14', 80, 'justinejustine', 'Updated Truck: GAM 8080'),
(22, '2025-05-25 12:24:55', 80, 'justinejustine', 'Admin Updated a Truck successfully:: GAM 8080'),
(23, '2025-05-30 17:12:46', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(24, '2026-03-08 21:37:21', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(25, '2026-03-08 21:40:28', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(26, '2026-03-08 21:44:08', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(27, '2026-03-09 06:50:03', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(28, '2026-03-09 06:54:17', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(29, '2026-03-09 06:55:43', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(30, '2026-03-09 06:56:49', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(31, '2026-03-09 07:00:23', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(32, '2026-03-09 07:07:40', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(33, '2026-03-09 07:10:46', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(34, '2026-03-09 07:17:06', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(35, '2026-03-09 07:17:50', 87, 'cheche iro', 'Admin Updated a Truck successfully:: GAM 1780'),
(36, '2026-03-09 07:36:04', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(37, '2026-03-09 07:36:47', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(38, '2026-03-09 07:39:04', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(39, '2026-03-09 07:42:37', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(40, '2026-03-09 07:44:50', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(41, '2026-03-09 07:51:11', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(42, '2026-03-09 07:53:05', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(43, '2026-03-09 07:53:57', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(44, '2026-03-09 07:58:18', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(45, '2026-03-09 08:01:29', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(46, '2026-03-09 08:02:18', 80, 'justinejustine', 'User Log in successfully: justinejustine'),
(47, '2026-03-09 08:06:25', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(48, '2026-03-09 08:07:10', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(49, '2026-03-09 08:08:21', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(50, '2026-03-09 08:09:37', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(51, '2026-03-09 08:21:47', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(52, '2026-03-09 08:27:01', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(53, '2026-03-09 08:29:34', 85, 'adadadsadasd', 'User Log in successfully: adadadsadasd'),
(54, '2026-03-09 08:30:02', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(55, '2026-03-09 09:03:31', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(56, '2026-03-09 09:12:01', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(57, '2026-03-09 09:56:38', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(58, '2026-03-09 09:58:58', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(59, '2026-03-09 10:57:12', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(60, '2026-03-09 11:45:25', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(61, '2026-03-09 11:49:30', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(62, '2026-03-09 11:50:47', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(63, '2026-03-09 12:20:38', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(64, '2026-03-09 12:27:00', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(65, '2026-03-09 12:34:04', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(66, '2026-03-09 12:39:14', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(67, '2026-03-09 12:45:47', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(68, '2026-03-09 12:46:11', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(69, '2026-03-09 12:47:48', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(70, '2026-03-09 13:14:59', 87, 'cheche iro', 'User Log in successfully: cheche iro'),
(71, '2026-03-09 13:16:47', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(72, '2026-03-09 13:21:41', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(73, '2026-03-09 13:26:46', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(74, '2026-03-09 13:30:43', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(75, '2026-03-09 13:31:56', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(76, '2026-03-09 13:37:04', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(77, '2026-03-09 13:59:01', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(78, '2026-03-09 14:04:11', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(79, '2026-03-09 14:11:51', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(80, '2026-03-09 14:12:14', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(81, '2026-03-09 14:42:14', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(82, '2026-03-09 14:43:20', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(83, '2026-03-09 14:50:03', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(84, '2026-03-09 14:50:57', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(85, '2026-03-09 14:55:05', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(86, '2026-03-09 14:56:19', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(87, '2026-03-09 14:57:14', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(88, '2026-03-09 14:58:32', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(89, '2026-03-09 15:00:00', 87, 'Shane Libios', 'User Log in successfully: Shane Libios'),
(90, '2026-03-09 15:00:16', 87, 'Shane Libios', 'Updated User Account: Shane Plaicte Libios'),
(91, '2026-03-09 15:01:11', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(92, '2026-03-09 15:02:02', 87, 'Shane Plaicte Libios', 'Updated User Account: Shane Plaicte Libios'),
(93, '2026-03-09 15:03:13', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(94, '2026-03-09 15:04:01', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(95, '2026-03-09 15:05:38', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(96, '2026-03-09 15:07:14', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(97, '2026-03-09 15:21:50', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(98, '2026-03-09 15:29:47', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(99, '2026-03-09 15:30:58', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(100, '2026-03-09 15:34:57', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(101, '2026-03-09 15:35:24', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(102, '2026-03-09 15:35:57', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(103, '2026-03-09 15:41:28', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(104, '2026-03-09 15:42:00', 87, 'Shane Plaicte Libios', 'Updated User Account: Shane Plaicte Libios'),
(105, '2026-03-09 15:48:56', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(106, '2026-03-09 15:55:34', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(107, '2026-03-09 15:56:05', 87, 'Shane Plaicte Libios', 'Updated User Account: Shane Plaicte Libios'),
(108, '2026-03-09 15:56:17', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(109, '2026-03-09 15:57:39', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(110, '2026-03-09 15:58:11', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(111, '2026-03-09 16:02:18', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(112, '2026-03-09 16:02:53', 87, 'Shane Plaicte Libios', 'Updated User Account: Shane Plaicte Libios'),
(113, '2026-03-09 16:04:17', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(114, '2026-03-09 16:13:44', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(115, '2026-03-09 16:14:32', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(116, '2026-03-09 16:16:14', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(117, '2026-03-09 16:18:09', 87, 'Shane Plaicte Libios', 'Updated User Account: Shane Plaicte Libios'),
(118, '2026-03-09 16:18:41', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(119, '2026-03-09 16:19:30', 87, 'Shane Plaicte Libios', 'Admin Upadted a User Account successfully: shok'),
(120, '2026-03-09 16:20:19', 87, 'Shane Plaicte Libios', 'User Log in successfully: Shane Plaicte Libios'),
(121, '2026-03-09 16:20:40', 87, 'Shane Plaicte Libios', 'Admin Upadted a User Account successfully: shok'),
(122, '2026-03-09 16:20:52', 88, 'shok', 'User Log in successfully: shok'),
(123, '2026-03-09 16:22:56', 88, 'shok', 'User Log in successfully: shok'),
(124, '2026-03-09 16:23:12', 88, 'shok', 'User Log in successfully: shok'),
(125, '2026-03-09 16:23:41', 88, 'shok', 'User Log in successfully: shok'),
(126, '2026-03-09 16:26:55', 88, 'shok', 'User Log in successfully: shok'),
(127, '2026-03-09 16:30:47', 88, 'shok', 'User Log in successfully: shok'),
(128, '2026-03-09 16:35:10', 88, 'shok', 'User Log in successfully: shok'),
(129, '2026-03-09 16:36:12', 88, 'shok', 'User Log in successfully: shok'),
(130, '2026-03-09 16:38:55', 88, 'shok', 'User Log in successfully: shok'),
(131, '2026-03-09 16:40:17', 88, 'shok', 'User Log in successfully: shok'),
(132, '2026-03-09 16:42:33', 88, 'shok', 'User Log in successfully: shok'),
(133, '2026-03-09 16:43:48', 88, 'shok', 'User Log in successfully: shok'),
(134, '2026-03-09 16:44:20', 88, 'shok', 'User Log in successfully: shok'),
(135, '2026-03-09 16:49:16', 88, 'shok', 'User Log in successfully: shok'),
(136, '2026-03-09 16:49:19', 88, 'shok', 'Updated User Account: shok'),
(137, '2026-03-09 16:50:17', 88, 'shok', 'User Log in successfully: shok'),
(138, '2026-03-09 16:52:32', 88, 'shok', 'User Log in successfully: shok'),
(139, '2026-03-09 16:52:39', 88, 'shok', 'Updated User Account: shok'),
(140, '2026-03-09 16:53:20', 88, 'shok', 'User Log in successfully: shok'),
(141, '2026-03-09 16:56:05', 88, 'shok', 'User Log in successfully: shok'),
(142, '2026-03-09 16:58:08', 88, 'shok', 'Admin added a new Trip successfully'),
(143, '2026-03-09 16:58:46', 88, 'shok', 'Admin added a new Trip successfully');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_driver`
--
ALTER TABLE `tbl_driver`
  ADD PRIMARY KEY (`driver_id`);

--
-- Indexes for table `tbl_trip`
--
ALTER TABLE `tbl_trip`
  ADD PRIMARY KEY (`trip_id`),
  ADD KEY `uid` (`u_id`),
  ADD KEY `driverid` (`driver_id`),
  ADD KEY `truckid` (`truck_id`);

--
-- Indexes for table `tbl_truck`
--
ALTER TABLE `tbl_truck`
  ADD PRIMARY KEY (`truck_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `user_action_logs`
--
ALTER TABLE `user_action_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `idx_user_id` (`u_id`),
  ADD KEY `idx_action` (`action`),
  ADD KEY `idx_timestamp` (`timestamp`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_driver`
--
ALTER TABLE `tbl_driver`
  MODIFY `driver_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1020;

--
-- AUTO_INCREMENT for table `tbl_trip`
--
ALTER TABLE `tbl_trip`
  MODIFY `trip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_truck`
--
ALTER TABLE `tbl_truck`
  MODIFY `truck_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT for table `user_action_logs`
--
ALTER TABLE `user_action_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
