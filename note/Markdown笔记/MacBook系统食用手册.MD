# MacBook系统食用手册



### MacBook 怎么进行剪切操作?
```  
	第一步：command+C 复制
	第二部：option+command+ V 即可实现剪贴
```





### 怎么强制退出某些软件?
option + command + esc     强制退出







### 删除键 Delete 的用法大全
Fn + Delete        删除光标之后的一个字符(编辑文本中)
Option + Delete    删除光标之前的一整个单词(只对单词有效)
Command + Delete   删除光标之前一整行文字
单击文件选中, 然后 Command + Delete 删除该文件(删除软件也是这个操作, 只不过需要到Finder里面删除才行)


### 删除程序
打开Finder , 单击app选中, 然后 Command + Delete 删除该程序, 需要你输入mac开机密码








### 苹果电脑里面如何调整命令行窗口的显示字体大
```  
两个方法：
1.打开终端后进入终端的偏好设置，选择设置，更改字体。
2.进入终端后comman键和+键的组合可以增大显示。

制作替身”就是Windows系统下的“创建快捷方式”

```













### mac程序坞有延时?
```  
一行代码可以干掉！！！
		defaults write com.apple.Dock autohide-delay -float 0 && killall Dock
也是可以恢复延时的：
		defaults delete com.apple.Dock autohide-delay && killall Dock
网页链接： https://www.jianshu.com/p/565adbe0aff1

```








### 其他 MacOS 设置:
```  

https://www.jianshu.com/p/0f620fc47ebb
https://jingyan.baidu.com/article/0964eca259e0618284f53663.html
https://jingyan.baidu.com/article/a65957f4ed1bd324e77f9b6a.html
https://blog.csdn.net/aerchi/article/details/74757910
https://blog.csdn.net/usydapeng/article/details/16943553

```









### MacBook下的一些命令行操作:
```  
/usr/libexec/java_home -V  查看Java的安装目录和版本,以及系统默认的Java版本

在终端开启/关闭/重启,MacBook自带的Apache服务器:
sudo apachectl start
sudo apachectl stop
sudo apachectl restart

在终端进入某个文件夹:
cd /Library/WebServer/Documents

查看文件目录以及文件
ls -l
ls -lh   (加上h之后,文件的大小就显示为比较直观的显示方式了)

返回根目录:
cd /

查看文件内容
cat httpd.conf

编辑文件:
vim httpd.conf

编辑完成之后,按Esc按键,
然后按shift+: 键 , 然后输入wq 回车,保存退出编辑 ,
或者是:输入q,不保存退出;
或者是:输入!q 回车 强制退出

进入桌面:
cd /users/My_Mac/Desktop
cd .. 跳转到当前路径的上一层
pwd：显示当前操作的路径(绝对路径)
clear：清屏
tab键：自动补全

touch：创建一个文件，linux中没有后缀的说法，所有文件名自定义
mkdir a在当前路径下创建a文件夹
rmdir：删除空文件夹
rm：删除一个普通文件夹，会有提示，要删除的东西是个文件夹
rm xxx -r：递归删除文件夹，不提示

https://blog.csdn.net/hellocsz/article/details/81255417

```






