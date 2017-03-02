# 修改申请表,编号A开头,state（是否看过），type（修改还是注册）
CREATE TABLE `application`(
  `id` VARCHAR(45) NOT NULL ,
  `hotelid` VARCHAR(45) NOT NULL ,
  `hotelname` VARCHAR(255) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `location` VARCHAR(255) NOT NULL ,
  `telephone` VARCHAR(255) NOT NULL ,
  `state` VARCHAR(20) NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`hotelid`) REFERENCES hotel(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 银行账户表,各个宾馆和总公司也各有一个账户，先存到总公司的，然后总经理审批之后到每个宾馆的账户中
# 总公司的账目是存会员卡付的钱的,结算完分掉
CREATE TABLE `bankaccount`(
  `account` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `balance` DOUBLE NOT NULL DEFAULT 0,
  `ownerid` VARCHAR(45) NOT NULL,
  PRIMARY KEY(`account`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 编号以H开头,state表示是否通过审批/修改
CREATE TABLE `hotel`(
  `id` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `location` VARCHAR(255) NOT NULL ,
  `telephone` VARCHAR(255) NOT NULL ,
  `state` VARCHAR(20) NOT NULL ,
  `bankid` VARCHAR(255) NOT NULL ,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`bankid`) REFERENCES bankaccount(`account`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 经理数据库表,编号M开头
CREATE TABLE `manager`(
  `id` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  PRIMARY KEY(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 会员信息,编号以U开头
CREATE TABLE `member`(
  `id` VARCHAR(45) NOT NULL ,
  `nickname` VARCHAR(255) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `phone` VARCHAR(255),
  `sex` VARCHAR(20),
  `birthday` DATE,
  PRIMARY KEY(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 会员卡信息,编号以V开头
CREATE TABLE `membercard`(
  `id` VARCHAR(45) NOT NULL ,
  `memberid` VARCHAR(45) NOT NULL ,
  `balance` DOUBLE NOT NULL ,
  `state` VARCHAR(45) NOT NULL ,
  `statetime` DATE NOT NULL ,
  `level` INT(11) NOT NULL DEFAULT 0,
  `point` INT(11) NOT NULL DEFAULT 0,
  `bankAccount` VARCHAR(255),
  PRIMARY KEY(`id`),
  FOREIGN KEY (`memberid`) REFERENCES member(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 编号O开头,status:预定/入住/退房/取消/已结算
CREATE TABLE `order`(
  `id` VARCHAR(45) NOT NULL ,
  `hotelid` VARCHAR(45) NOT NULL ,
  `type` VARCHAR(45) NOT NULL ,
  `roomid` VARCHAR(45) NOT NULL ,
  `status` VARCHAR(20) NOT NULL ,
  `user1` VARCHAR(45) NOT NULL ,
  `idcard1` VARCHAR(255) NOT NULL ,
  `user2` VARCHAR(45),
  `idcard2` VARCHAR(255),
  `phone` VARCHAR(255) NOT NULL ,
  `createtime` DATETIME NOT NULL ,
  `begintime` DATE NOT NULL ,
  `endtime` DATE NOT NULL ,
  `price` DOUBLE NOT NULL ,
  `paytype` VARCHAR(20) NOT NULL ,
  `membercard` VARCHAR(45),
  PRIMARY KEY(`id`),
  FOREIGN KEY (`hotelid`) REFERENCES hotel(`id`),
  FOREIGN KEY (`roomid`) REFERENCES room(`id`),
  FOREIGN KEY (`type`) REFERENCES roomtype(`id`),
  FOREIGN KEY (`membercard`) REFERENCES membercard(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 编号P开头
CREATE TABLE `plan`(
  `id` VARCHAR(45) NOT NULL ,
  `hotelid` VARCHAR(45) NOT NULL ,
  `begintime` DATE NOT NULL ,
  `endtime` DATE NOT NULL ,
  `roomtype` VARCHAR(45) NOT NULL ,
  `price` DOUBLE NOT NULL ,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`hotelid`) REFERENCES hotel(`id`),
  FOREIGN KEY (`roomtype`) REFERENCES roomtype(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 编号R开头,status为0表示空闲
CREATE TABLE `room`(
  `id` VARCHAR(45) NOT NULL ,
  `type` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `status` INT(11) NOT NULL ,
  `orderstart` DATE,
  `orderend` DATE,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`type`) REFERENCES roomtype(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

# 编号T开头
CREATE TABLE `roomtype`(
  `id` VARCHAR(45) NOT NULL ,
  `hotelid` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `size` DOUBLE NOT NULL ,
  `bednum` INT NOT NULL ,
  `price` DOUBLE NOT NULL ,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`hotelid`) REFERENCES hotel(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;
