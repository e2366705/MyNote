# MacBook系统食用手册



### MacBook 怎么进行剪切操作?
```  
	第一步：   command+C 复制
	第二步：   option+command+ V 即可实现剪贴
```



## 快捷键
```  

option + command + L         打开浏览器的下载历史
Command + R                  浏览器刷新网页
Command + W                  关闭当前标签页
option + command + esc       强制退出
Ctrl + 右上角倒三角图标       实现关机
Ctrl + command + Q           锁定电脑

command + F                  视频全屏
Ctrl + command + F           软件全屏


在 访达 里面按下快捷键 command + shift + G  
输入文件夹路径
直接进入这个文件夹

finder 里面: option + command + C 复制文件的路径

```











### Mac 好用软件
```  

hidden bar :
    可以管理 Mac 状态栏, 
    mac 的状态栏有时候软件太多太乱
    需要整理一下
    Google 搜 : hidden bar就可以了
    这款软件是开源的:   https://github.com/dwarvesf/hidden

MySQL 客户端管理工具:
    Sequel Pro，仅支持 Mac，功能强大，开源免费，强烈推荐    


```

















### 删除键 Delete 的用法大全
```  
Fn + Delete        删除光标之后的一个字符(编辑文本中)
Option + Delete    删除光标之前的一整个单词(只对单词有效)
Command + Delete   删除光标之前一整行文字
单击文件选中, 然后 Command + Delete 删除该文件(删除软件也是这个操作, 只不过需要到Finder里面删除才行)

```









### 删除程序
```  

打开Finder , 单击app选中, 然后 Command + Delete 删除该程序, 需要你输入mac开机密码


```












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





















# iMovie 
### iMovie 中编辑 mkv 格式的视频
```  

在电影编辑中，
有些电影有多条音轨：
中文的，英文的

这样编辑电影的效果很差

所以就需要用软件去掉其他音轨
mkvtoolnix 就可以去掉其他的音轨

但是
mkvtoolnix 只能转出 mkv 格式的视频
要知道，苹果的 iMovie 只支持 MP4 格式的视频编辑

所以 ， 又要 把 mkv 格式转换成 MP4 格式的视频
用 HandBrake 把 mkv 进行格式转换 
https://www.bilibili.com/video/av53739050?from=search&seid=8672297403252644910

唉~ 真是麻烦~~~

```













### 基础
```  

iMovie 的快捷键:

L K J
    按下 L 播放素材 , K 停止播放素材
    连按下两下 L 快进播放素材, 连按三下 L 加速快进播放素材
    连按两下或三下 J 快速的回看素材


i o
    快捷键 i 设定素材的入点, 按下 o 设定素材的出点


f u
    f 设置该素材为喜欢
    u 表示取消喜欢 或 拒绝


Delete
    Delete 键可以将素材标识为拒绝
    Delete 键在时间轴上, 表示删除这个片段


e w q
    选择好时间片段, 按下 e 就能把素材添加到时间线的末尾
    w 就能把素材添加到浏览头的位置上
    Q 就能把素材添加到时间线的上方


时间轴缩放:
    触控板双指捏合实现时间线缩放
    Command 和 + 调整时间线缩放
    Shift 和 Z 瞬间回到原来的缩放

还原 / 撤销还原:
    Command + Z  表示还原操作
    Shift + Command + Z 撤销还原操作

切割片段:
    浏览头放在你要切割的片段上边, 然后 Command + B 切割片段
    多选几个片段, 可以一次性切割多个片段

Option:
    如果你只想保留被选中的那一部分, 前后都不需要, 按下 Option + / , 就可以删除其他视频片段, 保留选择的片段
    按下 option 鼠标拖动素材, 可以快速复制一个素材



N 
    N 表示开启/关闭吸附功能


R 键的用法:
    删除片段还有一个方式:
    按住 R 键不松, 然后拖拽选择不需要的视频片段部分, 然后点击删除(Delete键)
    按住 R , 拖拽一个选区, 就可以单独的调整音量的大小了
    如果只是想针对视频的某一部分加速或者减速, 按住键盘 R , 框选你选择的区域, 点击监视区的加速或者减速



Shift + Command + M 
    让你所选的片段静音



精准的控制浏览头:
    按下键盘的上下方向键, 就可以快速的在片段的头尾跳转

    按下 K 不松, 按下 L 或者 J 就可以控制最精细的画面移动
    按下 K 不松, 按住 L 或者 J 就可以以最小的单元连续播放

    浏览片段: 任意位置选中这个片段, 按下键盘 / 就可以从头开始播放片段内容
                按下 / 再按下快捷键 Command + L , 就可以锁定片段循环播放




Command:
    选择一个片段 然后 Command + T , 就可以给这个片段的前后, 都添加交叉叠化的转场

    精细的调节音量, 按住 Command 再去拖拽音频的线, 就可以比较平稳的更改音量            

    调速:
        选中需要改变速度的片段, 按下 Command + R 视频片段右上方会出现调节速度的按钮, 向左拖拽视频变快(加速功能     



    调色:
        点击魔棒系统自动调整曝光和修正白平衡, 
        调色盘 饱和度调节, 拉到最低是黑白画面, 可以用来做去世的效果

        色调调节好了以后, 如果想把所有的影片都统一为这种色调
        Command + C 拷贝 , 然后选择其他片段 option + Command + C 就可以粘贴刚才那个片段的颜色属性到所选的所有片段了


    Ken Burns 可以给静止的画面和照片添加动态的效果



选中多个视频片段, 点击监视器右边的 i , 有一个调整时间长度的窗口, 输入同意变化的时间即可


        导出视频:
            质量选择 高 即可(不需要选择最佳)
            压缩选择 较快 即可


实战需求:
    添加图片
    图片移动 
    文字特效            


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






Macos查看 Java 版本
    java -version  查看版本
    /usr/libexec/java_home -V    查看 Java 安装详情
    /usr/libexec/java_home       查看 Java 安装路径




MacOS 下载最新版的 Python, 并且设置为默认:
---------------------------------------------------------------------- 
官方下载最新版的 Python : https://www.python.org/downloads/

终端输入:  python --version  查看python版本

终端输入 :  open ~/.bash_profile  编辑环境变量, 回车后会自动打开一个文本文件，我们可以直接修改里面的内容

我们只需要添加对应的alias即可(3.8是你下载的python版本):
alias python="/Library/Frameworks/Python.framework/Versions/3.8/bin/python3.8"

修改完成后command+s保存这个文件内容，然后重新打开终端:
source ~/.bash_profile

然后再重新打开终端:
python --version  查看python版本
可以看到mac自带python版本已经是我们安装的最新的python版本了




终端输入  clear   清屏

cd /Users/YXB/Library/Android   切换回xxx文件夹





```






