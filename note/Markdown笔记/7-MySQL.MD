

# 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力
# 安装 phpStudy 之后 , 这时候是不能用 cmd 命令行直接操作 MySQL 数据库的, 需要这么配置

---

# SQL 规范 (必读!!!)
<details>
<summary><b>规范</b></summary>

```  

不要把字段的值默认设置为 null, 有 bug , 切记切记~~

```
</details>








---

<details>
<summary><b>配置 phpStudy 里面的 MySQL 到系统变量</b></summary>

```  
1 打开 phpStudy
2 点击 其他选项菜单
3 点击 打开文件位置
4 点击 MySQL 

这时候打开了 phpStudy 里面内置的 MySQL 的安装位置,
复制这个路径,

这时候需要把环境变量配置到 Windows10 的系统变量中去,
不然系统无法通过 cmd 直接找到 MySQL

在 Windows10 中按下 win 键, 搜索 '高级系统设置'
点击 '环境变量'
找到系统变量
找到 Path
新建一个,
把刚刚复制的 phpStudy- MySQL 的安装路径粘贴进去
点击确定退出

这样子就可以直接用 cmd 直接操作 phpStudy 里面的 MySQL 了

```
</details>



# 批处理自动备份脚本(.bat for Windows10):
### 注意!! 一定要用 Windows 自带的文本编辑器打开, 用别的编辑器打开会乱码(比如 VS Code)
<details>
<summary><b>BackUP_MySQL.bat</b></summary>

```  
rem =====   MySQL backup start   =====
@echo off
forfiles /p "D:\MySQL_BackUp" /m backup_*.sql -d -30 /c "cmd /c del /f @path"
set "time=%date:~0,4%-%date:~5,2%-%date:~8,2%-%time:~1,1%%time:~3,2%%time:~6,2%"
"C:\phpStudy\PHPTutorial\MySQL\bin\mysqldump" --opt --single-transaction=TRUE --user=root --password=root --host=127.0.0.1 --protocol=tcp --port=3306 --default-character-set=utf8 --single-transaction=TRUE --routines --events "study_english_database" > "D:\坚果云文件\我的坚果云\MySQL_BackUp\study_english_database_%time%.sql"
@echo on
rem =====   MySQL backup end   =====
rem %time%
rem auther:YXB
rem 教程来源 : https://blog.csdn.net/freezingxu/article/details/78884962
rem ================ 分割线 =====================
rem Test : 中文(Chinese)会乱码吗???
rem 因为 Windows下默认的bat的编码格式是UTF-8，这时只需将其转换成ANSI 格式即可
rem 右击bat文件 -> 编辑 -> 另存为 -> ANSI格式 -> 保存即可
rem 注意!! 一定要用 Windows 自带的文本编辑器打开, 用别的编辑器打开会乱码(比如 VS Code)
pause

```
</details>



# 基础:
<details>
<summary><b>基础-001</b></summary>

```  

查看所有的数据库 
show databases;

查看当前库所有表:
show tables;

查看指定数据库的表:
show tables from 数据库名

查看表的数据结构:
desc 表名

查看服务器的版本:
select version();

切换到某个数据库(aaa)
use `aaa`;

选择出是 null 的项目 3 条:
SELECT * FROM `user` where `name` is null LIMIT 0,3;

展示表中所有数据
select * from `user`;

insert 插入数据(两种方式)
insert into `user`(username,password) values('HUAWEI','mate20');
INSERT into `users` VALUES ('AAA','BBB','CCC');


基本解释:
CREATE TABLE IF NOT EXISTS `table1`(      -- (注释:)
   `tableID` INT UNSIGNED AUTO_INCREMENT, -- (int类型,无符号,自增)
   `username` VARCHAR(100) NOT NULL,      -- (varchar不解释 带not null,不能为空值)
   PRIMARY KEY ( `tableID` )			        -- (PRIMARY KEY关键字用于定义列为主键)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;      -- (ENGINE 设置存储引擎，CHARSET 设置编码)

这里有两个小小的坑:
	1 CREATE TABLE IF NOT EXISTS `table1` 后面接的是() 不是{},注意了!!!
	2 是utf8  不是utf-8


注意: 
	SELECT * FROM `phrase` WHERE `id` != 2
		这个时候是匹配不到 id 为 null 的数据的, 
		因为 NULL 不是一个「值」，而是「没有值」,
		「没有值」不满足「值不等于1」这个条件
		所以 mysql 尽量不要默认值是 NULL
	如何解决?
		select * from `phrase` where `id` != 2 or `id` is null


```
</details>





