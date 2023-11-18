-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 18, 2023 lúc 01:19 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `job_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `candidate`
--

CREATE TABLE `candidate` (
  `candidateID` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL DEFAULT '0',
  `email` varchar(100) NOT NULL DEFAULT '0',
  `phone_number` varchar(15) NOT NULL DEFAULT '0',
  `address` varchar(255) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `candidate`
--

INSERT INTO `candidate` (`candidateID`, `full_name`, `email`, `phone_number`, `address`) VALUES
(1, 'Pham Thanh Leon', 'leonpham28052002@gmail.com', '0559492805', '566 nguyễn thái sơn'),
(2, 'Pham Thanh Leon', 'leonpham28052002@gmail.com', '0559492805', '566 nguyễn thái sơn'),
(3, 'Pham Thanh Leon', 'leonpham28052002@gmail.com', '0559492805', '566 nguyễn thái sơn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `candidateskill`
--

CREATE TABLE `candidateskill` (
  `candidateID` int(11) NOT NULL,
  `skillID` int(11) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `candidateskill`
--

INSERT INTO `candidateskill` (`candidateID`, `skillID`, `level`) VALUES
(2, 2, 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `job`
--

CREATE TABLE `job` (
  `jobID` int(11) NOT NULL,
  `title` varchar(100) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  `location` varchar(255) NOT NULL DEFAULT '',
  `salary` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `job`
--

INSERT INTO `job` (`jobID`, `title`, `description`, `location`, `salary`) VALUES
(1, 'Lap trinh java', 'biet ve java core, java swing', '12 nguyen van bao', 20000000),
(2, 'Lap trinh java', 'biet ve java core, java swing', '12 nguyen van bao', 20000000),
(3, 'Lap trinh java', 'biet ve java core, java swing', '12 nguyen van bao', 40000000),
(4, 'Lap trinh java', 'biet ve java core, java swing', '12 nguyen van bao', 20000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `skill`
--

CREATE TABLE `skill` (
  `skillID` int(11) NOT NULL,
  `skill_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `skill`
--

INSERT INTO `skill` (`skillID`, `skill_name`) VALUES
(2, 'lap trinh java'),
(3, 'lap trinh java core');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `candidate`
--
ALTER TABLE `candidate`
  ADD PRIMARY KEY (`candidateID`);

--
-- Chỉ mục cho bảng `candidateskill`
--
ALTER TABLE `candidateskill`
  ADD PRIMARY KEY (`candidateID`,`skillID`),
  ADD KEY `candidateID_skillID` (`candidateID`,`skillID`),
  ADD KEY `FK_candidateskill_skill` (`skillID`);

--
-- Chỉ mục cho bảng `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`jobID`);

--
-- Chỉ mục cho bảng `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`skillID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `candidate`
--
ALTER TABLE `candidate`
  MODIFY `candidateID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `job`
--
ALTER TABLE `job`
  MODIFY `jobID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `skill`
--
ALTER TABLE `skill`
  MODIFY `skillID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `candidateskill`
--
ALTER TABLE `candidateskill`
  ADD CONSTRAINT `FK_candidateskill_candidate` FOREIGN KEY (`candidateID`) REFERENCES `candidate` (`candidateID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_candidateskill_skill` FOREIGN KEY (`skillID`) REFERENCES `skill` (`skillID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
