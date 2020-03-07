

### 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力
* 安装 phpStudy 之后 , 这时候是不能用 cmd 命令行直接操作 MySQL 数据库的, 需要这么配置
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






### 一款 命令行 管理MySQL的工具, 叫做: MyCli , 支持自动补全关键字、表名、列和函数
* 在 0-IDE.MD 里面有详细的介绍


### MacOS 下 好用免费的 MySQL 客户端管理工具 : sequel pro , 亲测好用!!!
网址如下:
https://sequelpro.com/download












### SQL 规范 (必读!!!)
* 参考资料:
* https://choerodon.io/zh/docs/contributor-guide/development/conventions/sql
* https://www.jianshu.com/p/359ed85c3243
<details>
<summary><b> SQL 规范</b></summary>

```  

强制的 / 必须的 / 禁止的:
-----------------------------------------------------------------------------------------------

命名要规范, 一眼就可以看出来是什么:
	表名用: tb_xxx (意思是: table_xxx, 比如: tb_user) ,  非唯一索引名idx_xxx，唯一索引名uniq_xxx

* 任何字段如果为非负数，必须是 unsigned

* 必须把字段定义为NOT NULL并且提供默认值
解读：
	a）null的列使索引/索引统计/值比较都更加复杂，对MySQL来说更难优化
	b）null 这种类型MySQL内部需要进行特殊处理，增加数据库处理记录的复杂性；
		同等条件下，表中有较多空字段的时候，数据库的处理性能会降低很多
	c）null值需要更多的存储空，无论是表还是索引中每行中的null的列都需要额外的空间来标识
	d）对null 的处理时候，只能采用is null或is not null，而不能采用=、in、<、<>、!=、not in这些操作符号。
		如：where name!=’shenjian’，如果存在name为null值的记录，查询结果就不会包含name为null值的记录
	不使用is null或is not null，字段设计时建议not null，若麻烦可折中考虑给一默认值

* 不要把字段的值默认设置为 null, 有 bug , 切记切记~~ (2020-02-03 衡阳一次写项目亲测 )

* MySQL 在 Windows 下不区分大小写，但在 Linux 下默认是区分大小写。
	因此，数据库名、表名、字段名，都不允许出现任何大写字母，避免节外生枝

* 禁止存储大文件或者大照片
	何要让数据库做它不擅长的事情？大文件和照片存储在文件系统，数据库里存 URL 多好

* 禁止使用TEXT、BLOB类型
	会浪费更多的磁盘和内存空间，非必要的大量的大字段查询会淘汰掉热数据，导致内存命中率急剧降低，影响数据库性能	

* 禁止使用INSERT INTO t_xxx VALUES(xxx)，必须显示指定插入的列属性
	容易在增加或者删除字段后出现程序BUG		


* 经过测试, MySQL 必须给 varchar设置长度??? 


* 使用InnoDB存储引擎
	支持事务、行级锁、并发性能更好、CPU及内存缓存页优化使得资源利用率更高

* Java / python 应用程序必须捕获SQL异常，并有相应处理


* 同财务相关的金额类数据必须使用decimal类型
	非精准浮点：float,double
	精准浮点：decimal











表达逻辑删除的字段名 is_deleted， 1 表示删除， 0 表示未删除


表名不使用复数名词:
	表名应该仅仅表示表里面的实体内容，不应该表示实体数量，对应于 DO 类名也是单数形式，符合表达习惯

小数类型为 decimal，禁止使用 float 和 double:
	float 和 double 在存储的时候，存在精度损失的问题，很可能在值的比较时，得到不正确的结果。
	如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数分开存储



表必备字段： 
	id,
	create_date,
	last_update_date,
	create_by,
	last_update_by,
	object_version_number
	其中 id 必为主键，类型为 unsigned bigint、单表时自增、步长为 1
	create_date, last_update_date 的类型均为 datetime 类型，前者现在时表示主动创建，后者过去分词表示被动更新


合适的字符存储长度，不但节约数据库表空间、节约索引存储，更重要的是提升检索速度:
	正例： 如下表，其中无符号值可以避免误存负数，且扩大了表示范围
	----------------------------------------------------------------------------------
	对象		年龄区间			类型		字节			表示范围
	人			150岁之内	unsigned tinyint	1		无符号值： 0 到 255
	龟			数百岁		unsigned smallint	2		无符号值： 0 到 65535
	恐龙化石	 数千万年	 unsigned int	    4		 无符号值： 0 到约 42.9 亿
	太阳		约 50 亿年	 unsigned bigint	8		无符号值： 0 到约 10 的 19 次方


不要使用 count(列名)或 count(常量)来替代 count(\*)， 
	count(*)是 SQL92 定义的标准统计行数的语法，跟数据库无关，跟 NULL 和非 NULL 无关
	count(*)会统计值为 NULL 的行，而 count(列名)不会统计此列为 NULL 值的行	
	count(distinct col1, col2) 如果其中一列全为 NULL，那么即使另一列有不同的值，也返回为 0



使用 ISNULL()来判断是否为 NULL 值
	说明： NULL 与任何值的直接比较都为 NULL
	NULL<>NULL 的返回结果是 NULL， 而不是 false
	NULL=NULL 的返回结果是 NULL， 而不是 true
	NULL<>1 的返回结果是 NULL，而不是 true


如果需要存储表情，那么选择 utf8mb4 来进行存储，注意它与 utf-8 编码的区别

sql.xml 配置参数使用： #{}， #param# 不要使用${} 此种方式容易出现 SQL 注入


Select * from opp WHERE phone=‘12347856' or phone=‘42242233';
考虑用
Select * from opp WHERE phone in ('12347856' , '42242233');


用Where子句替换HAVING子句
select id,count(*) from table group by id having age>=30 order by null;
考虑用
select id,count(*) from table where age>=30 group by id order by null;



必须使用varchar(20)存储手机号
解读：
	a）涉及到区号或者国家代号，可能出现+-()
	b）手机号会去做数学运算么？
	c）varchar可以支持模糊查询，例如：like“138%”


禁止使用SELECT *，只获取必要的字段，需要显示说明列属性
解读：
	a）读取不需要的列会增加CPU、IO、NET消耗
	b）不能有效的利用覆盖索引	
	c）使用SELECT *容易在增加或者删除字段后出现程序BUG



禁止在WHERE条件的属性上使用函数或者表达式
	错误的写法:
		SELECT uid FROM t_user WHERE from_unixtime(day)>='2017-02-15'会导致全表扫描
	正确的写法是：
		SELECT uid FROM t_user WHERE day>= unix_timestamp('2017-02-15 00:00:00')



如果明确知道只有一条结果返回，limit 1能够提高效率
	你知道只有一条结果，但数据库并不知道，明确告诉它，让它主动停止游标移动


```
</details>













