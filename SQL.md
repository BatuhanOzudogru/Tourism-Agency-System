-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 09 Kas 2023, 14:57:27
-- Sunucu sürümü: 8.0.31
-- PHP Sürümü: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `tourism_agency`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `accommodation_type`
--

CREATE TABLE `accommodation_type` (
`id` int NOT NULL,
`accommodation_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `accommodation_type`
--

INSERT INTO `accommodation_type` (`id`, `accommodation_name`) VALUES
(1, 'Ultra All Inclusive'),
(2, 'All Inclusive'),
(3, 'Room Breakfast'),
(4, 'Full Pension'),
(5, 'Half Board'),
(6, 'Bed Only'),
(7, 'Full Credit Excluding Alcohol');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `guest`
--

CREATE TABLE `guest` (
`id` int NOT NULL,
`reservation_id` int NOT NULL,
`guest_fullname` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`national_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`guest_phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`guest_email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `guest`
--

INSERT INTO `guest` (`id`, `reservation_id`, `guest_fullname`, `national_id`, `guest_phone`, `guest_email`) VALUES
(7, 3, 'adult1', '123', '111111111', 'adult1@mail.com'),
(8, 3, 'adult2', '234', '2222222222', 'adult2@mail.com'),
(9, 3, 'child1', '345', '', ''),
(10, 4, 'yetişkin1', '11111111111', '11111111111', 'yetiskin1@gmail.com'),
(11, 5, 'turist1', '1111111111', '2222222222', 'turist1@gmail.com');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hotel`
--

CREATE TABLE `hotel` (
`id` int NOT NULL,
`hotel_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`district` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`star` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`hotel_email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`hotel_phone` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`parking` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`wifi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`pool` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`gym` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`concierge` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`spa` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`room_service` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `hotel`
--

INSERT INTO `hotel` (`id`, `hotel_name`, `city`, `district`, `star`, `address`, `hotel_email`, `hotel_phone`, `parking`, `wifi`, `pool`, `gym`, `concierge`, `spa`, `room_service`) VALUES
(1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Merkez Mahallesi Meserburnu Caddesi No: 7 Sarıyer,  34450,  İstanbul,  Türkiye', 'sixsenses@otel.com', '02122022222', 'Yes', 'Yes', 'No', 'Yes', 'Yes', 'Yes', 'Yes'),
(2, 'Four Season at The Bosphorus', 'İstanbul', 'Beşiktaş', '5', 'Ciragan Caddesi 28 Besiktas,  34349,  İstanbul,  Türkiye', 'fourseason@otel.com', '02122022222', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes'),
(3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Kadriye Mah. Üçkum Tepesi Mevkii Beşgöz Cad. No: 72/1,  7525,  Antalya,  Türkiye', 'titanicdeluxe@otel.com', '02422422424', 'No', 'No', 'Yes', 'No', 'Yes', 'No', 'Yes');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hotel_period`
--

CREATE TABLE `hotel_period` (
`id` int NOT NULL,
`season_start` date DEFAULT NULL,
`season_end` date DEFAULT NULL,
`offseason_start` date DEFAULT NULL,
`offseason_end` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `hotel_period`
--

INSERT INTO `hotel_period` (`id`, `season_start`, `season_end`, `offseason_start`, `offseason_end`) VALUES
(1, '2023-06-01', '2023-09-01', '2023-09-02', '2024-05-31'),
(2, '2023-05-31', '2023-10-01', '2023-10-02', '2024-05-31'),
(3, '2023-04-01', '2023-10-01', '2023-10-02', '2024-03-31');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `period_type`
--

CREATE TABLE `period_type` (
`id` int NOT NULL,
`period_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `period_type`
--

INSERT INTO `period_type` (`id`, `period_name`) VALUES
(1, 'Season'),
(2, 'Off Season');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `reservation`
--

CREATE TABLE `reservation` (
`id` int NOT NULL,
`hotel_id` int NOT NULL,
`hotel_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`room_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`period_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`guest_count` int NOT NULL,
`checkin_date` date NOT NULL,
`checkout_date` date NOT NULL,
`duration` int NOT NULL,
`price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `reservation`
--

INSERT INTO `reservation` (`id`, `hotel_id`, `hotel_name`, `room_type`, `period_name`, `city`, `guest_count`, `checkin_date`, `checkout_date`, `duration`, `price`) VALUES
(3, 3, 'Titanic Deluxe Golf Belek', 'King Suite', 'Season', 'Antalya', 3, '2023-04-01', '2023-04-05', 4, 11800),
(4, 2, 'Four Season at The Bosphorus', 'Single', 'Off Season', 'İstanbul', 1, '2023-10-02', '2023-10-05', 3, 300),
(5, 3, 'Titanic Deluxe Golf Belek', 'Single', 'Season', 'Antalya', 1, '2023-04-01', '2023-05-01', 30, 3000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room`
--

CREATE TABLE `room` (
`id` int NOT NULL,
`hotel_id` int NOT NULL,
`room_type_id` int NOT NULL,
`bed` int NOT NULL,
`tv` int NOT NULL,
`minibar` int NOT NULL,
`room_size` int NOT NULL,
`season_stock` int NOT NULL,
`offseason_stock` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room`
--

INSERT INTO `room` (`id`, `hotel_id`, `room_type_id`, `bed`, `tv`, `minibar`, `room_size`, `season_stock`, `offseason_stock`) VALUES
(1, 1, 1, 1, 2, 2, 45, 15, 5),
(2, 1, 2, 2, 3, 3, 75, 20, 10),
(3, 1, 3, 5, 3, 5, 100, 5, 3),
(4, 2, 1, 1, 1, 1, 35, 50, 10),
(5, 2, 2, 2, 2, 1, 54, 35, 7),
(6, 3, 2, 2, 2, 3, 50, 10, 3),
(7, 3, 3, 3, 3, 3, 150, 5, 2),
(8, 3, 1, 3, 99, 1, 50, 15, 5),
(9, 4, 1, 5, 1, 1, 50, 5, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room_price`
--

CREATE TABLE `room_price` (
`id` int NOT NULL,
`hotel_id` int NOT NULL,
`period_id` int NOT NULL,
`room_type` int NOT NULL,
`accommodation_id` int NOT NULL,
`adult_price` int NOT NULL,
`child_price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room_price`
--

INSERT INTO `room_price` (`id`, `hotel_id`, `period_id`, `room_type`, `accommodation_id`, `adult_price`, `child_price`) VALUES
(1, 1, 1, 1, 2, 500, 200),
(2, 1, 1, 1, 3, 250, 100),
(3, 1, 2, 1, 2, 350, 150),
(4, 1, 2, 1, 3, 125, 55),
(5, 1, 1, 3, 1, 2500, 750),
(6, 1, 2, 3, 7, 4500, 750),
(7, 2, 1, 1, 3, 650, 300),
(8, 2, 1, 1, 4, 500, 275),
(9, 3, 1, 3, 1, 1250, 450),
(10, 3, 1, 2, 1, 950, 350),
(12, 3, 2, 3, 1, 1000, 300),
(13, 3, 2, 2, 1, 700, 250),
(15, 1, 1, 3, 2, 999, 99),
(21, 2, 2, 1, 2, 100, 50),
(22, 3, 1, 1, 3, 321, 123),
(23, 3, 1, 1, 6, 100, 75);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room_sales`
--

CREATE TABLE `room_sales` (
`id` int NOT NULL,
`hotel_id` int NOT NULL,
`hotel_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`district` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`star` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`period` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`start_date` date NOT NULL,
`end_date` date NOT NULL,
`room_type` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`stock` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room_sales`
--

INSERT INTO `room_sales` (`id`, `hotel_id`, `hotel_name`, `city`, `district`, `star`, `period`, `start_date`, `end_date`, `room_type`, `stock`) VALUES
(1, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Season', '2023-06-01', '2023-09-01', 'Single', 15),
(2, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Off Season', '2023-09-02', '2024-05-31', 'Single', 5),
(3, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Season', '2023-06-01', '2023-09-01', 'Double', 20),
(4, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Off Season', '2023-09-02', '2024-05-31', 'Double', 10),
(5, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Season', '2023-06-01', '2023-09-01', 'King Suite', 5),
(6, 1, 'Six Senses Kocatas Mansion', 'İstanbul', 'Sariyer', '5', 'Off Season', '2023-09-02', '2024-05-31', 'King Suite', 3),
(7, 2, 'Four Season at The Bosphorus', 'İstanbul', 'Beşiktaş', '5', 'Season', '2023-05-31', '2023-10-01', 'Single', 50),
(8, 2, 'Four Season at The Bosphorus', 'İstanbul', 'Beşiktaş', '5', 'Off Season', '2023-10-02', '2024-05-31', 'Single', 9),
(9, 2, 'Four Season at The Bosphorus', 'İstanbul', 'Beşiktaş', '5', 'Season', '2023-05-31', '2023-10-01', 'Double', 35),
(10, 2, 'Four Season at The Bosphorus', 'İstanbul', 'Beşiktaş', '5', 'Off Season', '2023-10-02', '2024-05-31', 'Double', 7),
(11, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Season', '2023-04-01', '2023-10-01', 'Double', 10),
(12, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Off Season', '2023-10-02', '2024-03-31', 'Double', 3),
(13, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Season', '2023-04-01', '2023-10-01', 'King Suite', 3),
(14, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Off Season', '2023-10-02', '2024-03-31', 'King Suite', 2),
(15, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Season', '2023-04-01', '2023-10-01', 'Single', 14),
(16, 3, 'Titanic Deluxe Golf Belek', 'Antalya', 'Belek', '4', 'Off Season', '2023-10-02', '2024-03-31', 'Single', 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `room_type`
--

CREATE TABLE `room_type` (
`id` int NOT NULL,
`room_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `room_type`
--

INSERT INTO `room_type` (`id`, `room_name`) VALUES
(1, 'Single'),
(2, 'Double'),
(3, 'King Suite');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
`id` int NOT NULL,
`name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
`type` enum('admin','employee') COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `type`) VALUES
(1, 'Batuhan Özüdoğru', 'admin1', '1234', 'admin'),
(2, 'Calisan', 'employee1', '123', 'employee'),
(11, 'test', 'test', '123', 'employee'),
(12, 'qwe', 'qwe', 'qwe', 'employee'),
(13, 'asd', 'asd', 'asd', 'employee'),
(14, 'test1', 'test1', 'test1', 'employee');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `accommodation_type`
--
ALTER TABLE `accommodation_type`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `guest`
--
ALTER TABLE `guest`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `hotel`
--
ALTER TABLE `hotel`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `hotel_period`
--
ALTER TABLE `hotel_period`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `period_type`
--
ALTER TABLE `period_type`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `reservation`
--
ALTER TABLE `reservation`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `room`
--
ALTER TABLE `room`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `room_price`
--
ALTER TABLE `room_price`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `room_sales`
--
ALTER TABLE `room_sales`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `room_type`
--
ALTER TABLE `room_type`
ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `accommodation_type`
--
ALTER TABLE `accommodation_type`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `guest`
--
ALTER TABLE `guest`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `hotel`
--
ALTER TABLE `hotel`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `hotel_period`
--
ALTER TABLE `hotel_period`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `period_type`
--
ALTER TABLE `period_type`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `reservation`
--
ALTER TABLE `reservation`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `room`
--
ALTER TABLE `room`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `room_price`
--
ALTER TABLE `room_price`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Tablo için AUTO_INCREMENT değeri `room_sales`
--
ALTER TABLE `room_sales`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `room_type`
--
ALTER TABLE `room_type`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
