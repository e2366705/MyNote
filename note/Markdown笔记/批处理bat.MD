# 批处理 (bat文件)
---



## 关于 VBS 脚本控制鼠标的操作(需要安装 Excel )
####  教程来源:  https://www.jvruo.com/archives/108/
<details>
<summary><b>控制鼠标</b></summary>


```  




这段代码不需要安装 Excel 
set ws = createobject("wscript.shell")

rem 运行记录本程序进行测试发送按键
ws.run("notepad")

rem 暂停0.1秒,防止程序还没启动就发送按键
wscript.sleep(100)

rem 输入1个x
ws.sendkeys("x")

rem 回车
ws.sendkeys("{enter}")

rem 输入10个x
ws.sendkeys("{x 10}")

rem 回车
ws.sendkeys("{enter}")

rem 输入不同字符
ws.sendkeys("sendkeys")

rem 组合键使用:ctrl + a
ws.sendkeys("^a")

rem win键: ctrl + esc
rem ws.sendkeys("^{esc}")

set ws = nothing

rem -----------------特殊键代码-----------------
rem 退格键		{backspace}或{bs}或{bksp}
rem break		{break}
rem caps lock		{capslock}
rem num lock 		{numlock}
rem del/delete 		{del}或{delete}
rem ins/insert		{ins}或{insert}
rem 回车/换行		{enter}
rem 方向:下 		{down}
rem 方向:上 		{up}
rem 方向:左 		{left}
rem 方向:右		{right}
rem 换页:上		{pgup}
rem 换页:下 		{pgdn}
rem home		{home}
rem end 		{end}
rem esc 		{esc}
rem help 		{help}
rem tab 		{tab}
rem shift 		+
rem ctrl 		^
rem alt 		%
rem + 			{+}
rem ^			{^}
rem %			{%}
rem F1至F12		{F1}至{F12}
rem win键		^{esc}
rem -----------------特殊键代码-----------------




这段代码需要安装 Excel (控制鼠标 )
移动鼠标到桌面坐标200,50的vbs：
CreateObject("WScript.Shell").Run "mouse.exe m,200,50"

点击鼠标左键的vbs：
CreateObject("WScript.Shell").Run "mouse.exe l"

点击鼠标右键的vbs：
CreateObject("WScript.Shell").Run "mouse.exe r"

双击鼠标左键的vbs：
CreateObject("WScript.Shell").Run "mouse.exe d"

```
</details>








---



## 注意, 关于中文乱码的问题
```  

中文(Chinese)乱码?

因为 Windows下默认的bat的编码格式是UTF-8，这时只需将其转换成ANSI 格式即可
右击bat文件 -> 编辑 -> 另存为 -> ANSI格式 -> 保存即可
注意!! 一定要用 Windows 自带的文本编辑器打开, 用别的编辑器打开会乱码(比如 VS Code)

```






<details>
<summary><b>基础:</b></summary>

```  
注释:
    echo ------------------------大家好!我是注释--------------------------------------
    :: 这是注释

暂停, 也就是那个黑框框不会马上消失:
    PAUSE

这也是暂停 (黑框框不消失):
    cmd /k

打开程序(两种方式):
    echo 准备启动Thunder。。。   
    start /min "" "D:\XXX\Thunder.exe"

    echo "打开Chrome浏览器"
    start "" "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"


打开文件夹:
    start /min "" "F:\XXX\springMVC"


打开文件(实现播放音乐):
    start "" "D:\clock.mp3"


这两种打开方式有什么区别?
    start /min "" "D:\XXX\Thunder.exe"      这一种会以最小化的方式打开 ( /min )
    start "" "D:\XXX\Thunder.exe"           这一种会在打开的同时, 最大化


关闭进程:
    taskkill /F /IM firefox.exe
    taskkill /f /im cloudmusic*     结束以cloudmusic开头的所有进程,也就是关闭网易云音乐程序
    taskkill /f /im abc*            结束以abc开头的所有进程
    taskkill /f /im .bat            结束所有扩展名为bat的进程，也就是结束当前正在运行的所有批处理程序
    taskkill /f /im a.cmd           结束以a开头的所有扩展名为cmd的进程，也就是结束当前所有以a开头的批处理程序


等待 x 秒:
    sleep 45
    taskkill /F /IM Chrome.exe

等待 xxx 秒之后执行:
    choice /t 120 /d y /n >nul

    9秒之后 kill 腾讯QQ
    choice /t 9998 /d y /n >nul
    taskkill /f /im qq.exe

```
</details>








