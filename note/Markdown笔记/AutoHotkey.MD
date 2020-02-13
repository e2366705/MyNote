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

; 打开一个文件夹
Run C:\D\YXB___Download___\HBuilderX


打开应用程序:
;快捷键 alt + n 打开记事本
!n::Run notepad

;快捷键 alt + y 打开百度云管家
!y::Run H:\GanJingYunV2\BaiduYunGuanjia.exe

按 alt + b 打开百度
!b::Run www.baidu.com


睡眠 / 暂停
睡眠 3 秒
sleep, 3000


粘贴命令(Ctrl + V ):
Send ^v{enter}

; 最大化活动窗口
WinMaximize, A  





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









鼠标:

MouseMove, X, Y [, Speed, R]
鼠标移动的目标位置的 x/y 坐标, 可以为 表达式. 坐标相对于活动窗口

Speed : 移动鼠标的速度，介于 0（最快）和 100（最慢）之间，可以为表达式
    注：速度为 0 表示瞬时移动鼠标到目标位置。如果省略，则使用默认速度

R:  如果此参数为字母 R, 则会把 X 和 Y 坐标视为距离当前鼠标位置的偏移. 
    换句话说, 会把光标从当前位置往右移动 X 像素 (负值则往左) 且往下移动 Y 像素 (负值则往上).




键盘移动鼠标位置
*#up::MouseMove, 0, -10, 0, R  ; Win + UpArrow(上方向键)键 => 上移光标
*#Down::MouseMove, 0, 10, 0, R  ; Win + DownArrow => 下移光标
*#Left::MouseMove, -10, 0, 0, R  ; Win + LeftArrow => 左移光标
*#Right::MouseMove, 10, 0, 0, R  ; Win + RightArrow => 右移光标


鼠标点击:
说明:
    LeftWin + RightControl => Right-click  (左 win 键 + 右 Ctrl 键 触发鼠标右键 )
    左键:
        LButton down
        LButton up
*<#RCtrl:: 
SendEvent {Blind}{RButton down}
KeyWait RCtrl  ; 防止键盘自动重复导致的重复鼠标点击.
SendEvent {Blind}{RButton up}
return


鼠标点击 (方式二):
Click  ; 在鼠标光标的当前位置点击鼠标左键.
Click 100, 200  ; 在指定坐标处点击鼠标左键.
Click 100, 200, 0  ; 移动而不点击鼠标.
Click 100, 200 right  ; 点击鼠标右键.
Click 2  ; 执行双击.
Click down  ; 按下鼠标左键不放.
Click up right  ; 释放鼠标右键.

说明:
    按住 win 键 + 右Ctrl键  ===>  移到坐标100, 200 这个位置, 然后点击鼠标右键
*<#RCtrl:: 
Click 100, 200 right  ; 点击鼠标右键.
return







```
</details>












<details>
<summary><b>基本语法: </b></summary>

```  


连接 / 拼接字符串:
  拼接恐怕是最常用的操作了，在 AHK 中也非常简单，直接将两个字符串用空格隔开就可以了


变量(两种方式):
MyNumber = 123
MyString = This is a literal string.
CopyOfVar = %Var%  ; 和 = 运算符一起使用时, 需要使用百分号来获取变量的内容.

MyNumber := 123
MyString := "This is a literal string."
CopyOfVar := Var  ; 和前面段落中与其作用相同的语句不同, 百分号不和 := 运算符一起使用.


有两种方法来清除变量的内容 (即让变量为空):
MyVar =
MyVar := ""


获取变量的内容:
  如同赋值有两种方法, 获取变量的内容也有两种方法: 
  传统方法和表达式方法. 
  传统方法需要将变量名包围在百分号中来获取变量的内容. 例如：
MsgBox The value in the variable named Var is %Var%.
CopyOfVar = %Var%




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





;  按下    Ctrl + win + c   获取当前鼠标坐标, 并打印出来 :
^#c::
MouseGetPos, mouseX, mouseY
PixelGetColor, color, %mouseX%, %mouseY%, RGB

; 坐标 (Coordinates)
Coordinates = %mouseX% + %mouseY%

; 把 坐标 (Coordinates) 的值发送到剪贴板
clipboard = %Coordinates%

sleep, 120
Send ^v{enter}
return






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
