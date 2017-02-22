
CREATE DATABASE IF NOT EXISTS `blog-aw` CHARACTER SET utf8 COLLATE utf8_general_ci;

GRANT ALL ON `blog-aw`.* TO 'aw'@'localhost';

FLUSH PRIVILEGES;

USE blog-aw;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `full_name` varchar(100) NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `blog_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_post` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `text` TEXT NULL,
  `user_id` bigint(20) NOT NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_blog_post` (`user_id`),
  CONSTRAINT `fk_user_blog_post` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


INSERT INTO `user` (username, password)
VALUES 
('fabio', 'fabio123'),
('luan', 'luan123'),
('luiz', 'luiz123'),
('patrick', 'patrick123'),
('natan', 'natan123'),
('vinicius', 'vinicius123')
;

COMMIT;