---
# 实战(小案例)
<details>
<summary><b>批处理_xxx秒后运行xxx程序</b></summary>

```  

@echo off
for /L %%a in (
 5,-1,0
) do (
 echo 5秒后将运行python.exe
 echo 还剩余 %%a 秒
 ping -n 2 localhost 1>nul 2>nul
 cls
)
start python.exe
PAUSE


```
</details>













<details>
<summary><b>批处理移动(复制)文件</b></summary>

```  

move /Y D:\BaiDuProductDownloadYXB\*.png D:\pic\
move /Y D:\BaiDuProductDownloadYXB\*.jpg D:\pic\
move /Y D:\BaiDuProductDownloadYXB\*.jpeg D:\pic\
move /Y D:\BaiDuProductDownloadYXB\*.txt D:\Txt\
move /Y D:\BaiDuProductDownloadYXB\*.torrent D:\Torrent\
move /Y D:\BaiDuProductDownloadYXB\*.mp3 D:\MP3\


```
</details>













<details>
<summary><b>不停循环执行某个程序</b></summary>

```  

120秒执行一次

@echo off
:start
echo Clear......
choice /t 120 /d y /n >nul
start "" "C:\Program Files (x86)\LuDaShi\LuDaShi\sweeper\MemoryOptimizer.exe" /optimize"
goto start


```
</details>













<details>
<summary><b>开机自启动程序</b></summary>

```  

echo "火狐浏览器"
start "" "C:\Program Files\Mozilla Firefox\firefox.exe"

echo "火狐开发专业版"
start "" "C:\Program Files\Firefox Developer Edition\firefox.exe"

echo "Chrome浏览器"
start "" "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"

echo "世界之窗浏览器"
start "" "C:\Users\QAQ\AppData\Local\TheWorld6\Application\TheWorld.exe"

echo "Windows任务管理器"
start "" "C:\Windows\System32\taskmgr.exe"

echo "*********************___UC_Browser___*********************"
start "" "C:\Program Files (x86)\UCBrowser\Application\UCBrowser.exe"

echo "*********************___QQ_Music_Player___*********************"
echo 批处理暂停8秒
choice /t 8 /d y /n >nul

start "" "C:\HanHong.mp3"

echo "批处理程序运行完不关闭窗口"
cmd /k


```
</details>


















<details>
<summary><b> 批量重命名文件名 </b></summary>

```  

方式一(简化版):
@echo off

rem 前言:  批处理文件一定要用 ANSI 格式, 不然中文会乱码...
rem 启用"延缓环境变量扩充"
rem 现有一堆 txt 文本文件, 我想要按照指定格式批量重命名:

setlocal EnableDelayedExpansion
set a=1

rem 循环当前目录下所有图片的文件名，支持带空格的名称
for /f "delims=" %%i in ('dir /b *.txt') do (

rem 如果没有相同的文件名，则继续
if not "%%~ni"=="%~n0" (

ren "%%i" "A_!a!.txt"

rem 设置数值型变量a=a+1
set /a a+=1
)
)

echo 批量重命名完成！
pause





方式二(带循环控制版):
@echo off

rem 前言:  批处理文件一定要用 ANSI 格式, 不然中文会乱码...
rem 启用"延缓环境变量扩充"
rem 现有一堆 txt 文本文件, 我想要按照指定格式批量重命名:

setlocal EnableDelayedExpansion
set a=1

rem 循环当前目录下所有图片的文件名，支持带空格的名称
for /f "delims=" %%i in ('dir /b *.txt') do (

rem 如果没有相同的文件名，则继续
if not "%%~ni"=="%~n0" (

rem   LSS -> 表示循环次数 :  LSS 15 就是循环15次
if !a! LSS 999 (ren "%%i" "A_00!a!.txt") else ren "%%i" "A_!a!.txt"

rem 设置数值型变量a=a+1
set /a a+=1
)
)

echo 批量重命名完成！
pause





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








