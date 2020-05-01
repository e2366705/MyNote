# Auto.JS
```  
Auto.js
Github地址:         https://github.com/hyb1996/Auto.js
Auto.js Pro[收费]   https://pro.autojs.org/
文档:               https://hyb1996.github.io/AutoJs-Docs/#/

Auto.js 需要开启: 
	1: 无障碍服务
	2: 悬浮窗

获取本机的ip地址:
Windows 10 cmd命令行:
	C:\Users\admin>ipconfig
   	IPv4 地址 . . . . . . . . . . . . : 192.168.1.100

在VS Code中菜单"查看"->"扩展"->输入"Auto.js"或"hyb1996"搜索,


Auto.js-VSCodeExt
Auto.js-Pro-Ext

安装这两个插件:
按 Ctrl+Shift+P 或点击"查看"->"命令面板"可调出命令面板，输入 Auto.js 可以看到几个命令:
	Start Server: 启动插件服务。之后在确保手机和电脑在同一区域网的情况下，在Auto.js的侧拉菜单中使用连接电脑功能连接。
	Stop Server: 停止插件服务。
	Run 运行当前编辑器的脚本。如果有多个设备连接，则在所有设备运行。
	Rerun 停止当前文件对应的脚本并重新运行。如果有多个设备连接，则在所有设备重新运行。
	Stop 停止当前文件对应的脚本。如果有多个设备连接，则在所有设备停止。
	StopAll 停止所有正在运行的脚本。如果有多个设备连接，则在所有设备运行所有脚本。
	Save 保存当前文件到手机的脚本默认目录（文件名会加上前缀remote)。如果有多个设备连接，则在所有设备保存。
	RunOnDevice: 弹出设备菜单并在指定设备运行脚本。
	SaveToDevice: 弹出设备菜单并在指定设备保存脚本。
	New Project（新建项目）：选择一个空文件夹（或者在文件管理器中新建一个空文件夹），将会自动创建一个项目
	Run Project（运行项目）：运行一个项目，需要Auto.js 4.0.4Alpha5以上支持
	Save Project（保存项目）：保存一个项目，需要Auto.js 4.0.4Alpha5以上支持


新建一个 xxxxxxx.js 文件, 然后用 VS code 打开,
然后,
在电脑上的 VS code 里面快捷键: Ctrl+Shift+P 输入: Start Server 来启动服务,
然后在安卓手机的 Auto.js 里面开启`连接电脑`的按钮

运行程序
app.launchApp("微信")
app.launchApp("QQ")

alert("您好");

```





