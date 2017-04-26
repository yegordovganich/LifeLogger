-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Апр 26 2017 г., 15:40
-- Версия сервера: 5.6.15-log
-- Версия PHP: 5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `lifelogger`
--

-- --------------------------------------------------------

--
-- Структура таблицы `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address` (`address`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `address`
--

INSERT INTO `address` (`id`, `address`) VALUES
(1, 'Kyiv, Khreschatyk');

-- --------------------------------------------------------

--
-- Структура таблицы `meter_data`
--

CREATE TABLE IF NOT EXISTS `meter_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) unsigned NOT NULL,
  `meter_type` enum('ELECTRICAL_ENERGY','HOT_WATER','COLD_WATER') NOT NULL,
  `address_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FK_meter_data_address_key` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `meter_data`
--
ALTER TABLE `meter_data`
  ADD CONSTRAINT `FK_meter_data_address_key` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
