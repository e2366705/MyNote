

# 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力


### 展示所有的数据库
show databases;

### 选择出是 null 的项目 3 条:
```  
SELECT * FROM `user` where `name` is null LIMIT 0,3;

```


### use 某个数据库(aaa)
use aaa;

### 展示表中所有数据
select * from user;

###　insert 插入数据(两种方式)
insert into user(username,password) values('HUAWEI','mate20');
INSERT into users VALUES ('AAA','BBB','CCC');

### 查看当前库所有表:
show tables;

### 查看指定数据库的表:
show tables from 数据库名

### 查看表的数据结构:
desc 表名

### 查看服务器的版本:
select version();





# 意思解读:
``` 
CREATE TABLE IF NOT EXISTS `table1`(      -- (注释:)
   `tableID` INT UNSIGNED AUTO_INCREMENT, -- (int类型,无符号,自增)
   `username` VARCHAR(100) NOT NULL,      -- (varchar不解释 带not null,不能为空值)
   PRIMARY KEY ( `tableID` )			        -- (PRIMARY KEY关键字用于定义列为主键)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;      -- (ENGINE 设置存储引擎，CHARSET 设置编码)

这里有两个小小的坑:
	1 CREATE TABLE IF NOT EXISTS `table1` 后面接的是() 不是{},注意了!!!
	2 是utf8  不是utf-8
```


# 新建一个数据库并且包含数据 ( 完整的流程:)
```

-- 删除数据库
drop database IF EXISTS `MySQL_Test_1`;

-- 创建 数据库:
CREATE DATABASE IF NOT EXISTS `MySQL_Test_1` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- 切换回
use `MySQL_Test_1`;

-- 创建表
CREATE TABLE IF NOT EXISTS `user`(
`id` int(20) unsigned not null DEFAULT 0,
`money` DECIMAL(20,2) NOT NULL DEFAULT '0.00',
`username` VARCHAR(100) not null DEFAULT '', 
`password` VARCHAR(40)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 无符号		unsigned
-- 有符号		signed

-- 插入insert数据:
insert into `user`(username,password) values('HUAWEI','mate20');
insert into `user`(username,password) values('APPLE','IPHONE_5S');
insert into `user`(username,password) values('OPPO','R11');

```



# 增
```  
多种排序测试用
insert into `user`(username,password) VALUES('aaa','999');
insert into `user`(username,password) VALUES('bbb','555');
insert into `user`(username,password) VALUES('ccc','333');   

增加 : 
	给字段添加默认值 : 
	ALTER TABLE `数据表` ALTER COLUMN `字段` SET DEFAULT '默认值';

增加 : 
	字段主键约束 : 
	ALTER TABLE `user3` add PRIMARY KEY(id);
(注意:执行这句代码时候,会报错,原因是原来的字段都是null值,所以设置不成功,添加不一样的数据,再执行这句代码即可)

增加 : 
	字段唯一约束:
	ALTER TABLE `user3` add unique(username);
约束该字段的值不可以重复(insert时候,组合在一起不重复就ok)
	
增加一个字段 : 	
	ALTER TABLE `user` ADD `address` VARCHAR(66);

```

# 删
```  
DROP TABLE IF EXISTS `jd_demo_login`;

删除表中某项数据
delete from user where password = '123123123';

清空表中全部数据，不写日志，不可恢复，速度极快
truncate table 表名;
 
清空全部数据，写日志，数据可恢复，速度慢
delete from 表名

删除数据库:
drop database `数据库名`;

删除数据表;
drop TABLE student;

#删除倒数第几行数据                                            
delete from text001 order by id desc limit 66

删除 表的字段:
alter table 表名 drop column 字段名

删除 MySQL 主键 约束
ALTER TABLE user3 DROP PRIMARY KEY;   

删除 : 
unique key (删除某个字段的唯一性约束)
	ALTER TABLE 表名 DROP INDEX 字段名(比如:userID);

```


