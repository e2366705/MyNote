
Thymeleaf

INSERT into `words_warehouse`(`word`) VALUES('aaa');

select count(*) from `words_warehouse`;

SELECT * FROM `words_warehouse` where `chinese_meaning` is null LIMIT 5 ;

UPDATE `words_warehouse` SET `chinese_meaning`='字母A' WHERE `word`='A';

SELECT `chinese_meaning` FROM `words_warehouse` where `word` = 'A';

select * from `words_warehouse` where length(`word`) = 5;

select count(*) from `words_warehouse` where length(`word`) = 5;

select * from `words_warehouse` where length(`word`) = 12 limit 0,3;


english_word
words_warehouse
word
chinese_meaning

be_familiar_with
not_familiar_with
very_familiar_with


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


