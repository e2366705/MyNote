# Autohotkey
> AutoHotkey 是一款 windows 平台下的热键脚本语言程序

---

# 基础

<details>
<summary><b> 基本功能: </b></summary>

```  

前言:  编辑脚本时使用英文输入法


注释:
;这里的 “分号” 表示注释


Run 代表运行一个程序，或打开文件、链接、文件夹等


打开应用程序:
;快捷键 alt + n 打开记事本
!n::Run notepad

;快捷键 alt + y 打开百度云管家
!y::Run H:\GanJingYunV2\BaiduYunGuanjia.exe

按 alt + b 打开百度
!b::Run www.baidu.com



热键标记
!       是热键标记，这里的感叹号代表键盘上的 alt 键
!n      即对应键盘热键 alt + n

常用热键标记对应关系:
# ：win 键
! ：alt
^ ：ctrl
+ ：shift





替换字符
输入 goo 自动替换为 http://www.Google.com

第一种写法:
::goo::http://www.Google.com

第二种写法:
::goo::
Send http://www.Google.com
return

AHK语法中： Send 是发送命令， return 是结束

然后，当我们输入文本 goo 按下 空格键 / 回车键 / tab 键时，会自动帮我们替换为http://www.Google.com

运行脚本后，windows10 右下角会有 AutoHotkey 的图标显示



autohotkey也是有 class 的:
用Win+c快速打开计算器，如果已经打开，激活计算器，如果已经激活就缩小它:
#c::
IfWinNotExist ahk_class CalcFrame
{
  Run calc.exe
  WinActivate
}
Else IfWinNotActive ahk_class CalcFrame
{
  WinActivate
}
Else
{
  WinMinimize
}
Return










```
</details>












<details>
<summary><b>基本语法: </b></summary>

```  

全局变量
全局变量比较好理解，如果一个变量是全局变量，那么程序中的所有代码都可以访问到这个变量（除非存在同名的局部变量或者静态变量）
全局变量用 global 定义:
a := 1
global b := 2
c := 3

fun()           调用这个方法
fun(){
    ; a 不是全局变量，访问不了，弹出空字符串
    MsgBox, % a

    ; b 是全局变量，弹出 2
    MsgBox, % b

    ; 在函数里也可以将 c 变成全局变量
    global c
    ; 弹出 3
    MsgBox, % c
}






循环:
最简单的情况，我们知道要循环多少次，比如想连续按下 10 次回车键：
Loop, 10{
    Send, {Enter}
}


参考资料:   https://zhuanlan.zhihu.com/p/20830259
这样就可以了。在 Loop 后加上要循环的次数，然后大括号里边就是要循环执行的语句。
当然我们可以先把循环的次数放进一个变量，这样更灵活些：
count := 10
Loop, %count%{
    Send, {Enter}
}




在函数里使用的变量通常是局部变量:
fun()
; a 并不是全局变量，弹出空字符串
MsgBox, % a
; b 是全局变量，弹出 2
MsgBox, % b
fun(){
    a := 1
    global b := 2
}



如果一个变量是需要全局有效的，那么使用全局变量。
但全局变量会导致代码的耦合度比较高，不方便维护，所以尽量少用,
有些看似需要使用全局变量的场景，其实使用函数的参数传递更合理



```

</details>













---







# 小案例:
<details>
<summary><b> 例子: </b></summary>

```  

Ctrl+Win+c来取色:

^#c::
MouseGetPos, mouseX, mouseY
; 获得鼠标所在坐标，把鼠标的 X 坐标赋值给变量 mouseX ，同理 mouseY
PixelGetColor, color, %mouseX%, %mouseY%, RGB
; 调用 PixelGetColor 函数，获得鼠标所在坐标的 RGB 值，并赋值给 color
StringRight color,color,6
; 截取 color（第二个 color）右边的6个字符，因为获得的值是这样的：#RRGGBB，一般我们只需要 RRGGBB 部分。把截取到的值再赋给 color（第一个 color）。
clipboard = %color%
; 把 color 的值发送到剪贴板
return





用Win+c快速打开计算器，如果已经打开，激活计算器，如果已经激活就缩小它:
#c::
IfWinNotExist ahk_class CalcFrame
{
  Run calc.exe
  WinActivate
}
Else IfWinNotActive ahk_class CalcFrame
{
  WinActivate
}
Else
{
  WinMinimize
}
Return




```
</details>






---





# 快捷键 :  Ctrl + 3 生成时间
```  
^3::send %A_YYYY%-%A_MM%-%A_DD% %A_Hour%:%A_Min%:%A_Sec%
```

# autohotkey 案例示范:
```  
::fk::举个例子: AutoHotkey 真是好用到爆!!!!! 强烈安利..... 嘤嘤嘤 ~ ~ ~


换行 :  `n


::boo::border: red solid 1px;
::bbb::background-color: pink;
::cl::console.log();
::al::alert();
::111::```````  `n`n`n```````
::whbg::width: 150px; height: 150px; background-color: skyblue;
::htmllll::<html lang="zh"><head><style>*{margin:0;padding:0;text-decoration:none;list-style-type:none}body{max-width:640px;min-width:320px;border:red solid 1px}</style><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"><meta http-equiv="X-UA-Compatible" content="ie=edge"><title>YXB</title><link rel="styleSheet" href="" type="text/css"><script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script></head><body><h1>YXB</h1></body><script type="text/javascript" src=""></script></html>

换行(适用于一大段文字的情况下):
::hhh::
clipboard=
(
aaaaaaaaaaaaaaaaaa
bbbbbbbbbbb
cccccccccc
)
Send ^v{enter}
Sleep, 1000
Return

```