# 改
```
UPDATE 更新表中某项数据
UPDATE runoob_tbl SET runoob_title='学习 C++' WHERE runoob_id=3;

修改 : 
	字段类型
	alter table 表名 modify column 字段名 类型;
注意: 如果修改字段数据失败,可能是MySQL为了数据安全,加了保险
(比如text类型的字段转化为int类型->大数据类型转小数据类型,这样子就可能会丢失数据)


修改字段名称和属性 ( 将AAA字段改为BBBB ) :
	ALTER TABLE 表名    CHANGE 原字段名    新字段名    字段类型     约束条件 ; 
	ALTER TABLE user10  CHANGE `AAA`      `BBBB`     CHAR(32)   NOT NULL DEFAULT '123';

```


# 查
```  
模糊查询:
	select * from 
		`goods`
	where 
		`describe` LIKE '%王力宏%'
	and 
		`price` BETWEEN 0 and 2000 
	ORDER BY sales DESC; 
		
多表查询:
	select sname,cno,degree from student,score where student.sno = score.sno;
		 
	select 
		sname,cname,degree from student,course,score 
	where
		student.sno = score.sno 
	and
		course.cno = score.cno;

group by : 排除重复的,筛选出不同的
	SELECT PASSWORD FROM user3 GROUP BY `PASSWORD`;

排除重复的:
	select distinct username from user;

查询字段`word`长度等于 5 的:
	select * from `words_warehouse`  where length(`word`) = 5;		

select * from score where username in ('aaa','bbb','ccc');  查询符合条件(aaa或者bbb或者ccc)的项目
select * from student where class='12306' or sex='女';    MySQL或者查询
select * from student order by class desc;   MySQL降序查询
select * from score order by cno asc , password desc   cno升序 , password降序
select count(*) from student where class='2333';       统计符合条件的数量
MySQL查询最高分----> 语句太长,懒得写了,用时再百度吧...		

```


# MySQL 约束
``` 
主键:
	CREATE TABLE users2(
	id int,
	PASSWORD VARCHAR(66),
	PRIMARY KEY(id,PASSWORD)
	);
	联合主键:多个主键,加起来不一样也是可以的


自增 auto_increment:
	CREATE TABLE user3(
	id int PRIMARY KEY auto_increment,
	PASSWORD VARCHAR(66)
	);

INSERT INTO 数据表(`字段`) VALUES('你要插入的值');
注意:字段一定要用反引号 `` 包括起来 , 因为有时候你的自定义字段名会和MySQL关键字冲突, 用``包起来就没事了

非空约束: 就是 not null (没啥好说的.....)
默认约束: default 2333 就是当我们插入字段值的时候,如果没有传值,就会使用默认值

PRIMARY KEY不可空不可重复，在一个表里可以定义联合主键；简单的说, primary key = unique + not null
null 和 '' 是不一样的
null 不等于 ''

给数据库添加注释   comment    :
CREATE TABLE IF NOT EXISTS `test`(
	 `id` INT(25) primary key comment '字段的注释',
	  `name` VARCHAR(20) not NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

外键约束:涉及两个表(主表+副表)
*1 主表(父表) class 中没有的数据值,在附表(子表)中,是不可以使用的
*2 主表中的记录被父表引用,是不可以被删除的
CREATE TABLE class(
id INT ,
name VARCHAR(66)
);

CREATE TABLE student(
id int,
name VARCHAR(66),
class_id int,
FOREIGN KEY(class_id) REFERENCES class(id)  ==> student表中class_id的值,必须来自class表中的id
);

						词汇:
						foreign key 外键
						references 参考
这句代码翻译过来就是:
FOREIGN KEY(class_id) REFERENCES class(id) 
外键 class_id(本表) 的值,参考class表中的id的值

```