<details>
<summary><b>新建一个数据库并且包含数据 (完整的流程:)</b></summary>

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
</details>





<details>
<summary><b>1 增:</b></summary>

```  
多种排序测试用
insert into `user`(  `username` , `password`  ) VALUES('aaa','999'); 

```
</details>





<details>
<summary><b>2 删:</b></summary>

```  
DROP TABLE IF EXISTS `jd_demo_login`;

删除表中某项数据
delete from `user` where `password` = '123123123';

清空表中全部数据，不写日志，不可恢复，速度极快
truncate table `表名`;
 
清空全部数据，写日志，数据可恢复，速度慢
delete from `表名`

删除数据库:
drop database `数据库名`;

删除数据表;
drop TABLE `student`;

#删除倒数第几行数据                                            
delete from `text001` order by `id` desc limit 66

```
</details>





<details>
<summary><b>3 改</b></summary>

```  
UPDATE 更新表中某项数据
UPDATE `runoob_tbl` SET `runoob_title` = '学习 C++' WHERE `runoob_id` = 3;

更新多个字段
UPDATE `phrase` SET `phrase`="AAA" , `chinese_meaning`="BBB" WHERE `word`='CCC';

设置为 null
UPDATE `phrase` SET `chinese_meaning` = null WHERE `state` = 'Very_familiar'

```
</details>





<details>
<summary><b>4 查</b></summary>

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

当 xxx 不为空 , 且 yyy 为空时:
select `word` from `phrase` where `state` IS NULL and `word` is not null

select * from score where username in ('aaa','bbb','ccc');  查询符合条件(aaa或者bbb或者ccc)的项目
select * from student where class='12306' or sex='女';    MySQL或者查询
select * from student order by class desc;   MySQL降序查询
select * from score order by cno asc , password desc   cno升序 , password降序
select count(*) from student where class='2333';       统计符合条件的数量
MySQL查询最高分----> 语句太长,懒得写了,用时再百度吧...		

```
</details>









<details>
<summary><b>5 alter</b></summary>

```  

删除主键
alter table `student` drop primary key;

删除表的字段:
alter table `表名` drop column `字段名`

删除主键
ALTER TABLE `user` DROP PRIMARY KEY

想删除表中某个字段的unique key:
ALTER TABLE `good_booked` DROP INDEX `good_id`;


设置为主键:
alter table `student` add primary key(`id`)
(注意:执行这句代码时候,会报错,原因是原来的字段都是null值,所以设置不成功,
设置为唯一键 效果是一样的)

设置为唯一键
alter TABLE `test2` add UNIQUE (`userid`)

给字段添加默认值 : 
ALTER TABLE `数据表` ALTER COLUMN `字段` SET DEFAULT '默认值';







增加一个唯一字段
alter table `phrase` add `word` VARCHAR(66) UNIQUE

增加一个主键字段
alter table `student` add `word` VARCHAR(66) PRIMARY KEY


增加一个非空字段
alter table `table1` add transactor varchar(10) not Null;

增加一个自增 + 主键字段
alter table `table1` add id int unsigned not Null auto_increment primary key


修改字段名称和属性 ( 将AAA字段改为BBBB ) :
ALTER TABLE 表名    CHANGE 原字段名    新字段名    字段类型     约束条件 ; 
ALTER TABLE user10  CHANGE `AAA`      `BBBB`     CHAR(32)   NOT NULL DEFAULT '123';


修改字段类型
alter table 表名 modify column 字段名 类型;
注意: 如果修改字段数据失败,可能是MySQL为了数据安全,加了保险
(比如text类型的字段转化为int类型->大数据类型转小数据类型,这样子就可能会丢失数据)

```
</details>










<details>
<summary><b> MySQL 约束</b></summary>

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
</details>





<details>
<summary><b> MySQL 高级:</b></summary>

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
</details>





<details>
<summary><b>MySQL 杂谈:</b></summary>

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
</details>


































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























<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>





<details>
<summary><b>my_name_is_jack</b></summary>

```  

```
</details>






