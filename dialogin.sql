-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 11, 2020 lúc 02:54 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dialogin`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `thongtin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `item`
--

INSERT INTO `item` (`id`, `gia`, `time`, `thongtin`) VALUES
(1, 109900, 285, 'Rửa xe ngoài\r\nRửa gầm\r\nHút bụi & lau dọn nội thất\r\nPhủ dầu bảo vệ gầm\r\nVệ sinh nội thất xe chi tiết\r\nKhử mùi, diệt khuẩn bằng công nghệ Ozone\r\nTẩy keo & nhựa đường\r\nLoại bỏ bụi sắt, kim loại trên thân vỏ xe'),
(2, 99000, 195, 'Rửa xe ngoài\r\nRửa gầm\r\nHút bụi & lau dọn nội thất\r\nPhủ dầu bảo vệ gầm\r\nVệ sinh khoang động cơ\r\nKhử mùi, diệt khuẩn bằng công nghệ Ozone\r\nTẩy keo & nhựa đường\r\nLoại bỏ bụi sắt, kim loại trên thân vỏ xe'),
(3, 159000, 320, 'Rửa xe ngoài\r\nRửa gầm\r\nHút bụi & lau dọn nội thất\r\nPhủ dầu bảo vệ gầm\r\nVệ sinh nội thất xe chi tiết\r\nVệ sinh khoang động cơ\r\nKhử mùi, diệt khuẩn bằng công nghệ Ozone\r\nTẩy keo & nhựa đường\r\nLoại bỏ bụi sắt, kim loại trên thân vỏ xe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `idkh` int(11) NOT NULL,
  `tenkh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachikh` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdtkh` int(11) NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ghichu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `makhuyenmai` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`idkh`, `tenkh`, `diachikh`, `sdtkh`, `email`, `ghichu`, `makhuyenmai`) VALUES
(1, 'hoanganhtu', 'thainguyen', 89678967, 'tuhoang636@gmail.com', 'dat hang ngay 20 thang 4', 'mk'),
(3, 'tu hoang', 'Thai nguyen', 4124142, 'tu@123gmail.com', 'eqwe', 'xx'),
(4, 'tu', 'hn', 12131, 'tu@tu', 'tretr', 'xxx');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123'),
(2, 'tuhoang1', '123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`idkh`);

--
-- Chỉ mục cho bảng `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `idkh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
