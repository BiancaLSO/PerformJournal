CREATE TABLE IF NOT EXISTS `userrole` (
  `userId` binary(16) NOT NULL,
  `role` varchar(191) DEFAULT NULL,
  UNIQUE KEY `UKndlch38jlcemak65j3re6m3pd` (`userId`,`role`),
  CONSTRAINT `FK40w0q0m1w9k9wjv1bfou711fd` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;