### 批处理自动备份脚本(.bat for Windows10):
* 注意!! 一定要用 Windows 自带的文本编辑器打开, 用别的编辑器打开会乱码(比如 VS Code)
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





















### 基础:
<details>
<summary><b>基础-001</b></summary>

```  

命令行:
	MySQLi -u用户名 -p密码

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


-- 是否存在这个数据库, 如果是, 删除它
drop database IF EXISTS `zzza9d2g5k4t1b0k`;

-- 创建 数据库:
CREATE DATABASE IF NOT EXISTS `zzza9d2g5k4t1b0k` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- 切换回
use `zzza9d2g5k4t1b0k`;

-- 创建表
CREATE TABLE IF NOT EXISTS `tb_user`(
`id`         int(20)         unsigned not null DEFAULT 0,
`money`      DECIMAL(20,2)   NOT NULL DEFAULT '0.00',
`username`   VARCHAR(100)    not null DEFAULT '', 
`password`   VARCHAR(40)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- other 选项:
-- 无符号		                  unsigned (只能是正数)
-- 有符号		                  signed
-- 主键		                      Primary key
-- 不可重复		                  UNIQUE 
-- 非空, 并设置默认字符            NOT NULL DEFAULT '', 


-- 插入insert数据:
insert into `user`(username,password) values('HUAWEI','mate20');
insert into `user`(username,password) values('APPLE','IPHONE_5S');
insert into `user`(username,password) values('OPPO','R11');		







建表的时候注释(字段和表注释):
	CREATE TABLE IF NOT EXISTS `tb_word`(
	`word` varchar(12) not null UNIQUE DEFAULT ''COMMENT 'YXB天下第一老牛逼了',
	`username` VARCHAR(12) not null DEFAULT ''
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表注释'



查看注释(展示表的所有):
	show full columns from `tb_user`

展示创建表的时候的语句:
	show create table `tb_user`;


修改表/字段的注释
修改表注释
	alter table t_user comment  = '修改后的表注释信息(用户信息表)';

修改字段注释
	alter table t_user modify column id int comment '主键ID';




```
</details>












