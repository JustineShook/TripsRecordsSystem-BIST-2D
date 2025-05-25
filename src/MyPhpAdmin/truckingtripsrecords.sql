-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2025 at 05:14 PM
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
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_trip`
--

INSERT INTO `tbl_trip` (`trip_id`, `driver_id`, `truck_id`, `u_id`, `description`, `weight`, `start_location`, `end_location`, `departure_date`, `arrival_date`, `distance`, `status`) VALUES
(1, 1002, 1001, 80, '', '3,000kg', 'Bulacao, Talisay City, Cebu', 'Inayagan, City of Naga, Cebu', '2025-05-09', '2025-05-09', 'basta layo', 'SUCCESSFUL'),
(5, 0, 0, 0, 'adad', 'ad', 'dad', 'adad', 'ada', 'da', 'dada', 'SUCCESSFUL'),
(6, 1018, 1002, 80, 'dad', 'adada', 'ada', 'dada', 'dad', 'ada', 'dada', 'SUCCESSFUL'),
(7, 1002, 1002, 80, 'sdadas', 'das', 'asd', 'asdasd', 'dasd', 'asdasd', 'asdasd', 'SUCCESSFUL');

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
(1002, 'GAM 1780', 'ELF', '4,800 kg', 'src/truckimage/15.jpg', 'ACTIVE'),
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
  `u_image` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_type` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_name`, `u_email`, `u_number`, `u_username`, `u_password`, `u_image`, `u_status`, `u_type`) VALUES
(80, 'justinejustine', 'koki@gmail.com', '09224238091', 'justinejustine', 'pNSNQQq90JxbIpFW1mMBNilFrNsyCQ7idAwluuW7ZoU=', 'src/userimages/choy ng ako.jpg', 'ACTIVE', 'ADMIN'),
(85, 'adadadsadasd', 'adsddw@gmail.com', '09123456788', 'Marivic143', 'b4CmB7P0YQi3xU7UbAgq70mTyZpuPzk/aECMGbVqUxs=', 'src/userimages/shane3.jpg', 'ACTIVE', 'ADMIN');

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
(22, '2025-05-25 12:24:55', 80, 'justinejustine', 'Admin Updated a Truck successfully:: GAM 8080');

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
  MODIFY `trip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_truck`
--
ALTER TABLE `tbl_truck`
  MODIFY `truck_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT for table `user_action_logs`
--
ALTER TABLE `user_action_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_trip`
--
ALTER TABLE `tbl_trip`
  ADD CONSTRAINT `driverid` FOREIGN KEY (`driver_id`) REFERENCES `tbl_driver` (`driver_id`),
  ADD CONSTRAINT `truckid` FOREIGN KEY (`truck_id`) REFERENCES `tbl_truck` (`truck_id`),
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `user_action_logs`
--
ALTER TABLE `user_action_logs`
  ADD CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
