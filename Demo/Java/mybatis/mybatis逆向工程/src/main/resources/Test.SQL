
CREATE DATABASE IF NOT EXISTS `zzzzzf3j7b5n07l5x8g5` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use `zzzzzf3j7b5n07l5x8g5`;

CREATE TABLE IF NOT EXISTS `user`(
`id` int(20) PRIMARY KEY  AUTO_INCREMENT,
`username` VARCHAR(100) ,
`password` VARCHAR(60)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user(username,password) values('HUAWEI','mate20');
insert into user(username,password) values('APPLE','IPHONE_5S');
insert into user(username,password) values('OPPO','R11');