<details>
<summary><b>1 增:</b></summary>

```  
多种排序测试用
insert into `user`(  `username` , `password`  ) VALUES('aaa','999'); 


insert 插入数据(两种方式)
	insert into `user`(username,password) values('HUAWEI','mate20');
	insert into `users` values ('AAA','BBB','CCC');
	

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
UPDATE `table_name` SET `phrase`="AAA" , `chinese_meaning`="BBB" WHERE `word`='CCC';

设置为 null
UPDATE `table_name` SET `chinese_meaning` = null WHERE `state` = 'Very_familiar'

随机更改表中 date 字段的值为 '------------' (数量为123条)
UPDATE `table_name` SET `date` = '------------' ORDER BY RAND() LIMIT 123;

```
</details>








<details>
<summary><b>4 查</b></summary>

```  


选择出是 null 的项目 3 条:
	SELECT * FROM `user` where `name` is null LIMIT 0,3;

查询 table_ten_thousand_word 表中，word 字段值重复的数据及重复次数
	select `word`,count(*) as COUNT FROM `table_ten_thousand_word` group by `word` having count>1;

展示表中所有数据
	select * from `user`;


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



GROUP BY:
	GROUP BY             去掉重复
	ORDER BY RAND        随机
	排除重复的,筛选出不同的
		SELECT `username` FROM `user_yxb`  GROUP BY `username`;


	排除重复的:
		select distinct username from user;	

	查找重复的数据:
		select * from `people`
			where 
		`Id` in (select `Id` from `people` group by `Id` having count(`Id`) > 1)





升序 / 降序 查询:
	降序
	select * from `student` order by `class` desc;
	
	cno升序 , password降序
		select * from `score` order by `cno` asc , `password` desc;


查询字段`word`长度等于 5 的:
	select * from `words_warehouse`  where length(`word`) = 5;	


LIMIT 36		数量为 36 条
select *  from phrase GROUP BY `phrase` ORDER BY RAND() LIMIT 36


当 xxx 不为空 , 且 yyy 为空时:
select `word` from `phrase` where `state` IS NULL and `word` is not null


查询符合条件(aaa或者bbb或者ccc)的项目
	select * from score where username in ('aaa','bbb','ccc');  


MySQL或者查询
	select * from student where class='12306' or sex='女';  


select count(*) from student where class='2333';       统计符合条件的数量

MySQL查询最高分----> 语句太长,懒得写了,用时再百度吧...		


```
</details>











<details>
<summary><b>5 alter</b></summary>

```  


删:
删除主键
alter table `student` drop primary key;

删除表的字段:
alter table `表名` drop column `字段名`

删除主键
ALTER TABLE `user` DROP PRIMARY KEY

删除表中某个字段的unique key:
ALTER TABLE `good_booked` DROP INDEX `good_id`;










改:
设置为主键:
alter table `student` add primary key(`id`)
(注意:执行这句代码时候,会报错,原因是原来的字段都是null值,所以设置不成功,
设置为唯一键 效果是一样的)

设置为唯一键
alter TABLE `test2` add UNIQUE (`userid`)

给字段添加默认值 : 
ALTER TABLE `数据表` ALTER COLUMN `字段` SET DEFAULT '默认值';

重命名 表名:
ALTER TABLE `word` RENAME TO `tb_word`


修改字段名称和属性 ( 将AAA字段改为BBBB ) :
ALTER TABLE 表名    CHANGE 原字段名    新字段名    字段类型     约束条件 ; 
ALTER TABLE user10  CHANGE `AAA`      `BBBB`     CHAR(32)   NOT NULL DEFAULT '123';


修改字段类型
alter table 表名 modify column 字段名 类型;    (注意: 一定要带上你要修改的数据类型)
alter table `user` modify column `name` varchar(256) not null default ''
注意: 如果修改字段数据失败,可能是MySQL为了数据安全,加了保险
(比如text类型的字段转化为int类型->大数据类型转小数据类型,这样子就可能会丢失数据)









增:
增加一个唯一字段
alter table `phrase` add `word` VARCHAR(66) UNIQUE not null

增加一个 date 类型的字段
alter table tb_yxb ADD `date_3` date not null default 0

增加一个主键字段
alter table `student` add `word` VARCHAR(66) PRIMARY KEY


增加一个非空字段
alter table `table1` add transactor varchar(10) not Null;

增加一个自增 + 主键字段
alter table `table1` add id int unsigned not Null auto_increment primary key





```
</details>

