# MySQL 高级:
```  
mysql 去掉重复的:
SELECT DISTINCT username FROM same;

mysql CONCAT 表示链接字符串
SELECT CONCAT("aaa",100,"---") as result ; => 输出: aaa100---

模糊匹配 模糊查询: (包含66的数据, )
%是占位符 任意多个字符,包含0个字符
_ 任意单个字符
\ 是转义符   \_ => _
SELECT  * FROM same WHERE username LIKE '__e_a'; => 第三个字符为e,最后一个是a
SELECT  * FROM same WHERE username LIKE '%66%';
选择满足其中一项:
select * from same where username in ('a' , 'b' , 'c');
筛选出值为null的一项(id=null这种写法是错误的,同理:is NOT NULL 不为空)

select * from same where username id is null ;

安全等于 : <=> 既可以用于判断 null 也可以用于<=>1200(数字)

NOT BETWEEN 100 AND 200 不在100到200之间

IFNULL(CONNECTION,0) 如果是NULL值,改为0

求和:
SELECT SUM(`username`) FROM same;

```



# MySQL 杂谈:
```  
MYSQL5.x是不允许BLOB/TEXT类型的字段拥有默认值的

-- public是数据库
-- admin是数据表
create table public.admin(
  id varchar(60) not null unique,    -- 用户id
  username varchar(40) not null unique, -- 用户名
  state boolean      -- 表示用户的状态，在未进行邮箱验证之前状态为false
);

在 MySQL 中只有使用了 Innodb 数据库引擎的数据库或表才支持事务

数据库的三大设计范式:
https://www.bilibili.com/video/av39807944/?p=16   ==> 这个教程非常不错 (建表详细化)
https://www.bilibili.com/video/av39807944/?p=17   ==> 拆表 (第二范式)

	
mysql排序:
	ASC		 数值从低到高
	DESC	 数值从高到低
	
```


# 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力
<details>
<summary><b>MySQL 遇到的问题: </b></summary>

```  
提示: Can't connect to MySQL server on 'localhost' (10061)

第一步: Windows下面, 开打任务管理器 , 找到服务, 把MySQL服务启动

这时候可能会提示: 
		Windows 无法启动 mysql_YXB 服务(位于 本地计算机 上)
		错误 2: 系统找不到指定的文件

这时候就要动注册表了, windows+r  在运行对话框输入regedit，点击确定，进入注册表编辑器
选择HKEY_LOCAL_MACHINE ->SYSTEM -> CurrentControlSet -> services ->MySQL，
(或者直接搜: 
计算机\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\mysql....
)

修改ImagePath的路径为Mysql安装路径，例如：D:\mysql-5.7.19-winx64\bin\mysqld MySQL

怎么获取我的 MySQL 安装路径呢? 

一般来讲 , 都是默认安装在:  C:\ProgramData\MySQL

所以,

找到Mysql安装的目录，在Mysql安装的目录中找到bin目录，把此路径复制

添加在Windows里面的用户变量的path变量中添加变量值，变量值为刚复制的路径
(win10 搜索 : 高级环境设置 )

算了...   我选择了重装 MySQL (直接解压缩安装 ), 然后再去添加环境变量, 效果一样的

我把MySQL_8.zip解压缩在:  D:\APPS_________APPS_________\ZIP___ISO___7Z___\MySQL_8


把这个:
D:\APPS_________APPS_________\ZIP___ISO___7Z___\MySQL_8\mysql-8.0.16-winx64\bin
添加在Windows中环境变量 (win10 搜索 : 高级环境设置 )


打开 Windows 的 cmd , 
输入:
mysql -uroot -p


怎样删除windows服务项?
打开cmd -> sc delete "服务名" (比如: sc delete "MySQL")


emmmmmmmmm......


到最后问题解决了吗??

哈哈哈哈...

答案是并没有

搞了半天

还是没有搞好

反而发现了一个更加简单省心的方法

那就是 phpStudy 

搞 php 的都知道

是一个集成开发环境

集合了 php MySQL tomcat服务器

直接用 phpStudy 里面的 MySQL 不就好了???

下个MySQL客户端各种配置+设置, 简直就是反人类...



```
</details>






