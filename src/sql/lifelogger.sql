CREATE TABLE IF NOT EXISTS `meter_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) unsigned NOT NULL,
  `meter_type_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_meter_data_meter_type_key` (`meter_type_id`),
  KEY `FK_meter_data_address_key` (`address_id`),
  CONSTRAINT `FK_meter_data_meter_type_key` FOREIGN KEY (`meter_type_id`) REFERENCES `meter_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_meter_data_address_key` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `meter_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `addresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
