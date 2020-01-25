


# 以后不要折腾MySQL客户端了, 简直就是浪费时间, 直接下载一个 phpStudy 直接用里面内置的MySQL, 又省心又省力


# 安装教程:  https://www.cnblogs.com/laumians-notes/p/9069498.html

## 下载 zip 安装包
## 直接解压
## 不需要添加path目录

## 在解压后的目录下面 , 新建一个 my.ini 文件 , 里面内容是:
```  
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=E:\\software\\mysql\\mysql-8.0.11-winx64   # 切记此处一定要用双斜杠\\，单斜杠我这里会出错，不过看别人的教程，有的是单斜杠。自己尝试吧
# 设置mysql数据库的数据的存放目录
datadir=E:\\software\\mysql\\mysql-8.0.11-winx64\\Data   # 此处同上
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。这是为了防止有人从该主机试图攻击数据库系统
max_connect_errors=10
# 服务端使用的字符集默认为UTF8
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“mysql_native_password”插件认证
default_authentication_plugin=mysql_native_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8

```




## 注意：其中的data目录不需要创建，下一步初始化工作中会自动创建
## 在安装时，必须以管理员身份运行cmd，否则在安装时会报错，会导致安装失败的情况


## 在MySQL安装目录的 bin 目录下执行命令:
mysqld --initialize --console


## 执行完成后，会打印 root 用户的初始默认密码，比如：
... A temporary password is generated for root@localhost: rI5rvf5x5G,E
其中root@localhost:后面的“rI5rvf5x5G,E”就是初始密码（不含首位空格）。在没有更改密码前，需要记住这个密码，后续登录需要用到

## 要是你手贱，关快了，或者没记住，那也没事，删掉初始化的 datadir 目录，再执行一遍初始化命令，又会重新生成的。当然，也可以使用安全工具，强制改密码，用什么方法，自己随意


## 在MySQL安装目录的 bin 目录下执行命令：
mysqld --install MySQL_YXB
## 后面是服务名


## 在MySQL安装目录的 bin 目录下执行命令：
mysql -u root -p


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '新密码'; 

## 修改密码完成...