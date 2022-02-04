CREATE TABLE IF NOT EXISTS `user` (
  `id` binary(16) NOT NULL,
  `createdAt` bigint(20) DEFAULT NULL,
  `modifiedAt` bigint(20) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `username` varchar(191) DEFAULT NULL,
  `password` varchar(191) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;