<details>
<summary><b> 6:增 或 更 </b></summary>

```  

MySQL REPLACE语句是标准SQL的MySQL扩展。 MySQL REPLACE语句的工作原理如下：
	如果给定行数据不存在，那么MySQL REPLACE语句会插入一个新行
	如果给定行数据存在，则REPLACE语句首先删除旧行，然后插入一个新行。 在某些情况下，REPLACE语句仅更新现有行

	REPLACE INTO `tb_word`(`word` , `state`) VALUES ('come' , 'Very_familiar');

如果数据库里面没有这条记录, 
	那么执行这句 SQL 就是新增一条语句, 
	那么受影响记录行数: 1 

如果数据库里面有这条记录, 但是数据不对
	那么执行这句 SQL 就是先删除这条记录, 
	然后新增一条记录, 
	那么受影响记录行数: 2

如果数据库里面有这条记录, 而且数据都完全相同
	那么受影响记录行数: 1
	

```
</details>























<details>
<summary><b> 判空 IFNULL  </b></summary>

```  


IFNULL(v1,v2);
解读:	如果 v1 不为 NULL，
			则 IFNULL 函数返回 v1; 
			否则返回 v2 的结果

SELECT 
	IFNULL(5,8),
	IFNULL(NULL,'OK'),
	IFNULL(SQRT(-8),'FALSE'),
	SQRT(-8);

由执行结果可以看出:
IFNULL(v1,v2) 函数中的参数 v1=5、v2=8，都不为空，即 v1=5 不为空，返回 v1 的值为 5；
当 v1=NULL 时，返回 v2 的值，即字符串 'OK'；
当 v1=SQRT(-8) 时，SQRT(-8) 函数的返回值为NULL，即 v1=NULL，所以返回 v2 为字符串 'false'


实战:
	如果变量aaa为 null, 那么 state = 'Very_familiar'
SET @aaa = null ;
SELECT *
FROM `tb_word` WHERE state = IFNULL(@aaa , 'Very_familiar')



if 判断:

用 @ 来声明一个变量:
意思解读:
	如果变量 aaa 为空, 		那么`date` = '2020-02-10'
	如果变量 aaa 不为空, 	那么`date` = '2020-02-08'

SET @aaa = null;
select count(*) from tb_word 
 	where
IF(@aaa IS NULL, 
		`date` = '2020-02-10' , 
		`date` = '2020-02-08'); 


用法二:

意思解读:
	如果变量 aaa 为空 或者 aaa = '' 或者 aaa = ' '
		那么取消条件筛选(''=''), 等同于: select count(*) from tb_word 
	如果变量 aaa 不为空:
		假设 @aaa = '2020-02-11', 		
		那么采用条件筛选( `date` = @aaa ), 等同于: select count(*) from tb_word where `date` = '2020-02-11'
SET @aaa = null;
select count(*) from tb_word 
 	where
IF(@aaa IS NULL  OR  @aaa = ''  OR  @aaa = ' ', 
		''='',
		`date` = @aaa)
and collection = 'collected' 


Spring Boot中:
如果  #{is_Collected} 为空, 
	那么 `collection` = 'collected'
and IF( #{is_Collected} IS NULL , ''='' ,  `collection` = 'collected'   )     

		

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


































### 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力
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






