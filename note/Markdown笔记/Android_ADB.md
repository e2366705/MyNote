# Android_ADB




<details>
<summary><b> 链接 Android 手机 , 以及常用命令 </b></summary>

```  

无线连接:
保证手机与电脑在一个局域网中
确认手机ip，可以在WiFi信息中查看
本机ping 手机IP地址，如果成功，说明可连接
执行 adb connect 192.168.1.101:5555


查看 Android 手机的IP地址:
	设置 -> 系统 -> 关于本机 -> 状态信息 -> IP地址

查看网络是否正常
ping 192.168.1.101



开启服务(端口号xxxx 可以自定义的):
adb tcpip 5555

手机链接服务( 手机的IP地址 )
adb connect 192.168.1.101:5555

然后, 查看当前连接的安卓设备
adb devices

使用adb命令无线链接手机有可能会出现 "由于目标计算机积极拒绝，无法连接。 (10061)" 这种报错
可能是端口被占用了：

解决办法:
	使用如下adb命令可以查看端口使用情况：
	netstat -ano | findstr 5037

	按下回车会出现:
	  TCP    127.0.0.1:3895         127.0.0.1:5037         TIME_WAIT       0
	  TCP    127.0.0.1:3904         127.0.0.1:5037         TIME_WAIT       0
	  TCP    127.0.0.1:5037         0.0.0.0:0              LISTENING       6508
	  TCP    127.0.0.1:5037         127.0.0.1:3894         TIME_WAIT       0
	  TCP    127.0.0.1:5037         127.0.0.1:3895         TIME_WAIT       0
	  TCP    127.0.0.1:5037         127.0.0.1:3903         TIME_WAIT       0
	  TCP    127.0.0.1:5037         127.0.0.1:3904         TIME_WAIT       0
	  TCP    127.0.0.1:5037         127.0.0.1:3908         TIME_WAIT       0
	  TCP    127.0.0.1:5037         127.0.0.1:3909         TIME_WAIT       0
	  
	  可以看出进程5596占用了端口，这时找到5596，并关掉它就可以了
	  关掉之前可以先看看是什么进程，查看进程的命令:
	  tasklist |findstr 5037

	  关掉进程的命令:
	  taskkill /pid 5037 /f


此时再次尝试adb连接Android设备，如果还不行，则使用下面的最后一种方法:
	使用USB连接电脑，然后执行以下命令行：
	adb tcpip 5555

	在没有报错的前提下，断开USB，再使用命令:
	adb connect IP地址:5555
	
	此时就能连接Android设备了，如果还不行，对不起，我也没办法了！
	参考资料:   https://blog.csdn.net/MRYZJ/article/details/98446965





查看当前连接的安卓设备
adb devices


取消链接
adb disconnect (输出: disconnected everything)
adb disconnect 192.168.1.65:8888 (取消指定端口号链接)


停止服务(貌似不太管用)
adb stop-server

kill 进程 (常用)
adb kill-server


安装软件包
adb install /path/to/apk.apk

查看已安装的软件包
adb shell pm list packages

查看当前运行软件的详细信息, (包括包名):
adb shell dumpsys activity recents | find "intent={"

卸载已安装软件包
adb uninstall [package_name]
比如:
adb uninstall com.eg.android.AlipayGphone

查看当前所在目录
adb shell pwd

查看根目录下有哪些文件(夹)
adb shell ls /

查看磁盘挂载情况
adb shell df -h

上传文件到手机
adb push /local/path/to/file/filename /phone/file/path/to/save

从手机下载文件到本地
adb pull /phone/path/to/file/filename /local/file/path/to/save


```
</details>


























<details>
<summary><b> ================ </b></summary>

```  


```
</details>






