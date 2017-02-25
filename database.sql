CREATE TABLE `user`(
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nickname` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `firstname` VARCHAR(45),
  `lastname` VARCHAR(45) ,
  PRIMARY KEY(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE `blog`(
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(100) NOT NULL ,
  `content` VARCHAR(255),
  `user_id` INT(11) NOT NULL ,
  `pub_date` DATE NOT NULL ,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;